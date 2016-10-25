package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.RutaDTO;
import entities.Ruta;

public class RutaConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4115451265403779021L;
	
	public static RutaDTO rutaToDTO(Ruta m){
		RutaDTO mDTO = new RutaDTO(m.getDuracionViaje(),
								   m.getCostoViaje(),
								   SucursalConverter.sucursalToDTO(m.getSucursalOrigen()),
								   SucursalConverter.sucursalToDTO(m.getSucursalDestino()));
				mDTO.setNumero(m.getId());
		return mDTO;
	}

	public static List<RutaDTO> rutasToDTO(List<Ruta> rutas) {
		List<RutaDTO> rutasDTO = new ArrayList<RutaDTO>();
		for(Ruta r:rutas){
			rutasDTO.add(RutaConverter.rutaToDTO(r));
		}
		return rutasDTO;
	}


}
