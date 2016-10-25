package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Manifiesto")
public class Manifiesto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 566675663969314578L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String declaracion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Carga")
	private Carga carga;

	public Manifiesto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manifiesto(String declaracion) {
		super();
		this.declaracion = declaracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeclaracion() {
		return declaracion;
	}

	public void setDeclaracion(String declaracion) {
		this.declaracion = declaracion;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}
}
