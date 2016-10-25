package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RemitoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4420058504955774610L;
	
	private Date fecha;
	private List<ItemRemitoDTO> itemsRemito;
	private int numero;
	
	public RemitoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RemitoDTO(Date fecha, List<ItemRemitoDTO> itemsRemito, int numero) {
		super();
		this.fecha = fecha;
		this.itemsRemito = itemsRemito;
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<ItemRemitoDTO> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemitoDTO> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString(){
		return "[ItemsRemito=(" + itemsRemito + ")]";
	}

}
