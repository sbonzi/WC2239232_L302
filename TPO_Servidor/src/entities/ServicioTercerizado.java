package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ServicioTercerizado")
public class ServicioTercerizado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 684438820979209339L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String descripcion;
	private int tiempoDeEntregaDias;
	private String seguridadDeCarga;
	private float tarifa;
	
	public ServicioTercerizado() {
		super();
	}

	public ServicioTercerizado(int id, String nombre, String descripcion, int tiempoDeEntregaDias,
			String seguridadDeCarga, float tarifa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoDeEntregaDias = tiempoDeEntregaDias;
		this.seguridadDeCarga = seguridadDeCarga;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTiempoDeEntregaDias() {
		return tiempoDeEntregaDias;
	}

	public void setTiempoDeEntregaDias(int tiempoDeEntregaDias) {
		this.tiempoDeEntregaDias = tiempoDeEntregaDias;
	}

	public String getSeguridadDeCarga() {
		return seguridadDeCarga;
	}

	public void setSeguridadDeCarga(String seguridadDeCarga) {
		this.seguridadDeCarga = seguridadDeCarga;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
}
