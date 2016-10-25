package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EstadoViaje")
public class EstadoViaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5612767851920921143L;
	
	@Id
	@GeneratedValue()
	private int id;
	private String descripcion;
	private boolean habilitado;
	
	public EstadoViaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoViaje(int id, String descripcion, boolean habilitado) {
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
