package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.CargaDTO;
import entities.Carga;

public class CargaConverter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2021921939853493216L;
	
	

	public static CargaDTO cargaToDTO(Carga carga){
		CargaDTO cDTO = new CargaDTO(carga.getAlto(),
								  carga.getAncho(),
								  carga.isApilable(),
								  null/*CategoriaFragilidadConverter.categoriaFragilidadToDTO(carga.getCategFragilidad())*/,
								  null/*CategoriaTratamientoConverter.categoriaTratamientoToDTO(carga.getCategTratamiento())*/,
								  carga.isEsInflamable(),
								  carga.isEsQuimicoToxico(),
								  ManifiestoConverter.manifiestoToDTO(carga.getManifiesto()),
								  carga.getMaximoApilable(),
								  carga.getNotasManipulacion(),
								  carga.getPeso(),
								  carga.getProfundidad(),
								  carga.isRefrigerado(),
								  carga.getTempRefrigerado(),
								  carga.getTipo(),
								  carga.getVolumen(),
								  carga.isCargaAGranel());
		
		cDTO.setId(carga.getId());
		
		return cDTO;			
	}
	
	public static List<CargaDTO> cargasToDTO(List<Carga> cargas){
		List<CargaDTO> lista = new ArrayList<CargaDTO>();
		
		CargaDTO cargaDTO;

		for(Carga c:cargas){
			cargaDTO = new CargaDTO(c.getAlto(),
									c.getAncho(),
									c.isApilable(),
									null/*CategoriaFragilidadConverter.categoriaFragilidadToDTO(c.getCategFragilidad())*/,
									null/*CategoriaTratamientoConverter.categoriaTratamientoToDTO(c.getCategTratamiento())*/,
									c.isEsInflamable(),
									c.isEsQuimicoToxico(),
									ManifiestoConverter.manifiestoToDTO(c.getManifiesto()),
									c.getMaximoApilable(),
									c.getNotasManipulacion(),
									c.getPeso(),
									c.getProfundidad(),
									c.isRefrigerado(),
									c.getTempRefrigerado(),
									c.getTipo(),
									c.getVolumen(),
									c.isCargaAGranel());
			cargaDTO.setId(c.getId());
			lista.add(cargaDTO);
		}
		
		return lista;			
	}

	public static List<Carga> cargasToEntity(List<CargaDTO> cargas){
		List<Carga> lista = new ArrayList<Carga>();
		Carga cEntity;
		
		for(CargaDTO c:cargas){
			cEntity = new Carga(c.getAlto(),
								c.getAncho(),
								c.isApilable(),
						  		null/*CategoriaFragilidadConverter.categoriaFragilidadToEntity(c.getCategFragilidad())*/,
						  		null/*CategoriaTratamientoConverter.categoriaTratamientoToEntity(c.getCategTratamiento())*/,
						  		c.isEsInflamable(),
						  		c.isEsQuimicoToxico(),
						  		ManifiestoConverter.manifiestoToEntity(c.getManifiesto()),
						  		c.getMaximoApilable(),
						  		c.getNotasManipulacion(),
						  		c.getPeso(),
						  		c.getProfundidad(),
						  		c.isRefrigerado(),
						  		c.getTempRefrigerado(),
						  		c.getTipo(),
						  		c.getVolumen());
			
			cEntity.setId(c.getId());
			
			lista.add(cEntity);
		}
		return lista;			
	}
	
}
