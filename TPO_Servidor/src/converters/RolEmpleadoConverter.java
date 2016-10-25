package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.RolEmpleadoDTO;
import entities.RolEmpleado;

public class RolEmpleadoConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5825393632080450617L;

	public static RolEmpleadoDTO rolEmpleadoToDTO(RolEmpleado rol) {
		RolEmpleadoDTO rolDTO = new RolEmpleadoDTO(rol.getDescripcion());
					   rolDTO.setId(rol.getId());
		return rolDTO;
	}

	public static List<RolEmpleadoDTO> rolesEmpleadoToDTO(List<RolEmpleado> roles) {
		List<RolEmpleadoDTO> rolesDTO = new ArrayList<RolEmpleadoDTO>();
		for(RolEmpleado r:roles){
			rolesDTO.add(RolEmpleadoConverter.rolEmpleadoToDTO(r));
		}
		return rolesDTO;
	}

	public static RolEmpleado rolEmpleadoToEntity(RolEmpleadoDTO r) {
		RolEmpleado rolEmpleado = new RolEmpleado(r.getDescripcion());
					rolEmpleado.setId(r.getId());
		return rolEmpleado;
	}

}
