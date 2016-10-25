package srv;

import converters.FacturaConverter;
import dao.FacturaDAO;
import dto.EnvioDTO;
import dto.FacturaDTO;
import entities.Factura;

public class FacturaSRV {
	public static FacturaDAO dao;
	
	static{
		dao = FacturaDAO.getInstancia();
	}
	
	public static FacturaDTO generarFactura(EnvioDTO envio){
		Factura factura = dao.generarFactura(envio);
		FacturaDTO facturaDTO = FacturaConverter.facturaToDTO(factura);
		return facturaDTO;
	}	

}