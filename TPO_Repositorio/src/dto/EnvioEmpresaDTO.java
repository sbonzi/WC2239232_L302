package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EnvioEmpresaDTO extends EnvioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2123091931586935420L;
	
	public EnvioEmpresaDTO() {
		super();
	}

	public EnvioEmpresaDTO(int idEnvio ,List<CargaDTO> cargas, ClienteDTO cliente, Float cobro, boolean cobroOrigen,
			EstadoEnvioDTO estado, Date fechaMaxLlegada, boolean retiroEnSucursal, SucursalDTO sucursalDestino,
			SucursalDTO sucursalOrigen, boolean tercerizarEnvio, boolean trajoCajaEnPersona, DestinatarioDTO destinatario) {
		super(idEnvio, cargas, cliente, cobro, cobroOrigen, estado, fechaMaxLlegada, retiroEnSucursal, sucursalDestino, sucursalOrigen,
				tercerizarEnvio, trajoCajaEnPersona, destinatario);
	}
}
