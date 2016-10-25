package dto;

import java.io.Serializable;

public abstract class ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3731408374211487949L;
	
	private int id;
	private String domicilio;
	private String nombre;
	private Boolean esParticular = true;
	
	public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteDTO(String domicilio, String nombre) {
		super();
		this.domicilio = domicilio;
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean getEsParticular() {
		return esParticular;
	}

	public void setEsParticular(Boolean esParticular) {
		this.esParticular = esParticular;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString(){
		return "[nombre=" + nombre + ",domicilio=" + domicilio + "]";
	}

}
