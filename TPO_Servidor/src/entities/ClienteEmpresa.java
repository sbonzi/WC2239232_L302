package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("e") 
public class ClienteEmpresa extends Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3244496587915417189L;
	
	private int cuit;
	private boolean depositaSaldoAFavor;
	private boolean pagoMensualPorViaje;
	private float  montoMinPedirAutor;
	
	@OneToMany(mappedBy="clienteEmpresa",cascade = CascadeType.ALL)
	@JoinColumn(name="id_ClienteEmpresa")
	private List<ProductoEmpresa> productos;
	
	@OneToMany(mappedBy="clienteEmpresa",cascade = CascadeType.ALL)
	@JoinColumn(name="id_ClienteEmpresa")
	private List<CuentaCorrienteEmpresa> ctasCtes;
	
	public ClienteEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteEmpresa(int cuit, boolean depositaSaldoAFavor, boolean pagoMensualPorViaje,
			Float montoMinPedirAutor) {
		super();
		this.cuit = cuit;
		this.depositaSaldoAFavor = depositaSaldoAFavor;
		this.pagoMensualPorViaje = pagoMensualPorViaje;
		this.montoMinPedirAutor = montoMinPedirAutor;
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

	public boolean isPagoMensualPorViaje() {
		return pagoMensualPorViaje;
	}

	public void setPagoMensualPorViaje(boolean pagoMensualPorViaje) {
		this.pagoMensualPorViaje = pagoMensualPorViaje;
	}

	public Float getMontoMinPedirAutor() {
		return montoMinPedirAutor;
	}

	public void setMontoMinPedirAutor(Float montoMinPedirAutor) {
		this.montoMinPedirAutor = montoMinPedirAutor;
	}
}
