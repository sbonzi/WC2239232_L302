package dto;

import java.io.Serializable;

public class CtaCteEmpresaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3424191793660803882L;
	
	private int numero;
	private Float saldo;
	
	public CtaCteEmpresaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CtaCteEmpresaDTO(int numero, Float saldo) {
		super();
		this.numero = numero;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	
}
