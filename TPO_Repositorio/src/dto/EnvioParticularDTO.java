package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EnvioParticularDTO extends EnvioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1642677807975873287L;
	
	private DestinatarioDTO destinatario;


	public EnvioParticularDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnvioParticularDTO(int idEnvio, List<CargaDTO> cargas, ClienteDTO cliente, Float cobro, boolean cobroOrigen,
			EstadoEnvioDTO estado, Date fechaMaxLlegada, boolean retiroEnSucursal, SucursalDTO sucursalDestino,
			SucursalDTO sucursalOrigen, boolean tercerizarEnvio, boolean trajoCajaEnPersona) {
		super(idEnvio, cargas, cliente, cobro, cobroOrigen, estado, fechaMaxLlegada, retiroEnSucursal, sucursalDestino, sucursalOrigen,
				tercerizarEnvio, trajoCajaEnPersona);
		// TODO Auto-generated constructor stub
	}

	public DestinatarioDTO getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(DestinatarioDTO destinatario) {
		this.destinatario = destinatario;
	}

}
