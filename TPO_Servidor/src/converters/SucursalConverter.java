package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.SucursalDTO;
import entities.Sucursal;

public class SucursalConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387248292750161862L;
	
	public static SucursalDTO sucursalToDTO(Sucursal s){
		SucursalDTO sucursalDTO = new SucursalDTO(s.getNombre(),
												  s.getDireccion(),
												  s.getLatitud(),
												  s.getLongitud());
					sucursalDTO.setNumero(s.getId());
		return sucursalDTO;
	}
	
	public static Sucursal sucursalToEntity(SucursalDTO s){
		Sucursal sucursal = new Sucursal(s.getNombre(),
										 s.getDireccion(),
										 s.getLatitud(),
										 s.getLongitud());
				 sucursal.setId(s.getNumero());
		return sucursal;
	}

	public static List<SucursalDTO> sucursalesToDTO(List<Sucursal> sucursales) {
		List<SucursalDTO> sucursalesDTO = new ArrayList<SucursalDTO>();
		for(Sucursal s:sucursales){
			sucursalesDTO.add(SucursalConverter.sucursalToDTO(s));
		}
		return sucursalesDTO;
	}

}
