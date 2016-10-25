package dto;

import java.io.Serializable;

public class ManifiestoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5077295653821093946L;
	
	private String declaracion;

	public ManifiestoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManifiestoDTO(String declaracion) {
		super();
		this.declaracion = declaracion;
	}

	public String getDeclaracion() {
		return declaracion;
	}

	public void setDeclaracion(String declaracion) {
		this.declaracion = declaracion;
	}
}
