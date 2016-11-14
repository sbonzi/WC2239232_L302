package negocio;


public class Particular{

	private int numDoc;
	private char tipoDoc;
	private String nombre;
	private String domicilio;

	public Particular() {}
	
	public Particular(char tipoDoc, int numDoc, String domicilio, String nombre) {
	
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.domicilio = domicilio;
		this.nombre = nombre;
	}
	
	public int getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}

	public char getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(char tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

}
