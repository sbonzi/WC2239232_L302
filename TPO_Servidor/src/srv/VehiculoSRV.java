package srv;

import java.util.List;

import converters.VehiculoConverter;
import dao.VehiculoDAO;
import dto.VehiculoDTO;
import entities.Vehiculo;

public class VehiculoSRV {
	private static VehiculoDAO dao;
	
	static{
		dao = VehiculoDAO.getInstancia();
	}

	public static List<VehiculoDTO> getVehiculosDisponibles() {
		List<Vehiculo> vehiculosDisponibles = dao.getVehiculosDisponibles();
		List<VehiculoDTO> vehiculosDTO		= VehiculoConverter.vehiculosToTDO(vehiculosDisponibles);
		return vehiculosDTO;
	}

}
