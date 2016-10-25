package dto;

import java.io.Serializable;

public class ServicioTercerizadoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7718966513685179916L;
	
	private String descServicio;
	private String empresa;
	
	public ServicioTercerizadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicioTercerizadoDTO(String descServicio, String empresa) {
		super();
		this.descServicio = descServicio;
		this.empresa = empresa;
	}

	public String getDescServicio() {
		return descServicio;
	}

	public void setDescServicio(String descServicio) {
		this.descServicio = descServicio;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
