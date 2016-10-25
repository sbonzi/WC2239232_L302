package cliente;

import java.rmi.RemoteException;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.EnvioDTO;
import dto.RutaDTO;
import dto.VehiculoDTO;
import dto.ViajeDTO;
import exceptions.EmpleadoException;
import exceptions.EnvioException;
import exceptions.RutaException;
import exceptions.VehiculoException;
import exceptions.ViajeException;
import interfaz.INegocioEnvio;

public class AdministracionViajes {
	INegocioEnvio controladorEnvios;
	
	public static void main(String[] args){
		new AdministracionViajes();
	}
	
	/**
	 * Gestiona la creación de viajes basado en los envios pendientes, vehiculos, choferes y rutas disponibles
	 */
	public AdministracionViajes(){
			
		List<EnvioDTO> enviosPendientes = null;
		try {
			enviosPendientes = new BusinessDelegate().getBusinessService().getEnviosPendientes();
			System.out.println("EnviosPendientes: " + enviosPendientes);
			System.out.println("Cant Envios Pendientes: " + enviosPendientes.size());
			System.out.println("#####################");
		} catch (RemoteException | EnvioException e1) {
			e1.printStackTrace();
		}
		
		List<VehiculoDTO> vehiculosDisponibles = null;
		try {
			vehiculosDisponibles = new BusinessDelegate().getBusinessService().getVehiculosDisponibles();
			System.out.println("vehiculosDisponibles: " + vehiculosDisponibles);
			System.out.println("Cant Envios Pendientes: " + enviosPendientes.size());
			System.out.println("#####################");
		} catch (RemoteException | VehiculoException e1) {
			e1.printStackTrace();
		}
		
		List<EmpleadoDTO> choferesDisponibles = null;
		try {
			choferesDisponibles = new BusinessDelegate().getBusinessService().getChoferesDisponibles();
			System.out.println("choferesDisponibles: " + choferesDisponibles);
		} catch (RemoteException | EmpleadoException e1) {
			e1.printStackTrace();
		}
		
		List<RutaDTO> rutasDisponibles = null;
		try {
			rutasDisponibles = new BusinessDelegate().getBusinessService().getRutasDisponibles();
			System.out.println("rutasDisponibles: " + rutasDisponibles);
		} catch (RemoteException | RutaException e1) {
			e1.printStackTrace();
		}
		/*
		try {
			List<ViajeDTO> viajes = new BusinessDelegate().getBusinessService().gestionarViaje(choferesDisponibles,
															  		 enviosPendientes,
															  		 vehiculosDisponibles);
			//System.out.println("Viajes gestionados: " + viajes);
		} catch (RemoteException | EmpleadoException |
				  EnvioException | VehiculoException | ViajeException e) {
			e.printStackTrace();
		} 
		*/
	}
}
