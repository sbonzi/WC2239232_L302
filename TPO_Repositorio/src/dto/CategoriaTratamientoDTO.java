package dto;

import java.io.Serializable;

public class CategoriaTratamientoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8095531481657433621L;
	
	private int id;
	private String descripcion;
	private boolean habilitado;
	
	public CategoriaTratamientoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaTratamientoDTO(String descripcion, boolean habilitado) {
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
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
