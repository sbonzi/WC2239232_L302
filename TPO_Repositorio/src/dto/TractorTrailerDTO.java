package dto;

import java.io.Serializable;
import java.util.List;

public abstract class TractorTrailerDTO extends VehiculoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8019920938822779858L;

	public TractorTrailerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TractorTrailerDTO(int anio, boolean habilitadoParaUtilizar, int kilometraje,
			List<MantenimientoDTO> mantenimientos, String marca, String modelo, String patente, Float peso, Float tara) {
		super(anio, habilitadoParaUtilizar, kilometraje, mantenimientos, marca, modelo, patente, peso, tara);
		// TODO Auto-generated constructor stub
	}

}
