package dto;

import java.io.Serializable;
import java.util.List;

public class EmpresaDTO extends ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7640422024493448470L;
	
	private List<CtaCteEmpresaDTO> ctasCtes;
	private int cuit;
	private boolean depositaSaldoAFavor;
	private List<DestinatarioDTO> destinatarios;
	private Float montoMinPedirAutor;
	private boolean pagoMensualPorViaje;
	private List<ProductoEmpresaDTO> productos;
	
	public EmpresaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpresaDTO(List<CtaCteEmpresaDTO> ctasCtes, int cuit, boolean depositaSaldoAFavor,
			List<DestinatarioDTO> destinatarios, Float montoMinPedirAutor, boolean pagoMensualPorViaje,
			List<ProductoEmpresaDTO> productos) {
		super();
		this.ctasCtes = ctasCtes;
		this.cuit = cuit;
		this.depositaSaldoAFavor = depositaSaldoAFavor;
		this.destinatarios = destinatarios;
		this.montoMinPedirAutor = montoMinPedirAutor;
		this.pagoMensualPorViaje = pagoMensualPorViaje;
		this.productos = productos;
	}

	public List<CtaCteEmpresaDTO> getCtasCtes() {
		return ctasCtes;
	}

	public void setCtasCtes(List<CtaCteEmpresaDTO> ctasCtes) {
		this.ctasCtes = ctasCtes;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public boolean isDepositaSaldoAFavor() {
		return depositaSaldoAFavor;
	}

	public void setDepositaSaldoAFavor(boolean depositaSaldoAFavor) {
		this.depositaSaldoAFavor = depositaSaldoAFavor;
	}

	public List<DestinatarioDTO> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(List<DestinatarioDTO> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public Float getMontoMinPedirAutor() {
		return montoMinPedirAutor;
	}

	public void setMontoMinPedirAutor(Float montoMinPedirAutor) {
		this.montoMinPedirAutor = montoMinPedirAutor;
	}

	public boolean isPagoMensualPorViaje() {
		return pagoMensualPorViaje;
	}

	public void setPagoMensualPorViaje(boolean pagoMensualPorViaje) {
		this.pagoMensualPorViaje = pagoMensualPorViaje;
	}

	public List<ProductoEmpresaDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoEmpresaDTO> productos) {
		this.productos = productos;
	}

}
