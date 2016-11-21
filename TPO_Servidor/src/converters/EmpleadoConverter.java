package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.EmpleadoDTO;
import entities.Empleado;

public class EmpleadoConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1924347162424143904L;
	
	public static EmpleadoDTO empleadoToDTO(Empleado e){
		EmpleadoDTO empleadoDTO = new EmpleadoDTO(e.getCuit(),e.getNombre());
					empleadoDTO.setNumero(e.getId());
					empleadoDTO.setRolEmpleado(RolEmpleadoConverter.rolEmpleadoToDTO(e.getRolEmpleado()));
					empleadoDTO.setSucursal(SucursalConverter.sucursalToDTO(e.getSucursal()));
					empleadoDTO.setPassword(e.getPassword());
		return empleadoDTO;
	}
	
	public static List<EmpleadoDTO> empleadosToDTO(List<Empleado> empleados){
		List<EmpleadoDTO> lista = new ArrayList<EmpleadoDTO>();
		for(Empleado e:empleados){
			lista.add(EmpleadoConverter.empleadoToDTO(e));
		}
		return lista;
	}

	public static Empleado empleadoToEntity(EmpleadoDTO empleadoDTO) {
		Empleado empleado = new Empleado(empleadoDTO.getCuit(),
										 empleadoDTO.getNombre());
				 empleado.setId(empleadoDTO.getNumero());
		return empleado;
	}
	
	public static List<Empleado> empleadosToEntity(List<EmpleadoDTO> empleadosDTO){
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(EmpleadoDTO e:empleadosDTO){
			empleados.add(EmpleadoConverter.empleadoToEntity(e));
		}
		return empleados;
	}

}
