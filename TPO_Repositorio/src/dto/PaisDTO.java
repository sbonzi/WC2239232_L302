package dto;

import java.io.Serializable;
import java.util.List;

public class PaisDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4101834234552549735L;
	
	private String descripcion;
	private boolean habilitado;
	private List<ProvinciaDTO> provincias;
	
	public PaisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaisDTO(String descripcion, boolean habilitado, List<ProvinciaDTO> provincias) {
		super();
		this.descripcion = descripcion;
		this.habilitado = habilitado;
		this.provincias = provincias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<ProvinciaDTO> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<ProvinciaDTO> provincias) {
		this.provincias = provincias;
	}

}
