package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.EmpresaSeguroDTO;
import entities.EmpresaSeguro;

public class EmpresaSeguroConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2681724529268082429L;
	
	public static EmpresaSeguroDTO empresaSeguroToDTO(EmpresaSeguro e){
		EmpresaSeguroDTO empresaDTO = new EmpresaSeguroDTO(e.getId(),
														   e.getNombre(),
														   e.getTipoSeguro(),
														   e.isHabilitado(),
														   MercaderiaAseguradaConverter.mercaderiasToDTO(e.getMercaderiasAseguradas()));
		return empresaDTO;
	}
	
	public static List<EmpresaSeguroDTO> empresasSeguroToDTO(List<EmpresaSeguro> empresas){
		List<EmpresaSeguroDTO> empresasDTO = new ArrayList<EmpresaSeguroDTO>();
		for(EmpresaSeguro e:empresas){
			empresasDTO.add(empresaSeguroToDTO(e));
		}
		return empresasDTO;
	}

}
