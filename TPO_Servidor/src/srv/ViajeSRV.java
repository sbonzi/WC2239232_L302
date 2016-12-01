package srv;

import java.util.List;

import converters.EnvioConverter;
import converters.ViajeConverter;
import dao.ViajeDAO;
import dto.EmpleadoDTO;
import dto.EnvioDTO;
import dto.VehiculoDTO;
import dto.ViajeDTO;
import entities.Envio;
import entities.Viaje;

public class ViajeSRV {
	private static ViajeDAO dao;
	
	static{
		dao = ViajeDAO.getInstancia();
	}
	
	public static List<ViajeDTO> gestionarViaje(List<EmpleadoDTO> choferesDisponibles,
			   							  List<EnvioDTO> enviosPendientes,
			   							  List<VehiculoDTO> vehiculosDisponibles){
		List<Viaje> viajes 			= dao.gestionarViajes(choferesDisponibles, enviosPendientes, vehiculosDisponibles);
		List<ViajeDTO> viajesDTO 	= ViajeConverter.viajesToDTO(viajes);
		return viajesDTO;
	}

	public static List<EnvioDTO> getEnviosPendientes() {
		List<EnvioDTO> enviosDTO 		= null;
		List<Envio> enviosPendientes 	= dao.getEnviosPendientes();
		enviosDTO	= EnvioConverter.enviosToDTO(enviosPendientes);
		return enviosDTO;
	}
	
	public static ViajeDTO crearViaje(List<EnvioDTO> envios, VehiculoDTO vehiculo) {
		Viaje viaje = dao.crearViaje(envios,vehiculo);
		return ViajeConverter.viajeToDTO(viaje);
	}
}