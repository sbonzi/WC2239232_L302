package dto;

import java.io.Serializable;
import java.util.List;

public abstract class CamionDTO extends VehiculoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2584132479150568855L;
	
	private int volumen;

	public CamionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CamionDTO(int anio, boolean habilitadoParaUtilizar, int kilometraje, List<MantenimientoDTO> mantenimientos,
			String marca, String modelo, String patente, Float peso, Float tara) {
		super(anio, habilitadoParaUtilizar, kilometraje, mantenimientos, marca, modelo, patente, peso, tara);
		// TODO Auto-generated constructor stub
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
}
