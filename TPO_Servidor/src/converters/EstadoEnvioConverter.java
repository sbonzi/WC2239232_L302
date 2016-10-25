package converters;

import java.io.Serializable;

import dto.EstadoEnvioDTO;
import entities.EstadoEnvio;

public class EstadoEnvioConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1855950211580187712L;
	
	public static EstadoEnvioDTO estadoEnvioToDTO(EstadoEnvio e){
		EstadoEnvioDTO estadoEnvioDTO = new EstadoEnvioDTO(e.getDescripcion(),e.isHabilitado());
		return estadoEnvioDTO;
	}

	public static EstadoEnvio estadoEnvioToEntity(EstadoEnvioDTO estado) {
		EstadoEnvio estadoEnvio = new EstadoEnvio(estado.getId(),
												  estado.getDescripcion(),
												  estado.isHabilitado());
		return estadoEnvio;
	}
	

}
