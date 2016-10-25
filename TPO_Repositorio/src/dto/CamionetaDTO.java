package dto;

import java.io.Serializable;
import java.util.List;

public class CamionetaDTO extends VehiculoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4077537585328497189L;
	
	private int tamanio;
	private int volumen;
	
	public CamionetaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CamionetaDTO(int anio, boolean habilitadoParaUtilizar, int kilometraje,
			List<MantenimientoDTO> mantenimientos, String marca, String modelo, String patente, Float peso, Float tara) {
		super(anio, habilitadoParaUtilizar, kilometraje, mantenimientos, marca, modelo, patente, peso, tara);
		// TODO Auto-generated constructor stub
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public int getVolumen() {
		return volumen;
	}
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}	

}
