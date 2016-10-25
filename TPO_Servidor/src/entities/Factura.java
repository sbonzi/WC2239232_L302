package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Factura")
public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1204463427639728284L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable = false)
	private int id;
	
	private Date fecha;
	
	@OneToMany(mappedBy="factura",cascade = CascadeType.ALL)
	@JoinColumn(name="id_Factura")
	private List<ItemFactura> itemsFactura;

	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura(Date fecha) {
		super();
		this.fecha = fecha;
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

	public List<ItemFactura> getItemsFactura() {
		return itemsFactura;
	}

	public void setItemsFactura(List<ItemFactura> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
}
