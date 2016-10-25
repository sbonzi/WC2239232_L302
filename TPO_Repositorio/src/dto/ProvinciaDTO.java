package dto;

import java.io.Serializable;

public class ProvinciaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1549713611349965667L;
	
	private String descripcion;
	private boolean habilitado;
	
	public ProvinciaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProvinciaDTO(String descripcion, boolean habilitado) {
		super();
		this.descripcion = descripcion;
		this.habilitado = habilitado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
}
