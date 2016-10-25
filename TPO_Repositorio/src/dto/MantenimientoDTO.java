package dto;

import java.io.Serializable;
import java.util.Date;

public class MantenimientoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3515381920118471317L;
	
	private Date fecha;
	private String tipo;
	private int ultimoKilometraje;
	private VehiculoDTO vehiculo;
	
	public MantenimientoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MantenimientoDTO(Date fecha, String tipo, int ultimoKilometraje) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
		this.ultimoKilometraje = ultimoKilometraje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getUltimoKilometraje() {
		return ultimoKilometraje;
	}

	public void setUltimoKilometraje(int ultimoKilometraje) {
		this.ultimoKilometraje = ultimoKilometraje;
	}

	public VehiculoDTO getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoDTO vehiculo) {
		this.vehiculo = vehiculo;
	}
}
