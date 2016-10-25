package converters;

import java.io.Serializable;

import dto.RemitoDTO;
import entities.Remito;

public class RemitoConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2591366607538401440L;
	
	public static RemitoDTO remitoToDTO(Remito remito){
		RemitoDTO remitoDTO = new RemitoDTO(remito.getFecha(),
											ItemRemitoConverter.itemsRemitoToDTO(remito.getItemsRemito()),
											remito.getId());
		return remitoDTO;
	}

}
