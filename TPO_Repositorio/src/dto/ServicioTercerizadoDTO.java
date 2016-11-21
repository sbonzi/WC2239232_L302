package dto;

import java.io.Serializable;

public class ServicioTercerizadoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7718966513685179916L;
	
	private int id;
	private String nombre;
	private String descripcion;
	private int tiempoDeEntregaDias;
	private String seguridadDeCarga;
	private float tarifa;
	
	public ServicioTercerizadoDTO() {
		super();
	}

	public ServicioTercerizadoDTO(int id, String nombre, String descripcion, int tiempoDeEntregaDias,
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
