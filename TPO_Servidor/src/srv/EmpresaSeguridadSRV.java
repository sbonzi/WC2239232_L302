package srv;

import java.util.List;

import converters.EmpresaSeguridadConverter;
import dao.EmpresaSeguridadDAO;
import dto.EmpresaSeguridadDTO;

public class EmpresaSeguridadSRV {
	private static EmpresaSeguridadDAO dao;
	
	static{
		dao = EmpresaSeguridadDAO.getInstancia();
	}

	public static List<EmpresaSeguridadDTO> getListadoEmpresasSeguridad() {
		return EmpresaSeguridadConverter.empresasSeguridadToDTO(dao.getEmpresasSeguridad());
	}

	public static EmpresaSeguridadDTO actualizarEmpresaSeguridad(EmpresaSeguridadDTO st) {
		return EmpresaSeguridadConverter.empresaSeguridadToDTO(dao.actualizarEmpresaSeguridad(st));
	}
}
