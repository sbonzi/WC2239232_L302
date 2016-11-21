package dto;

import java.io.Serializable;
import java.util.List;

public abstract class VehiculoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2018870516268130584L;
	
	private int numero;
	private int anio;
	private boolean habilitadoParaUtilizar;
	private int kilometraje;
	private List<MantenimientoDTO> mantenimientos;
	private String marca;
	private String modelo;
	private String patente;
	private Float peso;
	private Float tara;
	
	public VehiculoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehiculoDTO(int anio, boolean habilitadoParaUtilizar, int kilometraje, List<MantenimientoDTO> mantenimientos,
			String marca, String modelo, String patente, Float peso, Float tara) {
		super();
		this.anio = anio;
		this.habilitadoParaUtilizar = habilitadoParaUtilizar;
		this.kilometraje = kilometraje;
		this.mantenimientos = mantenimientos;
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.peso = peso;
		this.tara = tara;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public boolean isHabilitadoParaUtilizar() {
		return habilitadoParaUtilizar;
	}

	public void setHabilitadoParaUtilizar(boolean habilitadoParaUtilizar) {
		this.habilitadoParaUtilizar = habilitadoParaUtilizar;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public List<MantenimientoDTO> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<MantenimientoDTO> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getTara() {
		return tara;
	}

	public void setTara(Float tara) {
		this.tara = tara;
	}
	
	@Override
	public String toString(){
		return "[marca=" + marca + ",modelo=" + modelo + ",patente=" + patente + "]";
	}

}
