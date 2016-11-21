package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.CargaDTO;
import dto.ClienteDTO;
import dto.DestinatarioDTO;
import dto.EnvioDTO;
import dto.SucursalDTO;
import exceptions.CargaException;
import exceptions.ClienteException;
import exceptions.EnvioException;

public interface INegocioEnvio extends Remote {
	
	/**
	 * Gestión de envio de N cargas para un cliente en particular
	 */
	EnvioDTO gestionarEnvio(ClienteDTO cliente,List<CargaDTO> cargas, DestinatarioDTO destinatario,SucursalDTO sOrigen,SucursalDTO sDestino) throws ClienteException,CargaException,RemoteException;

	/**
	 * Devuelte todos los envios gestionados por un cliente
	 */
	List<EnvioDTO> obtenerEnviosPorCliente(ClienteDTO cliente) throws ClienteException, RemoteException;
	
	/**
	 * Devuelve las cargas asociadas a un envio
	 */
	List<CargaDTO> obtenerCargasPorEnvio(EnvioDTO envio) throws EnvioException,RemoteException;
}
