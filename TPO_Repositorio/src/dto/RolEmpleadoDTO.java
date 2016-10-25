package dto;

import java.io.Serializable;

public class RolEmpleadoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7342617610142765867L;
	
	private int id;
	private String descripcion;
	
	public RolEmpleadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolEmpleadoDTO(String descripcion) {
		super();
		this.descripcion = descripcion;
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
	
	@Override
	public String toString(){
		return "RolEmpleado:[nroRol=" + id + ", descripcion=" + descripcion + "]";
	}
}
