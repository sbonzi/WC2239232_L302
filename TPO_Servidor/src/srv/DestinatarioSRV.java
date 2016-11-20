package srv;

import converters.DestinatarioConverter;
import dao.DestinatarioDAO;
import dto.DestinatarioDTO;
import entities.Destinatario;

public class DestinatarioSRV {
	private static DestinatarioDAO dao;
	
	static{
		dao = DestinatarioDAO.getInstancia();
	}

	public static DestinatarioDTO crearDestinatario(DestinatarioDTO d) {
		Destinatario destinatario = dao.crearDestinatario(d);
		DestinatarioDTO destinatarioDTO = DestinatarioConverter.destinatarioToDTO(destinatario);
		return destinatarioDTO;
	}
}
