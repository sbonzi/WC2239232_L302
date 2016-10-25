package dto;

import java.io.Serializable;

public class ItemFacturaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5047548536238360306L;
	
	private CargaDTO carga;

	public ItemFacturaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemFacturaDTO(CargaDTO carga) {
		super();
		this.carga = carga;
	}

	public CargaDTO getCarga() {
		return carga;
	}

	public void setCarga(CargaDTO carga) {
		this.carga = carga;
	}

	@Override
	public String toString(){
		return "[Carga=(" + carga + ")]";
	}
	
}
