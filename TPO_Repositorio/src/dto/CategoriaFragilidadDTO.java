package dto;

import java.io.Serializable;

public class CategoriaFragilidadDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8438090164731810065L;
	
	private int id;
	private String descripcion;
	private boolean habilitado;
	
	public CategoriaFragilidadDTO(String descripcion, boolean habilitado) {
		super();
		this.descripcion = descripcion;
		this.habilitado = habilitado;
	}

	public CategoriaFragilidadDTO() {
		super();
		// TODO Auto-generated constructor stub
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
