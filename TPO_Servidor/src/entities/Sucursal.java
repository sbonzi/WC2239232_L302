package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Sucursal")
public class Sucursal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6184587597248139838L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //No funciona
	@Column(name="id")
	private int id;
	private String nombre;
	private String direccion;
	private String latitud;
	private String longitud;
	
	/*
	 * Solamente contiene el listado de rutas hacia las sucursales adyacentes (las que conoce)
	 */
	@OneToMany(mappedBy="sucursalOrigen",cascade = CascadeType.ALL)
	@JoinColumn(name="id_SucursalOrigen")
	private List<Ruta> rutasOrigen;
	
	@OneToMany(mappedBy="sucursalDestino",cascade = CascadeType.ALL)
	@JoinColumn(name="id_SucursalDestino")
	private List<Ruta> rutasDestino;
	
	@OneToMany(mappedBy="sucursal",cascade = CascadeType.ALL)
	@JoinColumn(name="id_Sucursal")
	private List<Empleado> empleados;
	
	/*
	@OneToMany(mappedBy="sucursal",cascade = CascadeType.ALL)
	@JoinColumn(name="id_Sucursal")
	private List<Viaje> viajesSucursal;
	*/

	public Sucursal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sucursal(String nombre, String direccion, String latitud, String longitud) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Ruta> getRutasOrigen() {
		return rutasOrigen;
	}

	public void setRutasOrigen(List<Ruta> rutasOrigen) {
		this.rutasOrigen = rutasOrigen;
	}

	public List<Ruta> getRutasDestino() {
		return rutasDestino;
	}

	public void setRutasDestino(List<Ruta> rutasDestino) {
		this.rutasDestino = rutasDestino;
	}
}
