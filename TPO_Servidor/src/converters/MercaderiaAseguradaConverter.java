package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.MercaderiaAseguradaDTO;
import entities.MercaderiaAsegurada;

public class MercaderiaAseguradaConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 718878077743379506L;

	public static MercaderiaAseguradaDTO mercaderiaAseguradaToDTO(MercaderiaAsegurada m){
		MercaderiaAseguradaDTO mDTO = new MercaderiaAseguradaDTO(m.getId(),
																 m.getTipoMercaderia(),
																 m.getTarifa());
		return mDTO;
	}
	
	public static List<MercaderiaAseguradaDTO> mercaderiasToDTO(List<MercaderiaAsegurada> mercaderias){
		List<MercaderiaAseguradaDTO> mercaderiasDTO = new ArrayList<MercaderiaAseguradaDTO>();
		for(MercaderiaAsegurada m:mercaderias){
			mercaderiasDTO.add(mercaderiaAseguradaToDTO(m));
		}
		return mercaderiasDTO;
	}
}
