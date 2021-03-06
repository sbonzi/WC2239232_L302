package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.PaisDTO;
import dto.ProvinciaDTO;
import entities.Pais;
import entities.Provincia;

public class ProvinciaConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9115056780814672579L;

	public static ProvinciaDTO provinciaToDTO(Provincia p){
		ProvinciaDTO provinciaDTO = new ProvinciaDTO(p.getDescripcion(),p.getHabilitado(), PaisConverter.paisToDTO(p.getPais()));
		provinciaDTO.setId(p.getId());
		return provinciaDTO;
	}

	public static Provincia provinciaToEntity(ProvinciaDTO p) {
		Provincia provincia = new Provincia(p.getDescripcion(),p.isHabilitado(), PaisConverter.paisToEntity(p.getPais()));
		provincia.setId(p.getId());
		return provincia;
	}
	
	public static List<ProvinciaDTO> provinciasToDTO(List<Provincia> provincias){
		List<ProvinciaDTO> provinciasDTO = new ArrayList<ProvinciaDTO>();
		for(Provincia p:provincias){
			provinciasDTO.add(provinciaToDTO(p));
		}
		return provinciasDTO;
	}
}
