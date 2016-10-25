package dto;

import java.io.Serializable;

public class ParticularDTO extends ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2547260018466170595L;

	private int numDoc;
	private char tipoDoc;
	
	public ParticularDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParticularDTO(String domicilio, String nombre) {
		super(domicilio, nombre);
		// TODO Auto-generated constructor stub
	}

	public int getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}

	public char getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(char tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
}
