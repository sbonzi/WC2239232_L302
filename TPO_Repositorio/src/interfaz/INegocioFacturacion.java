package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ClienteDTO;
import dto.EnvioDTO;
import dto.FacturaDTO;
import dto.RemitoDTO;
import exceptions.ClienteException;
import exceptions.EnvioException;
import exceptions.FacturaException;
import exceptions.RemitoException;

public interface INegocioFacturacion extends Remote {
	
	/**
	 * Gestiona el alta de una factura para un envio
	 */
	FacturaDTO generarFactura(EnvioDTO envio) 
	throws EnvioException,FacturaException,RemoteException;
	
	/**
	 * Devuelve todas las facturas asociadas a un cliente
	 */
	List<FacturaDTO> obtenerFacturasPorCliente(ClienteDTO cliente) 
	throws ClienteException,FacturaException,RemoteException;
	
	/**
	 * Devuelve ultima factura generada para un cliente
	 */
	FacturaDTO obtenerUltimaFactura(ClienteDTO cliente)
	throws ClienteException,FacturaException,RemoteException;
	
	/**
	 * Gestiona el alta de un remito para un envio
	 */
	RemitoDTO generarRemito(EnvioDTO envio)
	throws EnvioException,RemitoException,RemoteException;
	
	/**
	 * Devuelve todos los remitos asocios a un cliente
	 */
	List<RemitoDTO> obtenerRemitosPorCliente(ClienteDTO cliente)
	throws ClienteException,RemitoException,RemoteException;
	
	/**
	 * Devuelve ultimo remito generado para un cliente
	 */
	RemitoDTO obtenerUltimoRemito(ClienteDTO cliente)
	throws ClienteException,RemitoException,RemoteException;

}
