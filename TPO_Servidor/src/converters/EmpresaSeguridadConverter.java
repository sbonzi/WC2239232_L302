package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.EmpresaSeguridadDTO;
import entities.EmpresaSeguridad;

public class EmpresaSeguridadConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6323569610164645604L;
	
	public static EmpresaSeguridadDTO empresaSeguridadToDTO(EmpresaSeguridad es){
		EmpresaSeguridadDTO eDTO = new EmpresaSeguridadDTO(es.getId(),
														   es.getNombre(),
														   es.getServicio(),
														   es.getTarifa());
		return eDTO;
	}
	
	public static List<EmpresaSeguridadDTO> empresasSeguridadToDTO(List<EmpresaSeguridad> empresas){
		List<EmpresaSeguridadDTO> listadoDTO = new ArrayList<EmpresaSeguridadDTO>();
		for(EmpresaSeguridad e:empresas){
			listadoDTO.add(empresaSeguridadToDTO(e));
		}
		return listadoDTO;
	}

}
