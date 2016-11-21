package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.ServicioTercerizadoDTO;
import entities.ServicioTercerizado;

public class ServicioTercerizadoConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6615432609227243015L;
	
	public static ServicioTercerizadoDTO servicioTercerizadoToDTO(ServicioTercerizado st){
		ServicioTercerizadoDTO stDTO = new ServicioTercerizadoDTO(st.getId(),
																  st.getNombre(),
																  st.getDescripcion(),
																  st.getTiempoDeEntregaDias(),
																  st.getSeguridadDeCarga(),
																  st.getTarifa());
		return stDTO;
	}
	
	public static List<ServicioTercerizadoDTO> serviciosTercerizadoToDTO(List<ServicioTercerizado> serviciosTerc){
		List<ServicioTercerizadoDTO> listadoDTO = new ArrayList<ServicioTercerizadoDTO>();
		for(ServicioTercerizado st:serviciosTerc){
			listadoDTO.add(servicioTercerizadoToDTO(st));
		}
		return listadoDTO;
	}

}
