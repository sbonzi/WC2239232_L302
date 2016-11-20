package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Provincia")
public class Provincia implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3759212072917629102L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descripcion;
	private Boolean habilitado;
	
	@OneToOne
	@JoinColumn(name="id_Pais")
	private Pais pais;
	
	
	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provincia(String descripcion, boolean habilitado, Pais pais) {
		super();
		this.descripcion = descripcion;
		this.habilitado = habilitado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
