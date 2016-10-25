package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FacturaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6631567043061877245L;
	
	private Date fecha;
	private List<ItemFacturaDTO> itemsFactura;
	private int numero;
	
	public FacturaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacturaDTO(Date fecha, List<ItemFacturaDTO> itemsFactura, int numero) {
		super();
		this.fecha = fecha;
		this.itemsFactura = itemsFactura;
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<ItemFacturaDTO> getItemsFactura() {
		return itemsFactura;
	}

	public void setItemsFactura(List<ItemFacturaDTO> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString(){
		return "[ItemsFactura=(" + itemsFactura + ")]";
	}

}
