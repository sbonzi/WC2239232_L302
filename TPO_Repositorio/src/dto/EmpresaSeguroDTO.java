package dto;

import java.io.Serializable;
import java.util.List;

public class EmpresaSeguroDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8794824606844106310L;
	
	private int id;
	private String nombre;
	private String tipoSeguro;
	private boolean habilitado;
	
	List<MercaderiaAseguradaDTO> mercaderiasAseguradas;

	public EmpresaSeguroDTO() {
		super();
	}

	public EmpresaSeguroDTO(String nombre,
						String tipoSeguro,
						boolean habilitado,
						List<MercaderiaAseguradaDTO> mercaderiasAseguradas) {
		super();
		this.nombre = nombre;
		this.tipoSeguro = tipoSeguro;
		this.habilitado = habilitado;
		this.mercaderiasAseguradas = mercaderiasAseguradas;
	}

	public EmpresaSeguroDTO(int id, String nombre, String tipoSeguro, boolean habilitado,
			List<MercaderiaAseguradaDTO> mercaderiasAseguradas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoSeguro = tipoSeguro;
		this.habilitado = habilitado;
		this.mercaderiasAseguradas = mercaderiasAseguradas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<MercaderiaAseguradaDTO> getMercaderiasAseguradas() {
		return mercaderiasAseguradas;
	}

	public void setMercaderiasAseguradas(List<MercaderiaAseguradaDTO> mercaderiasAseguradas) {
		this.mercaderiasAseguradas = mercaderiasAseguradas;
	}

}
