package dto;

import java.io.Serializable;
import java.util.List;

public class ViajeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6495922772662012832L;
	
	private EmpleadoDTO chofer;
	private List<EnvioDTO> envios;
	private String latitud;
	private String longitud;
	private VehiculoDTO vehiculoDesignado;
	
	public ViajeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViajeDTO(EmpleadoDTO chofer, List<EnvioDTO> envios, String latitud, String longitud,
			VehiculoDTO vehiculoDesignado) {
		super();
		this.chofer = chofer;
		this.envios = envios;
		this.latitud = latitud;
		this.longitud = longitud;
		this.vehiculoDesignado = vehiculoDesignado;
	}

	public EmpleadoDTO getChofer() {
		return chofer;
	}

	public void setChofer(EmpleadoDTO chofer) {
		this.chofer = chofer;
	}

	public List<EnvioDTO> getEnvios() {
		return envios;
	}

	public void setEnvios(List<EnvioDTO> envios) {
		this.envios = envios;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public VehiculoDTO getVehiculoDesignado() {
		return vehiculoDesignado;
	}

	public void setVehiculoDesignado(VehiculoDTO vehiculoDesignado) {
		this.vehiculoDesignado = vehiculoDesignado;
	}	
	
	@Override
	public String toString(){
		return "Viaje:[chofer=" + chofer + ",envios=(" + envios + "),vehiculo=" + vehiculoDesignado + "]";
	}

}
