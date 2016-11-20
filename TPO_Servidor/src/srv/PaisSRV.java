package srv;

import java.util.List;

import converters.PaisConverter;
import dao.PaisDAO;
import dto.PaisDTO;
import entities.Pais;

public class PaisSRV {
	private static PaisDAO dao;
	

	public static List<PaisDTO> getPaises() {
		List<Pais> paises 		= dao.getPaises();
		List<PaisDTO> paisesDTO 	= PaisConverter.paisesToDTO(paises);
		return paisesDTO;
	}

	public static PaisDTO getPais(int id) {
		Pais pais 		= dao.getPais(id);
		PaisDTO paisDTO 	= PaisConverter.paisToDTO(pais);
		return paisDTO;
	}
}
