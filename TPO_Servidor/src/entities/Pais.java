package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pais")
public class Pais implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7395565710951145725L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descripcion;
	private Boolean habilitado;

	
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pais(String descripcion, boolean habilitado) {
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
}
