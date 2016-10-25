package dto;

import java.io.Serializable;
import java.util.List;

public class TractorTrailerCompuestoDTO extends TractorTrailerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1178047339467405458L;

	public TractorTrailerCompuestoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TractorTrailerCompuestoDTO(int anio, boolean habilitadoParaUtilizar, int kilometraje,
			List<MantenimientoDTO> mantenimientos, String marca, String modelo, String patente, Float peso, Float tara) {
		super(anio, habilitadoParaUtilizar, kilometraje, mantenimientos, marca, modelo, patente, peso, tara);
		// TODO Auto-generated constructor stub
	}

}
