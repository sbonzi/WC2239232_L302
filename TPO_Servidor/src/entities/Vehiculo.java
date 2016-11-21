package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Vehiculo")
public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8782469445465613034L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int anio;
	private boolean habilitadoParaUtilizar;
	private int kilometraje;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="vehiculo",cascade = CascadeType.ALL)
	@JoinColumn(name="id_Vehiculo")
	private List<Mantenimiento> mantenimientos;
	
	private String marca;
	private String modelo;
	private String patente;
	private Float peso;
	private Float tara;
	
	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(int anio, boolean habilitadoParaUtilizar, int kilometraje,
			String marca, String modelo, String patente, Float peso, Float tara) {
		super();
		this.anio = anio;
		this.habilitadoParaUtilizar = habilitadoParaUtilizar;
		this.kilometraje = kilometraje;
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.peso = peso;
		this.tara = tara;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public boolean isHabilitadoParaUtilizar() {
		return habilitadoParaUtilizar;
	}

	public void setHabilitadoParaUtilizar(boolean habilitadoParaUtilizar) {
		this.habilitadoParaUtilizar = habilitadoParaUtilizar;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getTara() {
		return tara;
	}

	public void setTara(Float tara) {
		this.tara = tara;
	}
}
