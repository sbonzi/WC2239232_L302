package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.EnvioDTO;
import dto.EnvioEmpresaDTO;
import dto.EnvioParticularDTO;
import dto.SucursalDTO;
import entities.Envio;

public class EnvioConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9051915256403069972L;
	
	public static EnvioDTO envioToDTO(Envio e){
		EnvioDTO envioDTO;
		
		SucursalDTO sucDestino = null;
		if(e.getSucursalDestino() != null)
			sucDestino = SucursalConverter.sucursalToDTO(e.getSucursalDestino());
		
		if(e.isEsClienteEmpresa()){
			
			
			
			envioDTO = new EnvioEmpresaDTO(e.getIdEnvio(),
					 					   CargaConverter.cargasToDTO(e.getCargas()),
										   ClienteConverter.clienteToDTO(e.getCliente()),
										   e.getCobro(),
										   e.isCobroOrigen(),
										   EstadoEnvioConverter.estadoEnvioToDTO(e.getEstadoEnvio()),
										   e.getFechaMaxLlegada(),
										   e.isRetiroEnSucursal(),
										   sucDestino,
										   SucursalConverter.sucursalToDTO(e.getSucursalOrigen()),
										   e.isTercerizarEnvio(),
										   e.isTrajoCargaEnPersona(),
										   DestinatarioConverter.destinatarioToDTO(e.getDestinatario()));
		}else{
			envioDTO = new EnvioParticularDTO(e.getIdEnvio(),
											   CargaConverter.cargasToDTO(e.getCargas()),
											   ClienteConverter.clienteToDTO(e.getCliente()),
											   e.getCobro(),
											   e.isCobroOrigen(),
											   EstadoEnvioConverter.estadoEnvioToDTO(e.getEstadoEnvio()),
											   e.getFechaMaxLlegada(),
											   e.isRetiroEnSucursal(),
											   sucDestino,
											   SucursalConverter.sucursalToDTO(e.getSucursalOrigen()),
											   e.isTercerizarEnvio(),
											   e.isTrajoCargaEnPersona(),
											   DestinatarioConverter.destinatarioToDTO(e.getDestinatario()));
		}
		return envioDTO;
	}

	public static List<EnvioDTO> enviosToDTO(List<Envio> envios) {
		List<EnvioDTO> enviosDTO = new ArrayList<EnvioDTO>();
		for(Envio e:envios){
			EnvioDTO envioDTO = EnvioConverter.envioToDTO(e);
			enviosDTO.add(envioDTO);
		}
		return enviosDTO;
	}
	
	public static Envio envioToEntity(EnvioDTO envioDTO){
		Envio envio = new Envio(ClienteConverter.clienteToEntity(envioDTO.getCliente()),
								envioDTO.getCobro(),
								envioDTO.isCobroOrigen(),
								envioDTO.getFechaMaxLlegada(),
								envioDTO.isRetiroEnSucursal(),
								SucursalConverter.sucursalToEntity(envioDTO.getSucursalDestino()),
								SucursalConverter.sucursalToEntity(envioDTO.getSucursalOrigen()),
								envioDTO.isTercerizarEnvio(),
								envioDTO.isTrajoCajaEnPersona(),
								EstadoEnvioConverter.estadoEnvioToEntity(envioDTO.getEstado()),
								envioDTO.isEsClienteEmpresa(),
								DestinatarioConverter.destinatarioToEntity(envioDTO.getDestinatario()));
		
			envio.setIdEnvio(envioDTO.getIdEnvio());
		return envio;
	}

	public static List<Envio> enviosToEntity(List<EnvioDTO> enviosDTO) {
		List<Envio> envios = new ArrayList<Envio>();
		
		for(EnvioDTO e:enviosDTO){
			Envio envio = EnvioConverter.envioToEntity(e);
			envios.add(envio);
		}
		
		return envios;
	}
}
