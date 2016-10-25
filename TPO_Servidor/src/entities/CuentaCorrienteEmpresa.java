package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CuentaCorrienteEmpresa")
public class CuentaCorrienteEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 335113363183136749L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private float saldo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_ClienteEmpresa")
	private Cliente clienteEmpresa;

	public CuentaCorrienteEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaCorrienteEmpresa(float saldo, Cliente clienteEmpresa) {
		super();
		this.saldo 			= saldo;
		this.clienteEmpresa = clienteEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Cliente getClienteEmpresa() {
		return clienteEmpresa;
	}

	public void setClienteEmpresa(Cliente clienteEmpresa) {
		this.clienteEmpresa = clienteEmpresa;
	}

}
