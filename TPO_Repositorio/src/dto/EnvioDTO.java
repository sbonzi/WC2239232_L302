package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public abstract class EnvioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4462528571723509223L;
	
	private int idEnvio;
	private List<CargaDTO> cargas;	
	private ClienteDTO cliente;
	private Float cobro;
	private boolean cobroOrigen;
	private EstadoEnvioDTO estado;
	private Date fechaMaxLlegada;
	private boolean retiroEnSucursal;
	private SucursalDTO sucursalDestino;
	private SucursalDTO sucursalOrigen;
	private boolean tercerizarEnvio;
	private boolean trajoCajaEnPersona;
	private boolean esClienteEmpresa;
	
	public EnvioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EnvioDTO(int idEnvio ,List<CargaDTO> cargas, ClienteDTO cliente, Float cobro, boolean cobroOrigen, EstadoEnvioDTO estado,
			Date fechaMaxLlegada, boolean retiroEnSucursal, SucursalDTO sucursalDestino, SucursalDTO sucursalOrigen,
			boolean tercerizarEnvio, boolean trajoCajaEnPersona) {
		super();
		this.idEnvio = idEnvio;
		this.cargas = cargas;
		this.cliente = cliente;
		this.cobro = cobro;
		this.cobroOrigen = cobroOrigen;
		this.estado = estado;
		this.fechaMaxLlegada = fechaMaxLlegada;
		this.retiroEnSucursal = retiroEnSucursal;
		this.sucursalDestino = sucursalDestino;
		this.sucursalOrigen = sucursalOrigen;
		this.tercerizarEnvio = tercerizarEnvio;
		this.trajoCajaEnPersona = trajoCajaEnPersona;
	}

	public int getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}
	
	public List<CargaDTO> getCargas() {
		return cargas;
	}

	public void setCargas(List<CargaDTO> cargas) {
		this.cargas = cargas;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
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

	public EstadoEnvioDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnvioDTO estado) {
		this.estado = estado;
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

	public SucursalDTO getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(SucursalDTO sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public SucursalDTO getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(SucursalDTO sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public boolean isTercerizarEnvio() {
		return tercerizarEnvio;
	}

	public void setTercerizarEnvio(boolean tercerizarEnvio) {
		this.tercerizarEnvio = tercerizarEnvio;
	}

	public boolean isTrajoCajaEnPersona() {
		return trajoCajaEnPersona;
	}

	public void setTrajoCajaEnPersona(boolean trajoCajaEnPersona) {
		this.trajoCajaEnPersona = trajoCajaEnPersona;
	}
	
	public boolean isEsClienteEmpresa() {
		return esClienteEmpresa;
	}

	public void setEsClienteEmpresa(boolean esClienteEmpresa) {
		this.esClienteEmpresa = esClienteEmpresa;
	}
	
	@Override
	public String toString(){
		return "[cargas=(" + cargas + "),cliente=" + cliente + "]";
	}
}