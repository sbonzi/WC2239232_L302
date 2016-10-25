package entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="MovimientoEmpresa")
public class MovimientoEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2580613498509283348L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private Date fecha;
	private float monto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_CuentaCorrienteEmpresa")
	private CuentaCorrienteEmpresa ctaCteEmpresa;

	public MovimientoEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovimientoEmpresa(Date fecha, float monto, CuentaCorrienteEmpresa ctaCteEmpresa) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.ctaCteEmpresa = ctaCteEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public CuentaCorrienteEmpresa getCtaCteEmpresa() {
		return ctaCteEmpresa;
	}

	public void setCtaCteEmpresa(CuentaCorrienteEmpresa ctaCteEmpresa) {
		this.ctaCteEmpresa = ctaCteEmpresa;
	}
}
