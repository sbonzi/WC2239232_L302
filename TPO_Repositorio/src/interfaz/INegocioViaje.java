package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

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

public interface INegocioViaje extends Remote {
	
	List<ViajeDTO> gestionarViaje(List<EmpleadoDTO> choferesDisponibles,
						    List<EnvioDTO> enviosPendientes,
						    List<VehiculoDTO> vehiculosDisponibles) 
	throws EmpleadoException,EnvioException,VehiculoException,RemoteException,ViajeException;

	List<EnvioDTO> getEnviosPendientes()
	throws EnvioException,RemoteException;

	List<VehiculoDTO> getVehiculosDisponibles()
	throws VehiculoException,RemoteException;

	List<EmpleadoDTO> getChoferesDisponibles()
	throws EmpleadoException,RemoteException;

	List<RutaDTO> getRutasDisponibles()
	throws RutaException,RemoteException;
}
