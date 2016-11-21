package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Mantenimiento")
public class Mantenimiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2127690329550767328L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "fecha", columnDefinition="DATE")
	@Type(type="date")
	private Date fecha;
	
	private String tipo;
	private int ultimoKilometraje;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Vehiculo")
	private Vehiculo vehiculo;
	
	public Mantenimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mantenimiento(Date fecha, String tipo, int ultimoKilometraje) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
		this.ultimoKilometraje = ultimoKilometraje;
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
