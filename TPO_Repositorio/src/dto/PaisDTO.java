package dto;

import java.io.Serializable;

public class PaisDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4101834234552549735L;
	
	private int id;
	private String descripcion;
	private boolean habilitado;
	
	public PaisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaisDTO(String descripcion, boolean habilitado) {
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
