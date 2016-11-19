package srv;

import java.util.List;

import converters.EmpresaSeguroConverter;
import dao.EmpresaSeguroDAO;
import dto.EmpresaSeguroDTO;
import entities.EmpresaSeguro;

public class EmpresaSeguroSRV {
	private static EmpresaSeguroDAO dao;
	
	static{
		dao = EmpresaSeguroDAO.getInstancia();
	}

	public static List<EmpresaSeguroDTO> getListadoAseguradoras() {
		List<EmpresaSeguro> empresas = dao.getListadoAseguradoras();
		return EmpresaSeguroConverter.empresasSeguroToDTO(empresas);
	}

}
