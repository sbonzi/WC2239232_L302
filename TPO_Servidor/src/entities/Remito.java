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

import org.hibernate.annotations.Type;

@Entity
@Table(name="Remito")
public class Remito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4948573134319975315L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name = "fecha", columnDefinition="DATE")
	@Type(type="date")
	private Date fecha;
	
	@OneToMany(mappedBy="remito",cascade = CascadeType.ALL)
	@JoinColumn(name="id_Remito")
	private List<ItemRemito> itemsRemito;

	public Remito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Remito(Date fecha) {
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

	public List<ItemRemito> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemito> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
}
