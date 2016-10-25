package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("p") 
public class ClienteParticular extends Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -834345965873958092L;
	
	@Column(name="nroDoc")
	private int numDoc;
	private char tipoDoc;
	
	public ClienteParticular() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteParticular(int numDoc, char tipoDoc) {
		super();
		this.numDoc = numDoc;
		this.tipoDoc = tipoDoc;
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
}
