package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.EmpresaSeguroDTO;
import dto.PaisDTO;
import entities.EmpresaSeguro;
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
	
	public static List<PaisDTO> paisesToDTO(List<Pais> paises){
		List<PaisDTO> paisesDTO = new ArrayList<PaisDTO>();
		for(Pais p:paises){
			paisesDTO.add(paisToDTO(p));
		}
		return paisesDTO;
	}

}
