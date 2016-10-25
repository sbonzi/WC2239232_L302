package srv;

import converters.RemitoConverter;
import dao.RemitoDAO;
import dto.EnvioDTO;
import dto.RemitoDTO;
import entities.Remito;

public class RemitoSRV {
	public static RemitoDAO dao;
	
	static{
		dao = RemitoDAO.getInstancia();
	}
	
	public static RemitoDTO generarRemito(EnvioDTO envio){
		Remito remito = dao.generarRemito(envio);
		RemitoDTO remitoDTO = RemitoConverter.remitoToDTO(remito);
		return remitoDTO;
	}
}
