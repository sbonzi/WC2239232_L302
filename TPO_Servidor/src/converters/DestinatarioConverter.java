package converters;

import java.io.Serializable;

import dto.DestinatarioDTO;
import entities.Destinatario;

public class DestinatarioConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1741149267034523280L;

	public static DestinatarioDTO destinatarioToDTO(Destinatario d){
		DestinatarioDTO destinatarioDTO = new DestinatarioDTO(d.getNombre(),
															  d.getDomicilio(),
															  d.getCodigoPostal(),
															  PaisConverter.paisToDTO(d.getPais()),
															  ProvinciaConverter.provinciaToDTO(d.getProvincia()),
															  d.getPiso(),
															  d.getDepartamento(),
															  d.getNroDocumento(),
															  d.getPersonasAutorizadas(),
															  ClienteConverter.clienteToDTO(d.getClienteRemitente()));
		return destinatarioDTO;
	}
	
	public static Destinatario destinatarioToEntity(DestinatarioDTO destinatarioDTO) {
		Destinatario destinatario = new Destinatario(destinatarioDTO.getNombre(),
													 destinatarioDTO.getDomicilio(),
													 destinatarioDTO.getCodigoPostal(),
													 PaisConverter.paisToEntity(destinatarioDTO.getPais()),
													 ProvinciaConverter.provinciaToEntity(destinatarioDTO.getProvincia()),
													 destinatarioDTO.getPiso(),
													 destinatarioDTO.getDepartamento(),
													 destinatarioDTO.getNroDocumento(),
													 destinatarioDTO.getPersonasAutorizadas(),
													 ClienteConverter.clienteToEntity(destinatarioDTO.getClienteRemitente()));
		return destinatario;
	}
}
