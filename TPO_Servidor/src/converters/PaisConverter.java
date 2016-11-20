package converters;

import java.io.Serializable;

import dto.PaisDTO;
import entities.Pais;

public class PaisConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9115056780814672579L;

	public static PaisDTO paisToDTO(Pais p){
		PaisDTO paisDTO = new PaisDTO(p.getDescripcion(),p.getHabilitado());
		paisDTO.setId(p.getId());
		return paisDTO;
	}

	public static Pais paisToEntity(PaisDTO p) {
		Pais pais = new Pais(p.getDescripcion(),p.isHabilitado());
		pais.setId(p.getId());
		return pais;
	}
}
