package dto;

import java.io.Serializable;

public class CargaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8690946803538716203L;
	private int id;
	private Float alto;
	private Float ancho;
	private boolean apilable;
	private CategoriaFragilidadDTO categFragilidad;
	private CategoriaTratamientoDTO categTratamiento;
	private boolean  esInflamable;
	private boolean esQuimicoToxico;
	private ManifiestoDTO  manifiesto;
	private int maximoApilable;
	private String notasManipulacion;
	private Float peso;
	private Float profundidad;
	private boolean refrigerado;
	private int tempRefrigerado;
	private String tipo;
	private Float volumen;
	private boolean cargaAGranel;
	
	public CargaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargaDTO(Float alto, Float ancho, boolean apilable, CategoriaFragilidadDTO categFragilidad,
			CategoriaTratamientoDTO categTratemiento, boolean esInflamable, boolean esQuimicoToxico,
			ManifiestoDTO manifiesto, int maximoApilable, String notasManipulacion, Float peso, Float profundidad,
			boolean refrigerado, int tempRefrigerado, String tipo, Float volumen) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.apilable = apilable;
		this.categFragilidad = categFragilidad;
		this.categTratamiento = categTratemiento;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public CategoriaFragilidadDTO getCategFragilidad() {
		return categFragilidad;
	}

	public void setCategFragilidad(CategoriaFragilidadDTO categFragilidad) {
		this.categFragilidad = categFragilidad;
	}

	public CategoriaTratamientoDTO getCategTratamiento() {
		return categTratamiento;
	}

	public void setCategTratamiento(CategoriaTratamientoDTO categTratamiento) {
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

	public ManifiestoDTO getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(ManifiestoDTO manifiesto) {
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

	@Override
	public String toString(){
		return "[tipo=" + tipo + "]";
	}
		
}
