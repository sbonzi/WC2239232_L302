package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MercaderiaAsegurada")
public class MercaderiaAsegurada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -850039573130063110L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tipoMercaderia;
	private float tarifa;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_EmpresaSeguro")
	private EmpresaSeguro empresaSeguro;

	public MercaderiaAsegurada() {
		super();
	}

	public MercaderiaAsegurada(String tipoMercaderia, float tarifa, EmpresaSeguro empresaSeguro) {
		super();
		this.tipoMercaderia = tipoMercaderia;
		this.tarifa = tarifa;
		this.empresaSeguro = empresaSeguro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoMercaderia() {
		return tipoMercaderia;
	}

	public void setTipoMercaderia(String tipoMercaderia) {
		this.tipoMercaderia = tipoMercaderia;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}

	public EmpresaSeguro getEmpresaSeguro() {
		return empresaSeguro;
	}

	public void setEmpresaSeguro(EmpresaSeguro empresaSeguro) {
		this.empresaSeguro = empresaSeguro;
	}
}
