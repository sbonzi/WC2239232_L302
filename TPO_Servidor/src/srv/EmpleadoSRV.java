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
	
	public static boolean existeEmpleado(String cuit) {
		return dao.existeEmpleado(cuit);
	}

	public static EmpleadoDTO obtenerEmpleado(String cuit) {
		Empleado empleado = dao.obtenerEmpleado(cuit);		
		EmpleadoDTO empleadoDTO = null;
		if(empleado != null){			
			empleadoDTO = EmpleadoConverter.empleadoToDTO(empleado);
		}
		return empleadoDTO;
	}
	
	public static EmpleadoDTO actualizarEmpleado(EmpleadoDTO e) {
		Empleado empleado = dao.actualizarEmpleado(e);
		EmpleadoDTO empleadoDTO = null;
		if(empleado !=null){
			empleadoDTO 	= EmpleadoConverter.empleadoToDTO(empleado);
		}
		return empleadoDTO;
	}
}
