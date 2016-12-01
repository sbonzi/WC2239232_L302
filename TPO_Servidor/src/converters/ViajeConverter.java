package converters;

import java.util.ArrayList;
import java.util.List;

import dto.ViajeDTO;
import entities.Viaje;

public class ViajeConverter {

	public static ViajeDTO viajeToDTO(Viaje viaje) {
		ViajeDTO viajeDTO = new ViajeDTO(EnvioConverter.enviosToDTO(viaje.getEnvios()),
									  	 VehiculoConverter.vehiculoToDTO(viaje.getVehiculoDesignado()));
		return viajeDTO;
	}

	public static List<ViajeDTO> viajesToDTO(List<Viaje> viajes) {
		List<ViajeDTO> viajesDTO = new ArrayList<ViajeDTO>();
		for(Viaje v:viajes){
			viajesDTO.add(ViajeConverter.viajeToDTO(v));
		}
		return null;
	}

}
