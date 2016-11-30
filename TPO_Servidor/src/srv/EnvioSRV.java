package srv;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import converters.CargaConverter;
import converters.EnvioConverter;
import dao.EnvioDAO;
import dto.CargaDTO;
import dto.ClienteDTO;
import dto.DestinatarioDTO;
import dto.EnvioDTO;
import dto.EstadoEnvioDTO;
import dto.SucursalDTO;
import entities.Carga;
import entities.Envio;
import exceptions.ClienteException;
import exceptions.EnvioException;

public class EnvioSRV {
	private static EnvioDAO dao;
	static{
		dao = EnvioDAO.getInstancia();
	}
	
	public static EnvioDTO gestionarEnvio(ClienteDTO cliente, List<CargaDTO> cargas, DestinatarioDTO destinatario, SucursalDTO sOrigen,SucursalDTO sDestino){
		EnvioDTO envioDTO =  null;
		Envio envio = dao.gestionarEnvio(cliente, cargas, destinatario, sOrigen,sDestino);
		
		envioDTO = EnvioConverter.envioToDTO(envio);
		return envioDTO;
	}
	
	
	public static List<EnvioDTO> obtenerEnviosPorCliente(ClienteDTO cliente){
		List<EnvioDTO> enviosDTO = new ArrayList<EnvioDTO>();
		List<Envio> envios = dao.obtenerEnviosPorCliente(cliente);
		for(int i = 0; i<= envios.size(); i++)
		{
			enviosDTO.add(EnvioConverter.envioToDTO(envios.get(i)));
		}
		
		return enviosDTO;
	}
	
	public static List<EnvioDTO> obtenerEnviosPorSucursalOrigen(SucursalDTO sucOrigen){
		List<EnvioDTO> enviosDTO = new ArrayList<EnvioDTO>();
		List<Envio> envios = dao.obtenerEnviosPorSucursalOrigen(sucOrigen);
		for(int i = 0; i<= envios.size(); i++)
		{
			enviosDTO.add(EnvioConverter.envioToDTO(envios.get(i)));
		}
		
		return enviosDTO;
	}
	
	public static List<EnvioDTO> obtenerEnviosPorCliente(SucursalDTO sucDestino, int estado){
		List<EnvioDTO> enviosDTO = new ArrayList<EnvioDTO>();
		List<Envio> envios = dao.obtenerEnviosPorSucursalDestinoEstado(sucDestino, estado);
		for(int i = 0; i<= envios.size(); i++)
		{
			enviosDTO.add(EnvioConverter.envioToDTO(envios.get(i)));
		}
		
		return enviosDTO;
	}
	
	public static List<CargaDTO> obtenerCargasPorEnvio(EnvioDTO envio){
		List<CargaDTO> cargasDTO = new ArrayList<CargaDTO>();
		List<Carga> cargas = dao.obtenerCargasPorEnvio(envio);
		for(int i = 0; i<= cargas.size(); i++)
		{
			cargasDTO.add(CargaConverter.cargaToDTO(cargas.get(i)));
		}
		
		return cargasDTO;
	}


	public static List<EnvioDTO> getEnviosPorSucursalOrigen(SucursalDTO sucOrigen) {
		List<EnvioDTO> enviosDTO = new ArrayList<EnvioDTO>();
		List<Envio> envios = dao.obtenerEnviosPorSucursalOrigen(sucOrigen);
		for(Envio e: envios)
			enviosDTO.add(EnvioConverter.envioToDTO(e));
		
		return enviosDTO;
	}


	public static List<EnvioDTO> getEnviosPorSucursalDestinoEstado(SucursalDTO sucDestino, int estado) {
		List<EnvioDTO> enviosDTO = new ArrayList<EnvioDTO>();
		List<Envio> envios = dao.obtenerEnviosPorSucursalDestinoEstado(sucDestino, estado);
		for(int i = 0; i<= envios.size(); i++)
		{
			enviosDTO.add(EnvioConverter.envioToDTO(envios.get(i)));
		}
		
		return enviosDTO;
	}
}
