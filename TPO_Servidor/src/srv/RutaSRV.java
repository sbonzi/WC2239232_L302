package srv;

import java.util.List;

import converters.RutaConverter;
import dao.RutaDAO;
import dto.RutaDTO;
import entities.Ruta;
public class RutaSRV {
	private static RutaDAO dao;
	
	static{
		dao = RutaDAO.getInstancia();
	}
	
	public static RutaDTO crearRuta(RutaDTO r){
		Ruta ruta 		= dao.crearRuta(r);
		RutaDTO RutaDTO = RutaConverter.rutaToDTO(ruta);
		return RutaDTO;
	}
	
	public static List<RutaDTO> getRutas(){
		List<Ruta> rutas 		= dao.getRutas();
		List<RutaDTO> rutasDTO 	= RutaConverter.rutasToDTO(rutas);
		return rutasDTO;
	}
}
