package server;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import businessDelegate.BusinessDelegate;
import dto.CargaDTO;
import dto.EnvioDTO;
import dto.EstadoEnvioDTO;
import dto.SucursalDTO;
import dto.VehiculoDTO;
import dto.ViajeDTO;
import exceptions.EnvioException;
import exceptions.SucursalException;
import exceptions.VehiculoException;

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
    	
    	try {
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    		LocalDateTime now = LocalDateTime.now();
    		
    		System.out.println("(" + iteraciones + ")" + dtf.format(now) + " -- Inicia recorrido sucursales buscando envios en deposito --");
			List<SucursalDTO> sucursales = new BusinessDelegate().getBusinessService().getSucursales();
			for(SucursalDTO sucursal:sucursales){
				
				System.out.println("### Suc: " + sucursal.getNombre() + " " +sucursal.getDireccion() + " ###");
				
				List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();		
				vehiculos = new BusinessDelegate().getBusinessService().getVehiculosDisponiblesPorSucursal(sucursal);
				
				//Envios en deposito esperando ser asignados a un viaje
				List<EnvioDTO> envios = new ArrayList<EnvioDTO>();
				envios 	= new BusinessDelegate().getBusinessService().getEnviosPorSucursalOrigen(sucursal);
				
				if(envios.size() > 0){
					
					Hashtable<Integer,List<EnvioDTO>> enviosPorSucursalDestino = new Hashtable<>();
					List<EnvioDTO> enviosPreselec = new ArrayList<EnvioDTO>();
					
					//Organizando envios por sucursal destino
					for(EnvioDTO envio:envios){
						if(enviosPorSucursalDestino.containsKey(envio.getSucursalDestino().getNumero())){
							enviosPreselec = enviosPorSucursalDestino.get(envio.getSucursalDestino().getNumero());
							enviosPreselec.add(envio);
							enviosPorSucursalDestino.replace(envio.getSucursalDestino().getNumero(),enviosPreselec);
						}else{
							enviosPreselec.add(envio);
							enviosPorSucursalDestino.put(envio.getSucursalDestino().getNumero(),enviosPreselec);
						}
					}
					
					System.out.println("**Envios organizados por sucursal destino para optimizar los viajes**");
					Set<Integer> idSucursalesDestino = enviosPorSucursalDestino.keySet();
					for(Integer idSucursalDestino:idSucursalesDestino){
						System.out.println("sucursalDestino: " + idSucursalDestino);
						
						List<EnvioDTO> enviosEnEspera 	= new ArrayList<EnvioDTO>();
						boolean hayEnviosEnEspera 		= false;
						float pesoTotalEnviosEnEspera	= 0;
						
						List<EnvioDTO> enviosSucDestino = enviosPorSucursalDestino.get(idSucursalDestino);
						for(EnvioDTO envioSucDestino:enviosSucDestino){
							System.out.println("	idEnvio: " + envioSucDestino.getIdEnvio());
							
							float pesoTotalCargasEnvio	= 0;
							
							//Calculamos el peso de las cargas del envio
							for(CargaDTO carga:envioSucDestino.getCargas()){
								float peso 	= carga.getPeso(); 
								System.out.println("		idCarga: " + carga.getId() + ", peso: " + peso);
								pesoTotalCargasEnvio = pesoTotalCargasEnvio + peso;
							}
							System.out.println("		peso total de las cargas: " + pesoTotalCargasEnvio);
								
							System.out.println("**Buscando vehiculo con capacidad para los envios..**");
							if(vehiculos.size() > 0){
								for(VehiculoDTO vehiculo:vehiculos){
									System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + "(patente: " + vehiculo.getPatente() + ",tara: " + vehiculo.getTara() + ")");

									if(hayEnviosEnEspera){
										System.out.println("**Hay envios en espera, se intenta asignar a un viaje**");
										if((vehiculo.getTara() >= (pesoTotalCargasEnvio + pesoTotalEnviosEnEspera))){
											if((vehiculo.getTara() * 0.2 /*0.7*/) <= (pesoTotalCargasEnvio + pesoTotalEnviosEnEspera)){
												
												System.out.println("**Se detectó un envio igual o mayor al 70% de la capacidad del vehiculo, genera Viaje**");
												ViajeDTO viaje = new ViajeDTO(enviosSucDestino,vehiculo);
												
												ViajeDTO ViajeDTO = new BusinessDelegate().getBusinessService().crearViaje(enviosSucDestino, vehiculo);
												
												//Actualizamos datos del vehiculo
												vehiculo.setTara(pesoTotalCargasEnvio);
												vehiculo.setHabilitadoParaUtilizar(false);//vehiculoOcupado
												hayEnviosEnEspera = false;
											}
										}
									}else{
										if((vehiculo.getTara() >= pesoTotalCargasEnvio)){
											
											//Con 70% o más de capacidad se genera un viaje
											if((vehiculo.getTara() * 0.2 /*0.7*/) <= pesoTotalCargasEnvio){
												
												System.out.println("**Se detectó un envio igual o mayor al 70% de la capacidad del vehiculo, genera Viaje**");
												ViajeDTO viaje = new ViajeDTO(enviosSucDestino,vehiculo);
												
												//TODO persistir viaje
												
												//Actualizamos datos del vehiculo
												vehiculo.setTara(pesoTotalCargasEnvio);
												vehiculo.setHabilitadoParaUtilizar(false);//vehiculoOcupado
											}else{
												//No genera viaje aún, sigue juntando envios intentando llenar el vehiculo
												enviosEnEspera.add(envioSucDestino);
												pesoTotalEnviosEnEspera = pesoTotalEnviosEnEspera + pesoTotalCargasEnvio;
												hayEnviosEnEspera 		= true;
												
												System.out.println("** Se dejó en espera el nro de envio: " + envioSucDestino.getIdEnvio());
											}
											break; // No sigue recorriendo los vehiculos disponibles
										}
									}
									
								}
							}else{
								System.out.println("Sin vehiculos");
							}
						}
					}
				}else{
					System.out.println("Sin envios en deposito");
				}
			}
			System.out.println("-- Fin recorrido sucursales buscando envios en deposito --");
			
			iteraciones++;
		
		} catch (RemoteException | SucursalException | EnvioException | VehiculoException e) {
			e.printStackTrace();
		}	
    }

    public static void main(String args[]){
    	iniciar();
    }
    
    public static void iniciar(){
        TimerTask timerTask = new GenerarViaje();
        Timer timer = new Timer(); 
        timer.scheduleAtFixedRate(timerTask, 0, 5000);
    }

}
