package dto;

import java.io.Serializable;
import dto.ClienteDTO;
import dto.PaisDTO;
import dto.ProvinciaDTO;

public class DestinatarioDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 627251843776850642L;
	
	
	private int id;
	private String nombre;
	private String domicilio;
	private String codigoPostal;
	private PaisDTO pais;
	private ProvinciaDTO provincia;
	private int piso;
	private String departamento;
	private int nroDocumento;
	private String personasAutorizadas;
	private ClienteDTO clienteRemitente;
	
	
	public DestinatarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DestinatarioDTO(String nombre, String domicilio, String codigoPostal, PaisDTO pais, ProvinciaDTO provincia,
			int piso, String departamento, int nroDocumento, String personasAutorizadas, ClienteDTO clienteRemitente) {
		super();
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


	public PaisDTO getPais() {
		return pais;
	}


	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}


	public ProvinciaDTO getProvincia() {
		return provincia;
	}


	public void setProvincia(ProvinciaDTO provincia) {
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


	public ClienteDTO getClienteRemitente() {
		return clienteRemitente;
	}


	public void setClienteRemitente(ClienteDTO clienteRemitente) {
		this.clienteRemitente = clienteRemitente;
	}


	public int getId() {
		return id;
	}
}
