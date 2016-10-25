package dto;

import java.io.Serializable;

public class ProductoEmpresaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2559807984867876305L;
	
	private Float alto;
	private Float ancho;
	private int codigo;
	private String descripcion;
	private Float peso;
	private Float profundidad;
	
	public ProductoEmpresaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoEmpresaDTO(Float alto, Float ancho, int codigo, String descripcion, Float peso, Float profundidad) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.peso = peso;
		this.profundidad = profundidad;
	}

	public Float getAlto() {
		return alto;
	}

	public void setAlto(Float alto) {
		this.alto = alto;
	}

	public Float getAncho() {
		return ancho;
	}

	public void setAncho(Float ancho) {
		this.ancho = ancho;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Float profundidad) {
		this.profundidad = profundidad;
	}

}
