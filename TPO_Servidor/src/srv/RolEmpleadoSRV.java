package srv;

import java.util.List;

import converters.RolEmpleadoConverter;
import dao.RolEmpleadoDAO;
import dto.RolEmpleadoDTO;
import entities.RolEmpleado;

public class RolEmpleadoSRV {
	private static RolEmpleadoDAO dao;
	
	static{
		dao = RolEmpleadoDAO.getInstancia();
	}

	public static RolEmpleadoDTO crearRolEmpleado(RolEmpleadoDTO rolEmpleado) {
		RolEmpleado rol 		= dao.crearRolEmpleado(rolEmpleado);
		RolEmpleadoDTO rolDTO 	= RolEmpleadoConverter.rolEmpleadoToDTO(rol);
		return rolDTO;
	}

	public static List<RolEmpleadoDTO> getRoles() {
		List<RolEmpleado> roles 		= dao.getRoles();
		List<RolEmpleadoDTO> rolesDTO 	= RolEmpleadoConverter.rolesEmpleadoToDTO(roles);
		return rolesDTO;
	}

}
