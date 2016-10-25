package dto;

import java.io.Serializable;
import java.util.List;

public class CamionConCajaDTO extends CamionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7603274535046650165L;
	
	private boolean refrigerado;
	private Float temperatura;
	
	public CamionConCajaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CamionConCajaDTO(int anio, boolean habilitadoParaUtilizar, int kilometraje,
			List<MantenimientoDTO> mantenimientos, String marca, String modelo, String patente, Float peso, Float tara) {
		super(anio, habilitadoParaUtilizar, kilometraje, mantenimientos, marca, modelo, patente, peso, tara);
		// TODO Auto-generated constructor stub
	}
	public boolean isRefrigerado() {
		return refrigerado;
	}
	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}
	public Float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

}
