package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmpresaSeguridad")
public class EmpresaSeguridad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -418455881018113517L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String servicio;
	private float tarifa;
	
	public EmpresaSeguridad() {
		super();
	}

	public EmpresaSeguridad(int id, String nombre, String servicio, float tarifa) {
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
