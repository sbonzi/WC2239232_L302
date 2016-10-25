package converters;

import java.io.Serializable;

import dto.CategoriaTratamientoDTO;
import entities.CategoriaTratamiento;

public class CategoriaTratamientoConverter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7887436526018014958L;

	public static CategoriaTratamientoDTO categoriaTratamientoToDTO(CategoriaTratamiento ct){
		CategoriaTratamientoDTO ctDTO = new CategoriaTratamientoDTO(ct.getDescripcion(), ct.isHabilitado());
		return ctDTO;
	}
	
	public static CategoriaTratamiento categoriaTratamientoToEntity(CategoriaTratamientoDTO ct){
		CategoriaTratamiento ctEntity = new CategoriaTratamiento(ct.getDescripcion(), ct.isHabilitado(),ct.getId());
		return ctEntity;
	}
}
