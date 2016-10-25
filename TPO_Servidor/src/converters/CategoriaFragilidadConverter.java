package converters;

import java.io.Serializable;

import dto.CategoriaFragilidadDTO;
import entities.CategoriaFragilidad;

public class CategoriaFragilidadConverter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2872294514219655446L;

	public static CategoriaFragilidadDTO categoriaFragilidadToDTO(CategoriaFragilidad cf){
		CategoriaFragilidadDTO cfDTO = new CategoriaFragilidadDTO();
		cfDTO.setDescripcion(cf.getDescripcion());
		cfDTO.setId(cf.getId());
		return cfDTO;
	}
	
	public static CategoriaFragilidad categoriaFragilidadToEntity(CategoriaFragilidadDTO cf){
		CategoriaFragilidad cfEntity = new CategoriaFragilidad(cf.getDescripcion(), cf.isHabilitado(),cf.getId());
		return cfEntity;
	}

}
