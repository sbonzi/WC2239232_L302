package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.ItemRemitoDTO;
import entities.ItemRemito;

public class ItemRemitoConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6603573328053220056L;
	
	public static ItemRemitoDTO itemRemitoToDTO(ItemRemito itemRemito){
		ItemRemitoDTO itemRemitoDTO = new ItemRemitoDTO(CargaConverter.cargaToDTO(itemRemito.getCarga()));
		return itemRemitoDTO;
	}
	
	public static List<ItemRemitoDTO> itemsRemitoToDTO(List<ItemRemito> itemsRemito){
		List<ItemRemitoDTO> itemsRemitoDTO = new ArrayList<ItemRemitoDTO>();
		for(ItemRemito i:itemsRemito){
			itemsRemitoDTO.add(itemRemitoToDTO(i));
		}
		return itemsRemitoDTO;
	}

}
