package tareas;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void run() {
    	
    	try {
    		//Verificamos los envios en deposito para cada sucursal
			List<SucursalDTO> sucursales = new BusinessDelegate().getBusinessService().getSucursales();
			for(SucursalDTO sucursal:sucursales){
				System.out.println("Suc: " + sucursal.getNombre() + " " +sucursal.getDireccion());
				
				List<EnvioDTO> envios 		= new ArrayList<EnvioDTO>();
				List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();		
				envios 		= new BusinessDelegate().getBusinessService().getEnviosPorSucursalOrigen(sucursal);
				vehiculos 	= new BusinessDelegate().getBusinessService().getVehiculosDisponiblesPorSucursal(sucursal);
				
				//viaje a generar para los envios
				ViajeDTO viaje = new ViajeDTO();
				
				//Contiene los envios que van a pertenecer a un viaje
				List<EnvioDTO> enviosAceptados = new ArrayList<EnvioDTO>();
				
				//Obtenemos las cargas asociadas a cada envio
				for(EnvioDTO envio:envios){
					
					System.out.println("IdEnvio: " + envio.getIdEnvio());
					
					List<CargaDTO> cargas = envio.getCargas();
					
					//Peso total de las cargas del envio
					float pesoCargas= 0;
					for(CargaDTO carga:cargas){
						pesoCargas = pesoCargas + carga.getPeso();
					}
					
					//Antes de continuar con el siguiente envio, verificamos si el vehiculo tiene capacidad
					//en caso afirmativo, asignamos el envio a un viaje
					VehiculoDTO vehiculoSeleccionado = null;
					for(VehiculoDTO vehiculo:vehiculos){
						//Buscamos un vehiculo que esté con capacidad disponible
						if(vehiculo.getPeso() < pesoCargas){
							//Actualizamos peso del vehiculo
							float pesoActual = vehiculo.getPeso();
							vehiculo.setPeso(pesoActual + pesoCargas);
							vehiculoSeleccionado = vehiculo;
							break;
						}
					}
					
					//Encontramos vehiculo
					if(vehiculoSeleccionado != null){
						enviosAceptados.add(envio);
					}
				}
				//Asignamos los envios aceptados al viaje
				viaje.setEnvios(enviosAceptados);
				
				//Cambiamos estado de envios
				for(EnvioDTO e:enviosAceptados){
					EstadoEnvioDTO estado = new EstadoEnvioDTO();
					estado.setId(3); // En viaje a sucursal destino
					e.setEstado(estado);
				}
			}
		
		} catch (RemoteException | SucursalException | EnvioException | VehiculoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("Generación de viajes");
    }

    public static void main(String args[]){
        TimerTask timerTask = new GenerarViaje();
        Timer timer = new Timer(); 
        timer.scheduleAtFixedRate(timerTask, 0, 5000);
    }

}
