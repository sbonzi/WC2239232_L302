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
}
