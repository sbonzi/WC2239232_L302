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
@Table(name="ItemFactura")
public class ItemFactura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8391939816909204468L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable = false)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Factura")
	private Factura factura;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Carga")
	private Carga carga;

	public ItemFactura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemFactura(Factura factura, Carga carga) {
		super();
		this.factura = factura;
		this.carga = carga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}	
}
