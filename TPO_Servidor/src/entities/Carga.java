package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Carga")
public class Carga implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6675650182249859125L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private Float alto;
	private Float ancho;
	private boolean apilable;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_CategoriaFragilidad")
	private CategoriaFragilidad categFragilidad;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_CategoriaTratamiento")
	private CategoriaTratamiento categTratamiento;
	
	private boolean  esInflamable;
	private boolean esQuimicoToxico;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy="carga",cascade = CascadeType.ALL)
	@JoinColumn(name="id_Carga")
	private Manifiesto  manifiesto;
	
	private int maximoApilable;
	
	@Column(name="notaManipulacion")
	private String notasManipulacion;
	private Float peso;
	private Float profundidad;
	private boolean refrigerado;
	private int tempRefrigerado;
	private String tipo;
	private Float volumen;
	private boolean cargaAGranel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_envio")
	private Envio envio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_ItemFactura")
	private ItemFactura itemFactura;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_ItemRemito")
	private ItemRemito itemRemito;

	public Carga() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carga(Float alto, Float ancho, boolean apilable, CategoriaFragilidad categFragilidad,
			CategoriaTratamiento categTratamiento, boolean esInflamable, boolean esQuimicoToxico, Manifiesto manifiesto,
			int maximoApilable, String notasManipulacion, Float peso, Float profundidad, boolean refrigerado,
			int tempRefrigerado, String tipo, Float volumen) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.apilable = apilable;
		this.categFragilidad = categFragilidad;
		this.categTratamiento = categTratamiento;
		this.esInflamable = esInflamable;
		this.esQuimicoToxico = esQuimicoToxico;
		this.manifiesto = manifiesto;
		this.maximoApilable = maximoApilable;
		this.notasManipulacion = notasManipulacion;
		this.peso = peso;
		this.profundidad = profundidad;
		this.refrigerado = refrigerado;
		this.tempRefrigerado = tempRefrigerado;
		this.tipo = tipo;
		this.volumen = volumen;
	}



	public Float getAlto() {
		return alto;
	}

	public void setAlto(Float alto) {
		this.alto = alto;
	}

	public Float getAncho() {
		return ancho;
	}

	public void setAncho(Float ancho) {
		this.ancho = ancho;
	}

	public boolean isApilable() {
		return apilable;
	}

	public void setApilable(boolean apilable) {
		this.apilable = apilable;
	}

	public CategoriaFragilidad getCategFragilidad() {
		return categFragilidad;
	}

	public void setCategFragilidad(CategoriaFragilidad categFragilidad) {
		this.categFragilidad = categFragilidad;
	}

	public CategoriaTratamiento getCategTratamiento() {
		return categTratamiento;
	}

	public void setCategTratamiento(CategoriaTratamiento categTratamiento) {
		this.categTratamiento = categTratamiento;
	}

	public boolean isEsInflamable() {
		return esInflamable;
	}

	public void setEsInflamable(boolean esInflamable) {
		this.esInflamable = esInflamable;
	}

	public boolean isEsQuimicoToxico() {
		return esQuimicoToxico;
	}

	public void setEsQuimicoToxico(boolean esQuimicoToxico) {
		this.esQuimicoToxico = esQuimicoToxico;
	}

	public Manifiesto getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}

	public int getMaximoApilable() {
		return maximoApilable;
	}

	public void setMaximoApilable(int maximoApilable) {
		this.maximoApilable = maximoApilable;
	}

	public String getNotasManipulacion() {
		return notasManipulacion;
	}

	public void setNotasManipulacion(String notasManipulacion) {
		this.notasManipulacion = notasManipulacion;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Float profundidad) {
		this.profundidad = profundidad;
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	public int getTempRefrigerado() {
		return tempRefrigerado;
	}

	public void setTempRefrigerado(int tempRefrigerado) {
		this.tempRefrigerado = tempRefrigerado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getVolumen() {
		return volumen;
	}

	public void setVolumen(Float volumen) {
		this.volumen = volumen;
	}

	public boolean isCargaAGranel() {
		return cargaAGranel;
	}

	public void setCargaAGranel(boolean cargaAGranel) {
		this.cargaAGranel = cargaAGranel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Envio getEnvio() {
		return envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public ItemFactura getItemFactura() {
		return itemFactura;
	}

	public void setItemFactura(ItemFactura itemFactura) {
		this.itemFactura = itemFactura;
	}

	public ItemRemito getItemRemito() {
		return itemRemito;
	}

	public void setItemRemito(ItemRemito itemRemito) {
		this.itemRemito = itemRemito;
	}
}
