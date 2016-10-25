package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ProductoEmpresa")
public class ProductoEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4279858270106953715L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	private float alto;
	private float ancho;
	private float profundidad;
	private float peso;
	private int codigo;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_ClienteEmpresa")
	private ClienteEmpresa clienteEmpresa;

	public ProductoEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoEmpresa(float alto, float ancho, float profundidad, float peso, int codigo, String descripcion,
			ClienteEmpresa clienteEmpresa) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.peso = peso;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.clienteEmpresa = clienteEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAlto() {
		return alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(float profundidad) {
		this.profundidad = profundidad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ClienteEmpresa getClienteEmpresa() {
		return clienteEmpresa;
	}

	public void setClienteEmpresa(ClienteEmpresa clienteEmpresa) {
		this.clienteEmpresa = clienteEmpresa;
	}
}
