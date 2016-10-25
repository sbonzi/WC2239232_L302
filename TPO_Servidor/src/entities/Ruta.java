package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ruta")
public class Ruta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108150870112754118L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private int duracionViaje;
	private Float costoViaje;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_SucursalOrigen")
	private Sucursal sucursalOrigen;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_SucursalDestino")
	private Sucursal sucursalDestino;
	
	/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Viaje")
	private Viaje viaje;
	*/
	
	/**
	 * Corresponde a todas las lineas (unión de dos puntos latitud - longitud) que forman una ruta
	 * entre dos sucursales
	 */
	/*
	@OneToMany
	List<Camino> caminos;
	*/

	public Ruta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ruta(int duracionViaje, Float costoViaje, Sucursal sucursalOrigen, Sucursal sucursalDestino) {
		super();
		this.duracionViaje = duracionViaje;
		this.costoViaje = costoViaje;
		this.sucursalOrigen = sucursalOrigen;
		this.sucursalDestino = sucursalDestino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuracionViaje() {
		return duracionViaje;
	}

	public void setDuracionViaje(int duracionViaje) {
		this.duracionViaje = duracionViaje;
	}

	public Float getCostoViaje() {
		return costoViaje;
	}

	public void setCostoViaje(Float costoViaje) {
		this.costoViaje = costoViaje;
	}

	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}
	
	/*
	public List<Camino> getCaminos() {
		return caminos;
	}

	public void setCaminos(List<Camino> caminos) {
		this.caminos = caminos;
	}
	*/

}
