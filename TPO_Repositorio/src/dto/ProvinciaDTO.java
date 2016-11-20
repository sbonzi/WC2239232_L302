package dto;

import java.io.Serializable;

public class ProvinciaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1549713611349965667L;
	
	private int id;
	private String descripcion;
	private boolean habilitado;
	private PaisDTO pais;
	
	public ProvinciaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProvinciaDTO(String descripcion, boolean habilitado, PaisDTO pais) {
		super();
		this.descripcion = descripcion;
		this.habilitado = habilitado;
		this.pais = pais;
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

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}
}
