package srv;

import java.util.List;

import converters.SucursalConverter;
import dao.SucursalDAO;
import dto.SucursalDTO;
import entities.Sucursal;

public class SucursalSRV {
	private static SucursalDAO dao;
	
	static{
		dao = SucursalDAO.getInstancia();
	}
	
	public static SucursalDTO crearSucursal(SucursalDTO s){
		Sucursal sucursal = dao.crearSucursal(s);
		SucursalDTO sucursalDTO = SucursalConverter.sucursalToDTO(sucursal);
		return sucursalDTO;
	}
	
	public static List<SucursalDTO> getSucursales(){
		List<Sucursal> sucursales = dao.getSucursales();
		List<SucursalDTO> sucursalesDTO = SucursalConverter.sucursalesToDTO(sucursales);
		return sucursalesDTO;
	}
}
