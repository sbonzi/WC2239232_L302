package srv;

import java.util.List;

import converters.ParticularConverter;
import dao.ClienteParticularDAO;
import dto.ParticularDTO;
import entities.ClienteParticular;


public class ParticularSRV {
	private static ClienteParticularDAO dao;
	
	static{
		dao = ClienteParticularDAO.getInstancia();
	}

	public static ParticularDTO crearParticular(ParticularDTO p) {
		ClienteParticular particular = dao.crearClienteParticular(p);
		ParticularDTO particularDTO = ParticularConverter.particularToDTO(particular);
		return particularDTO;
	}

	public static ParticularDTO getClienteParticular(int dniParticular, char tipoDoc) {
		ClienteParticular particular = dao.getClienteParticular(dniParticular,tipoDoc);		
		ParticularDTO particularDTO = null;
		if(particular != null){			
			particularDTO = ParticularConverter.particularToDTO(particular);
		}
		return particularDTO;
	}
}
