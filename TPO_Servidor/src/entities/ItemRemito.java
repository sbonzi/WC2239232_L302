package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ItemRemito")
public class ItemRemito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1597477407028985743L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable = false)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Remito")
	private Remito remito;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Carga")
	private Carga carga;

	public ItemRemito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemRemito(Remito remito, Carga carga) {
		super();
		this.remito = remito;
		this.carga = carga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Remito getRemito() {
		return remito;
	}

	public void setRemito(Remito remito) {
		this.remito = remito;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}
}
