package dto;

import java.io.Serializable;

public class MercaderiaAseguradaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -184731337591468533L;
	
	private int id;
	private String tipoMercaderia;
	private float tarifa;
	
	public MercaderiaAseguradaDTO() {
		super();
	}

	public MercaderiaAseguradaDTO(String tipoMercaderia, float tarifa) {
		super();
		this.tipoMercaderia = tipoMercaderia;
		this.tarifa = tarifa;
	}

	public MercaderiaAseguradaDTO(int id, String tipoMercaderia, float tarifa) {
		super();
		this.id = id;
		this.tipoMercaderia = tipoMercaderia;
		this.tarifa = tarifa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoMercaderia() {
		return tipoMercaderia;
	}

	public void setTipoMercaderia(String tipoMercaderia) {
		this.tipoMercaderia = tipoMercaderia;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	
	@Override
	public String toString(){
		return "[Tipo: " + this.getTipoMercaderia() + " - tarifa: " + this.getTarifa() + "]";
	}
}
