package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EnvioParticularDTO extends EnvioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1642677807975873287L;

	public EnvioParticularDTO() {
		super();
	}

	public EnvioParticularDTO(int idEnvio, List<CargaDTO> cargas, ClienteDTO cliente, Float cobro, boolean cobroOrigen,
			EstadoEnvioDTO estado, Date fechaMaxLlegada, boolean retiroEnSucursal, SucursalDTO sucursalDestino,
			SucursalDTO sucursalOrigen, boolean tercerizarEnvio, boolean trajoCajaEnPersona, DestinatarioDTO destinatario) {
		super(idEnvio, cargas, cliente, cobro, cobroOrigen, estado, fechaMaxLlegada, retiroEnSucursal, sucursalDestino, sucursalOrigen,
				tercerizarEnvio, trajoCajaEnPersona, destinatario);
			
	}
}
