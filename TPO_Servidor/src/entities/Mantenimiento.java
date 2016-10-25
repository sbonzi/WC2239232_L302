package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mantinimiento")
public class Mantenimiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2127690329550767328L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date fecha;
	private String tipo;
	private int ultimoKilometraje;
	
	@ManyToOne
	@JoinColumn(name="id_Vehiculo")
	private Vehiculo vehiculo;
	
	public Mantenimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mantenimiento(Date fecha, String tipo, int ultimoKilometraje, Vehiculo vehiculo) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
		this.ultimoKilometraje = ultimoKilometraje;
		this.vehiculo = vehiculo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
}
