package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="EmpresaSeguro")
public class EmpresaSeguro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5021480321441241390L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String tipoSeguro;
	private boolean habilitado;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="empresaSeguro",cascade = CascadeType.ALL)
	@JoinColumn(name="id_EmpresaSeguro")
	List<MercaderiaAsegurada> mercaderiasAseguradas;

	public EmpresaSeguro() {
		super();
	}

	public EmpresaSeguro(String nombre, String tipoSeguro, boolean habilitado,
			List<MercaderiaAsegurada> mercaderiasAseguradas) {
		super();
		this.nombre = nombre;
		this.tipoSeguro = tipoSeguro;
		this.habilitado = habilitado;
		this.mercaderiasAseguradas = mercaderiasAseguradas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<MercaderiaAsegurada> getMercaderiasAseguradas() {
		return mercaderiasAseguradas;
	}

	public void setMercaderiasAseguradas(List<MercaderiaAsegurada> mercaderiasAseguradas) {
		this.mercaderiasAseguradas = mercaderiasAseguradas;
	}

}
