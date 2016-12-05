package srv;

import java.util.List;

import converters.VehiculoConverter;
import dao.VehiculoDAO;
import dto.SucursalDTO;
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
	
	public static boolean guardarMantenimientoPorVehiculo(VehiculoDTO vehiculo) {
		return dao.guardarMantenimientoPorVehiculo(vehiculo);
	}

	public static List<VehiculoDTO> getVehiculosDisponiblesPorSucursal(SucursalDTO sucursal) {
		List<Vehiculo> vehiculosDisponibles = dao.getVehiculosDisponiblesPorSucursal(sucursal);
		List<VehiculoDTO> vehiculosDTO		= VehiculoConverter.vehiculosToTDO(vehiculosDisponibles);
		return vehiculosDTO;
	}
	
	public static List<VehiculoDTO> getVehiculosPorSucursal(SucursalDTO sucursal) {
		List<Vehiculo> vehiculosDisponibles = dao.getVehiculosPorSucursal(sucursal);
		List<VehiculoDTO> vehiculosDTO		= VehiculoConverter.vehiculosToTDO(vehiculosDisponibles);
		return vehiculosDTO;
	}

}
