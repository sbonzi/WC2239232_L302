package converters;

import java.io.Serializable;

import dto.ClienteDTO;
import dto.EmpresaDTO;
import dto.ParticularDTO;
import entities.Cliente;
import entities.ClienteEmpresa;
import entities.ClienteParticular;

public class ClienteConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6735833312007491173L;
	
	public static ClienteDTO clienteToDTO(Cliente c){
		ClienteDTO cliente;
		if(c.getEsParticular()){
			cliente = (ClienteDTO)new ParticularDTO(c.getDomicilio(),c.getNombre());
		}else{
			cliente = (ClienteDTO)new EmpresaDTO();
		}
		return cliente;
	}

	public static Cliente clienteToEntity(ClienteDTO c) {
		Cliente cliente;
		if(c.getEsParticular()){
			cliente = (Cliente)ParticularConverter.particularToEntity((ParticularDTO)c);
		}else{
			cliente = (Cliente)new ClienteEmpresa();
		}
		return cliente;
	}

}
