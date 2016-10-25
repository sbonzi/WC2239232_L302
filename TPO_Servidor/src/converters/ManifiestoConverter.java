package converters;

import java.io.Serializable;

import dto.ManifiestoDTO;
import entities.Manifiesto;

public class ManifiestoConverter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 452529319813234474L;

	public static ManifiestoDTO manifiestoToDTO(Manifiesto m){
		ManifiestoDTO mDTO = new ManifiestoDTO(m.getDeclaracion());
		return mDTO;
	}
	
	public static Manifiesto manifiestoToEntity(ManifiestoDTO m){
		Manifiesto mEntity = new Manifiesto(m.getDeclaracion());
		return mEntity;
	}

}
