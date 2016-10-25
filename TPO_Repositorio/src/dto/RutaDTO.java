package dto;

import java.io.Serializable;

public class RutaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7978321266200812833L;
	private int numero;
	private int duracionViaje;
	private Float costoViaje;
	private SucursalDTO sucursalOrigen;
	private SucursalDTO sucursalDestino;
	
	public RutaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RutaDTO(int duracionViaje,
				   Float costoViaje,
				   SucursalDTO sucursalOrigen,
				   SucursalDTO sucursalDestino) {
		super();
		this.duracionViaje 		= duracionViaje;
		this.costoViaje 		= costoViaje;
		this.sucursalOrigen 	= sucursalOrigen;
		this.sucursalDestino 	= sucursalDestino;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public SucursalDTO getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(SucursalDTO sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public SucursalDTO getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(SucursalDTO sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}
	
	public String toString(){
		return "Ruta:[duracionViaje=" + duracionViaje +
				   ", costoViaje=" + costoViaje + 
				   ", nroSucursalOrigen= " + sucursalOrigen.getNumero() +
				   ", nroSucursalDestino= " + sucursalDestino.getNumero() + "]";
	}
	
	
}
