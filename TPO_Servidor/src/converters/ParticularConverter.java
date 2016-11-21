package converters;

import java.io.Serializable;

import dto.ParticularDTO;
import entities.ClienteParticular;


public class ParticularConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1924347162424143904L;
	
	public static ParticularDTO particularToDTO(ClienteParticular p){
		ParticularDTO particularDTO = new ParticularDTO(p.getDomicilio(), p.getNombre());
					  particularDTO.setId(p.getId());
					  particularDTO.setEsParticular(p.getEsParticular());
					  particularDTO.setTipoDoc(p.getTipoDoc());
					  particularDTO.setNumDoc(p.getNumDoc());
		return particularDTO;
	}
	
	public static ClienteParticular particularToEntity(ParticularDTO c){
		ClienteParticular particular = new ClienteParticular(c.getNumDoc(), c.getTipoDoc());
		particular.setId(c.getId());
		particular.setNombre(c.getNombre());
		particular.setDomicilio(c.getDomicilio());
		particular.setEsParticular(true);
		return particular;
	}
}
