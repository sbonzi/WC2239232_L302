package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Corresponde a un tramo de una ruta, definido por un punto de origen y otro de destino
 * Permite determinar si un viaje se está realizando dentro de lo establecido por el mapa de rutas
 * @author Daniel PC
 *
 */
public class Camino implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3228185442580533702L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	private String latitudOrigen;
	private String longitudOrigen;
	private String latitudDestino;
	private String longitudDestino;

	@ManyToOne
	@JoinColumn(name="id_Ruta")
	private Ruta ruta;
	
	public Camino() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Camino(String latitudOrigen,
				  String longitudOrigen,
				  String latitudDestino,
				  String longitudDestino) {
		super();
		this.latitudOrigen = latitudOrigen;
		this.longitudOrigen = longitudOrigen;
		this.latitudDestino = latitudDestino;
		this.longitudDestino = longitudDestino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLatitudOrigen() {
		return latitudOrigen;
	}

	public void setLatitudOrigen(String latitudOrigen) {
		this.latitudOrigen = latitudOrigen;
	}

	public String getLongitudOrigen() {
		return longitudOrigen;
	}

	public void setLongitudOrigen(String longitudOrigen) {
		this.longitudOrigen = longitudOrigen;
	}

	public String getLatitudDestino() {
		return latitudDestino;
	}

	public void setLatitudDestino(String latitudDestino) {
		this.latitudDestino = latitudDestino;
	}

	public String getLongitudDestino() {
		return longitudDestino;
	}

	public void setLongitudDestino(String longitudDestino) {
		this.longitudDestino = longitudDestino;
	}

}
