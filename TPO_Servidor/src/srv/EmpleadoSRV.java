package srv;

import java.util.List;

import converters.EmpleadoConverter;
import dao.EmpleadoDAO;
import dto.EmpleadoDTO;
import entities.Empleado;

public class EmpleadoSRV {
	private static EmpleadoDAO dao;
	
	static{
		dao = EmpleadoDAO.getInstancia();
	}

	public static EmpleadoDTO crearEmpleado(EmpleadoDTO e) {
		Empleado empleado 		= dao.crearEmpleado(e);
		EmpleadoDTO empleadoDTO = EmpleadoConverter.empleadoToDTO(empleado);
		return empleadoDTO;
	}
	
	public static List<EmpleadoDTO> getEmpleados() {
		List<Empleado> empleados 		= dao.getEmpleados();
		List<EmpleadoDTO> empleadosDTO 	= EmpleadoConverter.empleadosToDTO(empleados);
		return empleadosDTO;
	}

	public static List<EmpleadoDTO> getChoferesDisponibles() {
		List<Empleado> choferes 		= dao.getChoferesDisponibles();
		List<EmpleadoDTO> choferesDTO 	= EmpleadoConverter.empleadosToDTO(choferes);
		return choferesDTO;
	}
}
