package dto;

import java.io.Serializable;

public class EmpresaSeguridadDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3682342242036840909L;
	
	private int id;
	private String nombre;
	private String servicio;
	private float tarifa;
	
	public EmpresaSeguridadDTO() {
		super();
	}

	public EmpresaSeguridadDTO(int id, String nombre, String servicio, float tarifa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.servicio = servicio;
		this.tarifa = tarifa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}

}
