package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.FacturaDTO;
import entities.Factura;

public class FacturaConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2139028722371857830L;
	
	public static FacturaDTO facturaToDTO(Factura factura){
		FacturaDTO facturaDTO = new FacturaDTO(factura.getFecha(),
											   ItemFacturaConverter.itemsFacturaToDTO(factura.getItemsFactura()),
											   factura.getId());
		return facturaDTO;
	}

	public static List<FacturaDTO> facturasToDTO(List<Factura> facturas) {
		List<FacturaDTO> facturasDTO = new ArrayList<FacturaDTO>();
		for(Factura f:facturas){
			FacturaDTO facturaDTO = FacturaConverter.facturaToDTO(f);
			facturasDTO.add(facturaDTO);
		}
		return facturasDTO;
	}

}
