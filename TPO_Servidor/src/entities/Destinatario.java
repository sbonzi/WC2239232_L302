package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Destinatario")
public class Destinatario implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1255542385570162872L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String domicilio;
	private String codigoPostal;
	@OneToOne
	@JoinColumn(name="id_Pais")
	private Pais pais;
	
	@OneToOne
	@JoinColumn(name="id_Provincia")
	private Provincia provincia;
	
	private int piso;
	private String departamento;
	private int nroDocumento;
	private String personasAutorizadas;
	
	@OneToOne
	@JoinColumn(name="id_ClienteRemitente")
	private Cliente clienteRemitente;
	
	public Destinatario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Destinatario(int id, String nombre, String domicilio, String codigoPostal, Pais pais, Provincia provincia,
			int piso, String departamento, int nroDocumento, String personasAutorizadas, Cliente clienteRemitente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.provincia = provincia;
		this.piso = piso;
		this.departamento = departamento;
		this.nroDocumento = nroDocumento;
		this.personasAutorizadas = personasAutorizadas;
		this.clienteRemitente = clienteRemitente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getPersonasAutorizadas() {
		return personasAutorizadas;
	}

	public void setPersonasAutorizadas(String personasAutorizadas) {
		this.personasAutorizadas = personasAutorizadas;
	}

	public Cliente getClienteRemitente() {
		return clienteRemitente;
	}

	public void setClienteRemitente(Cliente clienteRemitente) {
		this.clienteRemitente = clienteRemitente;
	}

	public int getId() {
		return id;
	}
	
}
