package dto;

import java.io.Serializable;

public class EstadoEnvioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5155975667211959583L;
	
	private int id;
	private  String descripcion;
	private boolean habilitado;
	
	public EstadoEnvioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoEnvioDTO(String descripcion, boolean habilitado) {
		super();
		this.descripcion = descripcion;
		this.habilitado = habilitado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
