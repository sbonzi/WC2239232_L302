package dto;

import java.io.Serializable;

public class EmpleadoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -668066613453014501L;
	
	private int numero;
	private String cuit;
	private String nombre;
	private RolEmpleadoDTO rolEmpleado;
	private SucursalDTO sucursal;
	
	public EmpleadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoDTO(String cuit, String nombre) {
		super();
		this.cuit = cuit;
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public RolEmpleadoDTO getRolEmpleado() {
		return rolEmpleado;
	}

	public void setRolEmpleado(RolEmpleadoDTO rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}

	public SucursalDTO getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}

	@Override
	public String toString(){
		return "[cuit=" + cuit + ",nombre=" + nombre + "]";
	}
}
