package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EstadoEnvio")
public class EstadoEnvio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4700673261841523338L;
	
	@Id
	@GeneratedValue()
	private int id;
	private String descripcion;
	private boolean habilitado;
	
	public EstadoEnvio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoEnvio(int id, String descripcion, boolean habilitado) {
		super();
		this.id = id;
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

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
}
