package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CategoriaTratamiento")
public class CategoriaTratamiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5403436685246781746L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descripcion;
	private boolean habilitado;
	
	public CategoriaTratamiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaTratamiento(String descripcion, boolean habilitado,int id) {
		super();
		this.descripcion = descripcion;
		this.habilitado = habilitado;
		this.id = id;
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
