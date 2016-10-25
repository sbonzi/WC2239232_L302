package dto;

import java.io.Serializable;

public class ItemRemitoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1990273280620734269L;
	
	private CargaDTO carga;

	public ItemRemitoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemRemitoDTO(CargaDTO carga) {
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
