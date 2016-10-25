package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.MantenimientoDTO;
import entities.Mantenimiento;

public class MantenimientoConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5791205244602423001L;
	
	public static MantenimientoDTO mantenimientoToDTO(Mantenimiento mantenimiento){
		MantenimientoDTO mantenimientoDTO = new MantenimientoDTO(mantenimiento.getFecha(),
																 mantenimiento.getTipo(),
																 mantenimiento.getUltimoKilometraje());
		return mantenimientoDTO;
	}

	public static List<MantenimientoDTO> mantenimientosToDTO(List<Mantenimiento> mantenimientos) {
		List<MantenimientoDTO> mantenimientosDTO = new ArrayList<MantenimientoDTO>();
		for(Mantenimiento m:mantenimientos){
			MantenimientoDTO mantenimientoDTO = MantenimientoConverter.mantenimientoToDTO(m);
			mantenimientosDTO.add(mantenimientoDTO);
		}
		return mantenimientosDTO;
	}
	
	public static Mantenimiento mantenimientoToEntity(MantenimientoDTO mantenimientoDTO){
		Mantenimiento mantenimiento = new Mantenimiento(mantenimientoDTO.getFecha(),
														mantenimientoDTO.getTipo(),
														mantenimientoDTO.getUltimoKilometraje(),
														VehiculoConverter.vehiculoToEntity(mantenimientoDTO.getVehiculo()));
		return mantenimiento;
	}

	public static List<Mantenimiento> mantenimientosToEntity(List<MantenimientoDTO> mantenimientosDTO) {
		List<Mantenimiento> mantenimientos = new ArrayList<Mantenimiento>();
		
		for(MantenimientoDTO m:mantenimientosDTO){
			Mantenimiento mantenimiento = MantenimientoConverter.mantenimientoToEntity(m);
			mantenimientos.add(mantenimiento);
		}
		
		return mantenimientos;
	}

}
