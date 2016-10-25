package dto;

import java.io.Serializable;
import java.util.List;

public class TrailerDTO extends TractorTrailerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5224574683899249719L;
	
	private Float ancho;
	private Float capacidadCargaReal;
	private Float capacidadCargaVial;
	private Float largoDePlataforma;
	private Float largoTotal;
	private Float rodado;
	private String suspension;
	
	public TrailerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrailerDTO(int anio, boolean habilitadoParaUtilizar, int kilometraje, List<MantenimientoDTO> mantenimientos,
			String marca, String modelo, String patente, Float peso, Float tara) {
		super(anio, habilitadoParaUtilizar, kilometraje, mantenimientos, marca, modelo, patente, peso, tara);
		// TODO Auto-generated constructor stub
	}

	public Float getAncho() {
		return ancho;
	}

	public void setAncho(Float ancho) {
		this.ancho = ancho;
	}

	public Float getCapacidadCargaReal() {
		return capacidadCargaReal;
	}

	public void setCapacidadCargaReal(Float capacidadCargaReal) {
		this.capacidadCargaReal = capacidadCargaReal;
	}

	public Float getCapacidadCargaVial() {
		return capacidadCargaVial;
	}

	public void setCapacidadCargaVial(Float capacidadCargaVial) {
		this.capacidadCargaVial = capacidadCargaVial;
	}

	public Float getLargoDePlataforma() {
		return largoDePlataforma;
	}

	public void setLargoDePlataforma(Float largoDePlataforma) {
		this.largoDePlataforma = largoDePlataforma;
	}

	public Float getLargoTotal() {
		return largoTotal;
	}

	public void setLargoTotal(Float largoTotal) {
		this.largoTotal = largoTotal;
	}

	public Float getRodado() {
		return rodado;
	}

	public void setRodado(Float rodado) {
		this.rodado = rodado;
	}

	public String getSuspension() {
		return suspension;
	}

	public void setSuspension(String suspension) {
		this.suspension = suspension;
	}

}
