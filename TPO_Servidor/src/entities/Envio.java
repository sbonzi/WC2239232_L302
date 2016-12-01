package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;


@Entity
@Table(name="Envio")
public class Envio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5401428529764483L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable = false)
	private int idEnvio;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="envio",cascade = CascadeType.ALL)
	@JoinColumn(name="id_envio")
	private List<Carga> cargas;
	
	@ManyToOne
	@JoinColumn(name="id_Cliente")
	private Cliente cliente;
	
	private Float cobro;
	
	@Column(name="cobroEnOrigen")
	private boolean cobroOrigen;
	
	@Column(name = "fecha", columnDefinition="DATE")
	@Type(type="date")
	private Date fechaMaxLlegada;
	
	private boolean retiroEnSucursal;
	
	@OneToOne
	@JoinColumn(name="id_SucursalDestino")
	private Sucursal sucursalDestino;
	
	@OneToOne
	@JoinColumn(name="id_SucursalOrigen")
	private Sucursal sucursalOrigen;
	
	private boolean tercerizarEnvio;
	private boolean trajoCargaEnPersona;
	
	@OneToOne
	@JoinColumn(name="id_EstadoEnvio")
	private EstadoEnvio estadoEnvio;
	
	private boolean esClienteEmpresa;
	
	@ManyToOne
	@JoinColumn(name="id_Viaje")
	private Viaje viaje;
	
	@OneToOne
	@JoinColumn(name="id_Destinatario")
	private Destinatario destinatario;

	public Envio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Envio(Cliente cliente,
				 Float cobro, 
				 boolean cobroOrigen,
				 Date fechaMaxLlegada,
				 boolean retiroEnSucursal,
				 Sucursal sucursalDestino,
				 Sucursal sucursalOrigen,
				 boolean tercerizarEnvio,
				 boolean trajoCargaEnPersona,
				 EstadoEnvio estadoEnvio,
				 boolean esClienteEmpresa,
				 Destinatario destinatario) {
		super();
		this.cliente				= cliente;
		this.cobro 					= cobro;
		this.cobroOrigen 			= cobroOrigen;
		this.fechaMaxLlegada		= fechaMaxLlegada;
		this.retiroEnSucursal 		= retiroEnSucursal;
		this.sucursalDestino 		= sucursalDestino;
		this.sucursalOrigen 		= sucursalOrigen;
		this.tercerizarEnvio 		= tercerizarEnvio;
		this.trajoCargaEnPersona 	= trajoCargaEnPersona;
		this.estadoEnvio 			= estadoEnvio;
		this.esClienteEmpresa 		= esClienteEmpresa;
		this.destinatario		    = destinatario;
	}

	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Float getCobro() {
		return cobro;
	}

	public void setCobro(Float cobro) {
		this.cobro = cobro;
	}

	public boolean isCobroOrigen() {
		return cobroOrigen;
	}

	public void setCobroOrigen(boolean cobroOrigen) {
		this.cobroOrigen = cobroOrigen;
	}

	public Date getFechaMaxLlegada() {
		return fechaMaxLlegada;
	}

	public void setFechaMaxLlegada(Date fechaMaxLlegada) {
		this.fechaMaxLlegada = fechaMaxLlegada;
	}

	public boolean isRetiroEnSucursal() {
		return retiroEnSucursal;
	}

	public void setRetiroEnSucursal(boolean retiroEnSucursal) {
		this.retiroEnSucursal = retiroEnSucursal;
	}

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public boolean isTercerizarEnvio() {
		return tercerizarEnvio;
	}

	public void setTercerizarEnvio(boolean tercerizarEnvio) {
		this.tercerizarEnvio = tercerizarEnvio;
	}

	public boolean isTrajoCargaEnPersona() {
		return trajoCargaEnPersona;
	}

	public void setTrajoCargaEnPersona(boolean trajoCargaEnPersona) {
		this.trajoCargaEnPersona = trajoCargaEnPersona;
	}

	public int getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public EstadoEnvio getEstadoEnvio() {
		return estadoEnvio;
	}

	public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

	public boolean isEsClienteEmpresa() {
		return esClienteEmpresa;
	}

	public void setEsClienteEmpresa(boolean esClienteEmpresa) {
		this.esClienteEmpresa = esClienteEmpresa;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}
	
	
}
