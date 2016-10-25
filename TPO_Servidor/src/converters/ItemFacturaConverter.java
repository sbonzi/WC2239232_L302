package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.ItemFacturaDTO;
import entities.ItemFactura;

public class ItemFacturaConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5444375597797916599L;
	
	public static ItemFacturaDTO itemFacturaToDTO(ItemFactura itemFactura){
		ItemFacturaDTO itemFacturaDTO = new ItemFacturaDTO(CargaConverter.cargaToDTO(itemFactura.getCarga()));
		return itemFacturaDTO;
	}
	
	public static List<ItemFacturaDTO> itemsFacturaToDTO(List<ItemFactura> itemsFactura){
		List<ItemFacturaDTO> itemsFacturaDTO = new ArrayList<ItemFacturaDTO>();
		for(ItemFactura i:itemsFactura){
			itemsFacturaDTO.add(itemFacturaToDTO(i));
		}
		return itemsFacturaDTO;
	}

}
