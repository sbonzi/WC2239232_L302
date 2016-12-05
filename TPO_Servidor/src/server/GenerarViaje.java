package server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import dao.EnvioDAO;
import dao.SucursalDAO;
import dao.VehiculoDAO;
import entities.Carga;
import entities.Envio;
import entities.Sucursal;
import entities.Vehiculo;
import entities.Viaje;

/**
 * Verifica cada X segundos si existen Envios en deposito
 *  pendientes a asignar a un nuevo viaje.
 *  Verifica la sucursal de origen de los envios para determinar los vehiculos que posee
 * @author Daniel PC
 *
 */
public class GenerarViaje extends TimerTask {
	private int iteraciones = 0;

    @Override
    public void run() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("(" + iteraciones + ")" + dtf.format(now) + " -- Inicia recorrido sucursales buscando envios en deposito --");
		List<Sucursal> sucursales = SucursalDAO.getInstancia().getSucursales();
		for(Sucursal sucursal:sucursales)
		{
			
			System.out.println("### Suc: " + sucursal.getNombre() + " " +sucursal.getDireccion() + " ###");
			
			List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
			vehiculos = VehiculoDAO.getInstancia().getVehiculosDisponiblesPorSucursal(sucursal);
			
			//Envios en deposito esperando ser asignados a un viaje
			List<Envio> envios = new ArrayList<Envio>();
			envios  = EnvioDAO.getInstancia().obtenerEnviosPorSucursalOrigen(sucursal);
			
			if(envios.size() > 0)
			{
				
				Hashtable<Integer,List<Envio>> enviosPorSucursalDestino = new Hashtable<>();
				List<Envio> enviosPreselec = new ArrayList<Envio>();
				
				//Organizando envios por sucursal destino
				for(Envio envio:envios)
				{
					if(enviosPorSucursalDestino.containsKey(envio.getSucursalDestino().getId())){
						enviosPreselec = enviosPorSucursalDestino.get(envio.getSucursalDestino().getId());
						enviosPreselec.add(envio);
						enviosPorSucursalDestino.replace(envio.getSucursalDestino().getId(),enviosPreselec);
					}else{
						enviosPreselec.add(envio);
						enviosPorSucursalDestino.put(envio.getSucursalDestino().getId(),enviosPreselec);
					}
				}
				
				System.out.println("**Envios organizados por sucursal destino para optimizar los viajes**");
				Set<Integer> idSucursalesDestino = enviosPorSucursalDestino.keySet();
				for(Integer idSucursalDestino:idSucursalesDestino)
				{

					/**
					* Generamos un Viaje y le asignamos un vehiculo disponible
					* El viaje irá calculando en base a la capacidad del vehiculo asignado,cuantos envios
					* entran.
					*/
					
					if(vehiculos.size() > 0)
					{
						//Tomamos el primer vehiculo disponible de la sucursal origen
						Vehiculo vehiculo = null;
						for(Vehiculo v:vehiculos){
							if(v.isHabilitadoParaUtilizar()){
								vehiculo = v;
								v.setHabilitadoParaUtilizar(false);
								break;
							}
						}
						
						if(vehiculo != null){
							//Preparamos un viaje a asignar envios
							Viaje viaje = new Viaje();
							viaje.setVehiculoDesignado(vehiculo);
							
							System.out.println("Se designó el vehiculo nro: " + viaje.getVehiculoDesignado().getId());
							
							List<Envio> enviosSucDestino = enviosPorSucursalDestino.get(idSucursalDestino);
							int cantidadEnvios = enviosSucDestino.size();
							for(Envio envioSucDestino:enviosSucDestino)
							{
								System.out.println("idEnvio: " + envioSucDestino.getIdEnvio());
								
								for(Carga c:envioSucDestino.getCargas()){
									System.out.println("	-idCarga: "+c.getId());
								}
								
								/**
								 * Pasamos cada envio al viaje generado para ver cuantos caben
								 */
								if(viaje.tengoCapacidadEnVehiculoAsignado(envioSucDestino))
								{
									boolean estaCompleto = viaje.agregarEnvioAVehiculoAsignado(envioSucDestino);
									
									cantidadEnvios--;
									
									/**
									 * El viaje se despacha si el vehiculo completa su capacidad de 70%+ o bien si queda un solo 
									 * envio en la sucursal ya que no podemos dejarlo esperando hasta que llegue otro envio
									 * para cubrir el cupo minimo de envio.
									 */
									if(estaCompleto || cantidadEnvios == 0)
									{
										if(viaje.despachar()){
											if(cantidadEnvios == 0){
												System.out.println("### Viaje despachado por ser ultimo envio en sucursal ###");
											}else{
												System.out.println("### Viaje despachado por vehiculo completo ###");
											}
										}
										
										//Si hay más envios a procesar, preparamos un viaje para la próxima ejecución
										if(enviosSucDestino.size() > 0)
										{
											if(vehiculos.size() > 0)
											{
												//Tomamos el primer vehiculo disponible de la sucursal origen
												for(Vehiculo v:vehiculos){
													if(v.isHabilitadoParaUtilizar()){
														vehiculo = v;												
														v.setHabilitadoParaUtilizar(false);
														break;
													}
												}		
												if(vehiculo != null){
													//Preparamos un viaje a asignar envios
													viaje = new Viaje();
													viaje.setVehiculoDesignado(vehiculo);
												}
											}
											else
											{
												System.out.println("No hay vehiculos disponibles");
											}
										}
										else
										{
											//Pasa al siguiente listado de envios
											break;
										}
									}else{
										System.out.println("### El vehiculo no está completo aún, sigue cargando envios ###");
									}
								}
								else
								{
									System.out.println("No hay más capadidad en el viaje actual para el envio nro: " + envioSucDestino.getIdEnvio());
									System.out.println("Se deja el envio pendiente para el proximo viaje a generar");
								}
							}
						}
					}
					else
					{
						System.out.println("No hay vehiculos disponibles");
					}
				}
			}else{
				System.out.println("Sin envios en deposito para la sucursal " + sucursal.getId());
			}
		}
		System.out.println("-- Fin recorrido sucursales buscando envios en deposito --");
		
		iteraciones++;
    }

    public static void main(String args[]){
    	iniciar();
    }
    
    public static void iniciar(){
        TimerTask timerTask = new GenerarViaje();
        Timer timer = new Timer(); 
        timer.scheduleAtFixedRate(timerTask, 0, 20000);
    }

}
