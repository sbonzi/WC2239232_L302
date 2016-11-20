package srv;

import java.util.List;

import converters.ProvinciaConverter;
import dao.ProvinciaDAO;
import dto.PaisDTO;
import dto.ProvinciaDTO;
import entities.Provincia;

public class ProvinciaSRV {
	private static ProvinciaDAO dao;
	

	public static List<ProvinciaDTO> getProvincias(PaisDTO pais) {
		List<Provincia> provincias 		= dao.getProvincias(pais);
		List<ProvinciaDTO> provinciasDTO 	= ProvinciaConverter.provinciasToDTO(provincias);
		return provinciasDTO;
	}

	public static ProvinciaDTO getProvincia(int id) {
		Provincia provincia 		= dao.getProvincia(id);
		ProvinciaDTO provinciaDTO 	= ProvinciaConverter.provinciaToDTO(provincia);
		return provinciaDTO;
	}
}
