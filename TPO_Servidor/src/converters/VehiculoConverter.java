package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.CamionConCajaDTO;
import dto.MantenimientoDTO;
import dto.VehiculoDTO;
import entities.Mantenimiento;
import entities.Vehiculo;

public class VehiculoConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2741401682538886243L;
	
	public static VehiculoDTO vehiculoToDTO(Vehiculo vehiculo){
		List<MantenimientoDTO> mantenimientoV = null;
	
		if(vehiculo.getMantenimientos() != null){
			mantenimientoV = MantenimientoConverter.mantenimientosToDTO(vehiculo.getMantenimientos());
		}
		
		VehiculoDTO vehiculoDTO = new CamionConCajaDTO(vehiculo.getAnio(),
														vehiculo.isHabilitadoParaUtilizar(),
														vehiculo.getKilometraje(),
														mantenimientoV,
														vehiculo.getMarca(),
														vehiculo.getModelo(),
														vehiculo.getPatente(),
														vehiculo.getPeso(),
														vehiculo.getTara());
					vehiculoDTO.setNumero(vehiculo.getId());
		return vehiculoDTO;
	}

	public static Vehiculo vehiculoToEntity(VehiculoDTO vehiculoDTO) {
		List<Mantenimiento> mantenimientoV = null;
		
		//if(vehiculoDTO.getMantenimientos()!=null){
		//	mantenimientoV = MantenimientoConverter.mantenimientosToEntity(vehiculoDTO.getMantenimientos());
		//}
		
		Vehiculo vehiculo = new Vehiculo(vehiculoDTO.getAnio(),
										 vehiculoDTO.isHabilitadoParaUtilizar(),
										 vehiculoDTO.getKilometraje(),
										 vehiculoDTO.getMarca(),
										 vehiculoDTO.getModelo(),
										 vehiculoDTO.getPatente(),
										 vehiculoDTO.getPeso(),
										 vehiculoDTO.getTara());
				vehiculo.setId(vehiculoDTO.getNumero());
				vehiculo.setMantenimientos(mantenimientoV);
		return vehiculo;
	}

	public static List<VehiculoDTO> vehiculosToTDO(List<Vehiculo> vehiculosDisponibles) {
		List<VehiculoDTO> vehiculosDisponiblesDTO = new ArrayList<VehiculoDTO>();
		for(Vehiculo v:vehiculosDisponibles){
			vehiculosDisponiblesDTO.add(VehiculoConverter.vehiculoToDTO(v));
		}
		return vehiculosDisponiblesDTO;
	}
}