package dto;

import java.io.Serializable;

public class DestinatarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7580499865212433524L;
	
	private String ciudad;
	private String codigoPostal;
	private String departamento;
	private String descripcionAdicional;
	private int docReceptor;
	private String nombreReceptor;
	private int numeroDomicilio;
	private PaisDTO pais;
	private String  personasAutorizadas;
	private int piso;
	private ProvinciaDTO provincia;
	
	public DestinatarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DestinatarioDTO(String ciudad, String codigoPostal, String departamento, String descripcionAdicional,
			int docReceptor, String nombreReceptor, int numeroDomicilio, PaisDTO pais, String personasAutorizadas,
			int piso, ProvinciaDTO provincia) {
		super();
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.departamento = departamento;
		this.descripcionAdicional = descripcionAdicional;
		this.docReceptor = docReceptor;
		this.nombreReceptor = nombreReceptor;
		this.numeroDomicilio = numeroDomicilio;
		this.pais = pais;
		this.personasAutorizadas = personasAutorizadas;
		this.piso = piso;
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDescripcionAdicional() {
		return descripcionAdicional;
	}

	public void setDescripcionAdicional(String descripcionAdicional) {
		this.descripcionAdicional = descripcionAdicional;
	}

	public int getDocReceptor() {
		return docReceptor;
	}

	public void setDocReceptor(int docReceptor) {
		this.docReceptor = docReceptor;
	}

	public String getNombreReceptor() {
		return nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public int getNumeroDomicilio() {
		return numeroDomicilio;
	}

	public void setNumeroDomicilio(int numeroDomicilio) {
		this.numeroDomicilio = numeroDomicilio;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public String getPersonasAutorizadas() {
		return personasAutorizadas;
	}

	public void setPersonasAutorizadas(String personasAutorizadas) {
		this.personasAutorizadas = personasAutorizadas;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public ProvinciaDTO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaDTO provincia) {
		this.provincia = provincia;
	}

}
