package srv;

import java.util.List;

import converters.ServicioTercerizadoConverter;
import dao.ServicioTercerizadoDAO;
import dto.ServicioTercerizadoDTO;

public class ServicioTercerizadoSRV {
	private static ServicioTercerizadoDAO dao;
	
	static{
		dao = ServicioTercerizadoDAO.getInstancia();
	}

	public static List<ServicioTercerizadoDTO> getListadoServiciosTercerizados() {
		return ServicioTercerizadoConverter.serviciosTercerizadoToDTO(dao.getServicioTercerizados());
	}

	public static ServicioTercerizadoDTO actualizarServicioTercerizado(ServicioTercerizadoDTO st) {
		return ServicioTercerizadoConverter.servicioTercerizadoToDTO(dao.actualizarServicioTercerizado(st));
	}

}
