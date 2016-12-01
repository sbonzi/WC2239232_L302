package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.EstadoEnvioDTO;
import dto.SucursalDTO;
import entities.EstadoEnvio;
import entities.Sucursal;

public class EstadoEnvioConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1855950211580187712L;
	
	public static EstadoEnvioDTO estadoEnvioToDTO(EstadoEnvio e){
		EstadoEnvioDTO estadoEnvioDTO = new EstadoEnvioDTO(e.getDescripcion(),e.isHabilitado());
		estadoEnvioDTO.setId(e.getId());
		return estadoEnvioDTO;
	}

	public static EstadoEnvio estadoEnvioToEntity(EstadoEnvioDTO estado) {
		EstadoEnvio estadoEnvio = new EstadoEnvio(estado.getId(),
												  estado.getDescripcion(),
												  estado.isHabilitado());
		return estadoEnvio;
	}
	
	public static List<EstadoEnvioDTO> estadosEnvioToDTO(List<EstadoEnvio> estados) {
		List<EstadoEnvioDTO> estadosDTO = new ArrayList<EstadoEnvioDTO>();
		for(EstadoEnvio e:estados){
			estadosDTO.add(EstadoEnvioConverter.estadoEnvioToDTO(e));
		}
		return estadosDTO;
	}
	

}
