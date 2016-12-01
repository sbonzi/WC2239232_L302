package srv;

import java.util.List;

import converters.EstadoEnvioConverter;
import dao.EstadoEnvioDAO;
import dto.EstadoEnvioDTO;
import entities.EstadoEnvio;

public class EstadoEnvioSRV {
	private static EstadoEnvioDAO dao;
	
	static{
		dao = EstadoEnvioDAO.getInstancia();
	}
	
	public static List<EstadoEnvioDTO> getEstadosEnvio(){
		List<EstadoEnvio> estados = dao.getEstadosEnvio();
		List<EstadoEnvioDTO> estadosDTO = EstadoEnvioConverter.estadosEnvioToDTO(estados);
		return estadosDTO;
	}
	
	public static EstadoEnvioDTO getEstadoEnvioById(int idEstadoEnvio){
		EstadoEnvio estado = dao.getEstadoEnvioById(idEstadoEnvio);
		EstadoEnvioDTO estadosDTO = EstadoEnvioConverter.estadoEnvioToDTO(estado);
		return estadosDTO;
	}
}
