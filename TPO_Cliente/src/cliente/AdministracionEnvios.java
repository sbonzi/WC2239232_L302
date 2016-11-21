package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.CargaDTO;
import dto.CategoriaFragilidadDTO;
import dto.CategoriaTratamientoDTO;
import dto.ClienteDTO;
import dto.DestinatarioDTO;
import dto.EmpleadoDTO;
import dto.EnvioDTO;
import dto.ManifiestoDTO;
import dto.PaisDTO;
import dto.ParticularDTO;
import dto.ProvinciaDTO;
import dto.SucursalDTO;
import exceptions.CargaException;
import exceptions.ClienteException;
import exceptions.DestinatarioException;
import exceptions.PaisException;
import interfaz.INegocioEnvio;

public class AdministracionEnvios {
	INegocioEnvio controladorEnvios;
	
	public static void main(String[] args){
		new AdministracionEnvios();
	}
	
	public AdministracionEnvios() {
		try{
			
			
			ClienteDTO cliente 	= new ParticularDTO();
			cliente.setId(2);
			
			PaisDTO pais 	= new PaisDTO();
			pais.setId(1);
			pais.setDescripcion("ARGENTINA");
			pais.setHabilitado(true);
			
			
			ProvinciaDTO provincia 	= new ProvinciaDTO();
			provincia.setId(1);
			provincia.setDescripcion("BUENOS AIRES");
			provincia.setHabilitado(true);
			provincia.setPais(pais);
			
			 DestinatarioDTO nDetinatario = new DestinatarioDTO("CHAVO",
						"SAN JUAN 456",
		    			"1234",
		    			pais,
		    			provincia,
		    			2,
		    			"1",
		    			33456789,
		    			"NADIE",
		    			cliente);


			 nDetinatario = new BusinessDelegate().getBusinessService().crearDestinatario(nDetinatario);
			
			//En la BD cargar a mano(Despues hay que hacer el AMB)
			//Valores cargados en BD
			//De la BD, tomamos el cliente que está gestionando el envio de cargas
			/*ClienteDTO cliente 	= new ParticularDTO();
			cliente.setNombre("Jose Lopez");
			cliente.setDomicilio("Rivadavia 500");
			cliente.setEsParticular(true);
			cliente.setId(1);*/
			
			//Cargas dadas de alta en la pantalla para el cliente
			List<CargaDTO> cargas = new ArrayList<CargaDTO>();
			for(int j = 0;j<5;j++){
				CargaDTO carga = new CargaDTO();
				
				//Valores cargados en BD
				CategoriaFragilidadDTO cf = new CategoriaFragilidadDTO();
				cf.setDescripcion("Nivel 1");
				cf.setId(1);
				
				//Valores cargados en BD
				CategoriaTratamientoDTO ct = new CategoriaTratamientoDTO();
				ct.setDescripcion("Normal");
				ct.setId(1);
				
				ManifiestoDTO manifiesto = new ManifiestoDTO();
				manifiesto.setDeclaracion("Sin detalles");
				
				carga.setCategFragilidad(cf);
				carga.setCategTratamiento(ct);
				carga.setManifiesto(manifiesto);
				carga.setAlto((float)10.3);
				carga.setAncho((float)10.3);
				carga.setNotasManipulacion("Ok");
				carga.setPeso((float)10.3);
				carga.setApilable(true);
				carga.setEsInflamable(false);
				carga.setEsQuimicoToxico(false);
				carga.setMaximoApilable(10);
				carga.setProfundidad((float)10.3);
				carga.setTipo("Indum " + j); //Datos dummy
				carga.setVolumen((float)10.3);
				carga.setCargaAGranel(false);
				cargas.add(carga);
			}
			
			//Idem cliente, se cargan 2 sucursales 
			//Valores cargados en BD
			SucursalDTO sOrigen	= new SucursalDTO();
			sOrigen.setNombre("Suc1");
			sOrigen.setNumero(1);
			
			//Cargamos empleado para la suc (se tiene que hacer despues desde la BD)
			EmpleadoDTO emple1 = new EmpleadoDTO();
			emple1.setNombre("Lucas");
			emple1.setCuit("123456");
			List<EmpleadoDTO> empleadosSucOrigen = new ArrayList<EmpleadoDTO>();
			empleadosSucOrigen.add(emple1);
			//sOrigen.setEmpleados(empleadosSucOrigen);
			
			SucursalDTO sDestino = new SucursalDTO();
			sDestino.setNombre("Suc2");
			sDestino.setNumero(2);
			
			EmpleadoDTO emple2 = new EmpleadoDTO();
			emple2.setNombre("Juan");
			emple2.setCuit("123456");
			List<EmpleadoDTO> empleadosSucDestino = new ArrayList<EmpleadoDTO>();
			empleadosSucDestino.add(emple2);
			//sOrigen.setEmpleados(empleadosSucDestino);

			//Envio asociando un cliente con sus cargas
			EnvioDTO envio = new BusinessDelegate().getBusinessService().gestionarEnvio(cliente, cargas, new DestinatarioDTO(), sOrigen, sDestino);

			//Cliente y cargas realizadas en la BD
			System.out.println("EnvioDTO: " + envio);
			
			//Se llama al servicio RMI que crea la facturación para el envio
			new AdministracionFacturacion(envio);
			
		}catch(RemoteException | ClienteException | CargaException e){
			e.printStackTrace();
		} catch (DestinatarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
