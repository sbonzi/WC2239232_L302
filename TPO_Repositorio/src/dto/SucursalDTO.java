package dto;

import java.io.Serializable;
import java.util.List;

public class SucursalDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5313528543876586664L;
	
	private int numero;
	private String nombre;
	private String direccion;
	private String latitud;
	private String longitud;
	
	List<RutaDTO> rutas;
	
	/*
	List<EmpleadoDTO> empleados;
	List<ViajeDTO> viajes;
	*/
	
	public SucursalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SucursalDTO(String nombre,
					   String direccion,
					   String latitud,
					   String longitud) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
	
	public List<RutaDTO> getRutas() {
		return rutas;
	}

	public void setRutas(List<RutaDTO> rutas) {
		this.rutas = rutas;
	}

	@Override
	public String toString(){
		return "Sucursal:[nombre=" + nombre +
					   ", dirección=" + direccion +
					   ", numero=" + numero +
					   ", lat=" + latitud +
					   ", lon=" + longitud + "]";
	}
}
