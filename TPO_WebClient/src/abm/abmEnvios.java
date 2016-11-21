package abm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.txw2.Document;

import businessDelegate.BusinessDelegate;
import config.viewStateAbmEnvios;
import dto.ParticularDTO;
import dto.ProvinciaDTO;
import dto.CargaDTO;
import dto.CategoriaFragilidadDTO;
import dto.CategoriaTratamientoDTO;
import dto.ClienteDTO;
import dto.DestinatarioDTO;
import dto.ManifiestoDTO;
import dto.PaisDTO;
import exceptions.DestinatarioException;
import exceptions.PaisException;
import exceptions.ParticularException;
import exceptions.ProvinciaException;

public class abmEnvios extends HttpServlet {

	private static final long serialVersionUID = -7930123587008023709L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 HttpSession misession = request.getSession(true);
		
		 String action = request.getParameter("action");
         String jspPage = "/abmEnvios.jsp";
         

         if ((action == null) || (action.length() < 1))
         {
             action = "default";
         }

         if ("default".equals(action))
         {
        	 viewStateAbmEnvios viewState = new viewStateAbmEnvios("none",	 //divParticular
																	"",  //divSeleccionCliente
																	"",  //ctlSearchCliente
																"none",  //ctlNewCliente
																"none",  //divBuscarClienteParticular
																	"",  //divNuevoClienteParticular
																"none",  //ctlClienteEnvio
																"none",  //divCargasParticular
																"none",  //ctlCargas
																"none",  //divDestinatario
																"none",  //ctlDestinatarioEnvio
																"none", //divGuardar
																"none", //errorDisplay
 					""); //error
        	 request.setAttribute("viewState", viewState);
             jspPage = "/abmEnvios.jsp";
             dispatch(jspPage, request, response);
         }
         else if ("searchClienteParticularById".equals(action))
         {
        	ParticularDTO nParticular;
        	viewStateAbmEnvios viewState;
        	
        	if (request.getParameter("txtDNI")==null || request.getParameter("txtDNI").length() < 1)
        	{
        		 request.setAttribute("clienteById", null);
		        	viewState = new viewStateAbmEnvios("",	 //divParticular
		        			 											"none",  //divSeleccionCliente
		        			 											"",  //ctlSearchCliente
		        			 											"none",  //ctlNewCliente
		        			 											"none",  //divBuscarClienteParticular
		        			 											"",  //divNuevoClienteParticular
		        			 											"none",  //ctlClienteEnvio
		        			 											"none",  //divCargasParticular
		        			 											"none",  //ctlCargas
		        			 											"none",  //divDestinatario
		        			 											"none",  //ctlDestinatarioEnvio
		        			 											"none", //divGuardar
		        			 											"", //errorDisplay
		 					"DEBE INDICAR EL NUMERO DE DOCUMENTO A BUSCAR."); //error
        	}
        	else
        	{
        		try {
					nParticular = new BusinessDelegate().getBusinessService().getClienteParticular(Integer.parseInt(request.getParameter("txtDNI").toString()),'D');
					if(nParticular != null)
					{
					request.setAttribute("clienteById", nParticular);
					misession.setAttribute("clienteById",nParticular);
		        	viewState = new viewStateAbmEnvios("",	 //divParticular
		        			 											"none",  //divSeleccionCliente
		        			 											"none",  //ctlSearchCliente
		        			 											"none",  //ctlNewCliente
		        			 											"none",  //divBuscarClienteParticular
		        			 											"none",  //divNuevoClienteParticular
		        			 											"",  //ctlClienteEnvio
		        			 											"",  //divCargasParticular
		        			 											"none",  //ctlCargas
		        			 											"none",  //divDestinatario
		        			 											"none",  //ctlDestinatarioEnvio
		        			 											"none", //divGuardar
		        			 											"none", //errorDisplay
		 					""); //error
					}
					else
					{
						request.setAttribute("clienteById", null);
			        	viewState = new viewStateAbmEnvios("",	 //divParticular
			        			 											"none",  //divSeleccionCliente
			        			 											"",  //ctlSearchCliente
			        			 											"none",  //ctlNewCliente
			        			 											"none",  //divBuscarClienteParticular
			        			 											"",  //divNuevoClienteParticular
			        			 											"none",  //ctlClienteEnvio
			        			 											"none",  //divCargasParticular
			        			 											"none",  //ctlCargas
			        			 											"none",  //divDestinatario
			        			 											"none",  //ctlDestinatarioEnvio
			        			 											"none", //divGuardar
			        			 											"", //errorDisplay
			 					"NO SE HA ENCONTRADO NINGUN CLIENTE CON EL TIPO y NRO DOCUMENTO INDICADO"); //error
					}	
				} 
				catch (ParticularException e) {
					viewState = new viewStateAbmEnvios("",	 //divParticular
								"none",  //divSeleccionCliente
								"",  //ctlSearchCliente
								"none",  //ctlNewCliente
								"none",  //divBuscarClienteParticular
								"",  //divNuevoClienteParticular
								"none",  //ctlClienteEnvio
								"none",  //divCargasParticular
								"none",  //ctlCargas
								"none",  //divDestinatario
								"none",  //ctlDestinatarioEnvio
								"none", //divGuardar
								"", //errorDisplay
							"ERROR AL BUSCAR EL CLIENTE"); //error
				}
        	}
        	
        	request.setAttribute("viewState", viewState);
			jspPage = "/abmEnvios.jsp";
			dispatch(jspPage, request, response);
        	 
         }
         else if ("saveClienteParticular".equals(action))
         {
        	 
        	 String error = "";
        	 String displayError = "none";
        	 viewStateAbmEnvios viewState;
        	 
        	 if (request.getParameter("newDomicilio")==null || request.getParameter("newDomicilio").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL DOMICILIO DEL CLIENTE";
        		 displayError = "";
        	 }
        	         	 
        	 if (request.getParameter("newApellido")==null || request.getParameter("newApellido").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL APELLIDO DEL CLIENTE";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("newNombre")==null || request.getParameter("newNombre").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL NOMBRE DEL CLIENTE";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("newDNI")==null || request.getParameter("newDNI").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL TIPO Y NRO DE DOCUMENTO DEL CLIENTE";
        		 displayError = "";
        	 }
             	 
        	 
        	 if (displayError.equals("none"))
        	 {
	        	 ParticularDTO nParticular = new ParticularDTO(request.getParameter("newDomicilio").toString(),
	        			 								request.getParameter("newNombre").toString() + " " + request.getParameter("newApellido").toString());
	        	 nParticular.setTipoDoc('D');
	        	 nParticular.setNumDoc(Integer.parseInt(request.getParameter("newDNI").toString()));
	        	 
	        	 try 
	        	 {
	        		 nParticular = new BusinessDelegate().getBusinessService().crearClienteParticular(nParticular);
	        		 
	        		 viewState = new viewStateAbmEnvios("",	 //divParticular
								"none",  //divSeleccionCliente
								"none",  //ctlSearchCliente
								"none",  //ctlNewCliente
								"none",  //divBuscarClienteParticular
								"none",  //divNuevoClienteParticular
								"",  //ctlClienteEnvio
								"",  //divCargasParticular
								"none",  //ctlCargas
								"none",  //divDestinatario
								"none",  //ctlDestinatarioEnvio
								"none", //divGuardar
								displayError, //errorDisplay
								error); //error
	        	 } 
	        	 catch (ParticularException e) 
	        	 {
	        		 nParticular = null;
	        		 viewState = new viewStateAbmEnvios("",	 //divParticular
								"none",  //divSeleccionCliente
								"none",  //ctlSearchCliente
								"",  //ctlNewCliente
								"",  //divBuscarClienteParticular
								"none",  //divNuevoClienteParticular
								"none",  //ctlClienteEnvio
								"none",  //divCargasParticular
								"none",  //ctlCargas
								"none",  //divDestinatario
								"none",  //ctlDestinatarioEnvio
								"none", //divGuardar
								"OCURRIÒ UN ERROR AL TRATAR DE GRABAR EL CLIENTE", //errorDisplay
								""); //error
	        	 }
	        	 
	        	 request.setAttribute("clienteById", nParticular);
	        	 misession.setAttribute("clienteById",nParticular);
	        	 
        	 }
        	 else
        	 {
        		 viewState = new viewStateAbmEnvios("",	 //divParticular
							"none",  //divSeleccionCliente
							"none",  //ctlSearchCliente
							"",  //ctlNewCliente
							"",  //divBuscarClienteParticular
							"none",  //divNuevoClienteParticular
							"none",  //ctlClienteEnvio
							"none",  //divCargasParticular
							"none",  //ctlCargas
							"none",  //divDestinatario
							"none",  //ctlDestinatarioEnvio
							"none", //divGuardar
							displayError, //errorDisplay
							error); //error
        	 }
        	 
    		request.setAttribute("viewState", viewState);
            jspPage = "/abmEnvios.jsp";
            dispatch(jspPage, request, response); 
         }      
         else if ("addCargaParticular".equals(action))
         {
        	 String error = "";
        	 String displayError = "none";
        	 viewStateAbmEnvios viewState;
        	 Boolean apilable;
        	 Boolean toxica;
        	 Boolean inflamable;
        	 Boolean aGranel;
        	 Boolean refrigerado;
        
        	 List<CargaDTO> cargasAgregadas;
        	 
        	 if (misession.getAttribute("cargasAgregadas")==null)
        		 cargasAgregadas = new ArrayList<CargaDTO>();
        	 else
        		 cargasAgregadas = (List<CargaDTO>)misession.getAttribute("cargasAgregadas");
        	 
        	 if (request.getParameter("txtNewAlto")==null || request.getParameter("txtNewAlto").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL ALTO DE LA CARGA";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewAncho")==null || request.getParameter("txtNewAncho").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL ANCHO DE LA CARGA ";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewMaxApilable")==null || request.getParameter("txtNewMaxApilable").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL MAXIMO DE CARGAS APILABLES";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewProfundidad")==null || request.getParameter("txtNewProfundidad").length() < 1)
        	 {
        		 error = "DEBE INDICAR LA PROFUNDIDAD DE LA CARGA";
        		 displayError = "";
        	 }
        
        	 if (request.getParameter("txtNewNotaManip")==null || request.getParameter("txtNewNotaManip").length() < 1)
        	 {
        		 error = "DEBE INDICAR UNA NOTA DE MANIULACION";
        		 displayError = "";
        	 }
        	         	 
        	 if (request.getParameter("txtNewVolumen")==null || request.getParameter("txtNewVolumen").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL VOLUMEN DE LA CARGA";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewTipo")==null || request.getParameter("txtNewTipo").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL TIPO DE CARGA";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewPeso")==null || request.getParameter("txtNewPeso").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL PESO DE LA CARGA";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewTempRefrigerado")==null || request.getParameter("txtNewTempRefrigerado").length() < 1)
        	 {
        		 error = "DEBE INDICAR LA REFRIGERACION DE LA CARGA";
        		 displayError = "";
        	 }
        	 
        	 //CHECKS
        	 
        	 if (request.getParameter("txtNewApilable")==null)
        		 apilable = false;
        	 else
        		 apilable = true;
        	 
        	 if (request.getParameter("txtNewQuimicoToxico")==null)
        		 toxica = false;
        	 else
        		 toxica = true;
        	 
        	 if (request.getParameter("txtNewRefrigerado")==null)
        		 refrigerado = false;
        	 else
        		 refrigerado = true;
        	 
        	 if (request.getParameter("txtNewAgranel")==null)
        		 aGranel = false;
        	 else
        		 aGranel = true;
        	 
        	 if (request.getParameter("txtNewInflamable")==null)
        		inflamable = false;
        	 else
        		 inflamable = true;
        	 
        	 
        	 if (displayError.equals("none"))
        	 {
        		 CargaDTO c = new CargaDTO(Float.parseFloat(request.getParameter("txtNewAlto").toString()),
        				 				   Float.parseFloat(request.getParameter("txtNewAncho").toString()),
        				 				   apilable,
        				 				   new CategoriaFragilidadDTO(),
        				 				   new CategoriaTratamientoDTO(),
        				 				   inflamable,
        				 				   toxica,
        				 				   new ManifiestoDTO(),
        				 				   Integer.parseInt(request.getParameter("txtNewMaxApilable").toString()),
        				 				   request.getParameter("txtNewNotaManip").toString(),
        				 				   Float.parseFloat(request.getParameter("txtNewPeso").toString()),
        				 				   Float.parseFloat(request.getParameter("txtNewProfundidad").toString()),
        				 				   refrigerado,
        				 				   Integer.parseInt(request.getParameter("txtNewTempRefrigerado").toString()),
        				 				   request.getParameter("txtNewTipo").toString(),
        				 				   Float.parseFloat(request.getParameter("txtNewVolumen").toString()),
        				 				   aGranel);

        		 
        		 cargasAgregadas.add(c);
        		 
        		 viewState = new viewStateAbmEnvios("",	 //divParticular
							"none",  //divSeleccionCliente
							"none",  //ctlSearchCliente
							"none",  //ctlNewCliente
							"none",  //divBuscarClienteParticular
							"none",  //divNuevoClienteParticular
							"",  //ctlClienteEnvio
							"",  //divCargasParticular
							"",  //ctlCargas
							"",  //divDestinatario
							"none",  //ctlDestinatarioEnvio
							"none", //divGuardar
							"none", //errorDisplay
							""); //error
        	 }
        	 else
        	 {
        		 viewState = new viewStateAbmEnvios("",	 //divParticular
							"none",  //divSeleccionCliente
							"none",  //ctlSearchCliente
							"none",  //ctlNewCliente
							"none",  //divBuscarClienteParticular
							"none",  //divNuevoClienteParticular
							"",  //ctlClienteEnvio
							"",  //divCargasParticular
							"none",  //ctlCargas
							"none",  //divDestinatario
							"none",  //ctlDestinatarioEnvio
							"none", //divGuardar
							displayError, //errorDisplay
							error); //error
        	 }
        		 
        	 misession.setAttribute("cargasAgregadas",cargasAgregadas);
        	 request.setAttribute("cargasAgregadas",cargasAgregadas);
        	 request.setAttribute("clienteById", misession.getAttribute("clienteById"));
        	 request.setAttribute("viewState", viewState);
             jspPage = "/abmEnvios.jsp";
             dispatch(jspPage, request, response); 
         }
         else if ("addDestinatarioParticular".equals(action))
         {
        	 String error = "";
        	 String displayError = "none";
        	 viewStateAbmEnvios viewState;
        	
        	 if (request.getParameter("txtNewNombreDestinatario")==null || request.getParameter("txtNewNombreDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL NOMBRE DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	         	 
        	 if (request.getParameter("txtNewDomicilioDestinatario")==null || request.getParameter("txtNewDomicilioDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL DOMICILIO DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewCodPostalDestinatario")==null || request.getParameter("txtNewCodPostalDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL CODIGO POSTAL DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewPaisDestinatario")==null || request.getParameter("txtNewPaisDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL PAIS DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	         	 
        	 if (request.getParameter("txtNewProvinciaDestinatario")==null || request.getParameter("txtNewProvinciaDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR LA PROVINCIA DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewPisoDestinatario")==null || request.getParameter("txtNewPisoDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL PISO DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewDtoDestinatario")==null || request.getParameter("txtNewDtoDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL DEPARTAMENTO DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	         	 
        	 if (request.getParameter("txtNewNumDocDestinatario")==null || request.getParameter("txtNewNumDocDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR EL NUMERO DOCUMENTO DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("txtNewAutorizantesDestinatario")==null || request.getParameter("txtNewAutorizantesDestinatario").length() < 1)
        	 {
        		 error = "DEBE INDICAR LOS AUTORIZANTES DEL DESTINATARIO";
        		 displayError = "";
        	 }
        	 
        	 PaisDTO pais = null;
			 try 
			 {
			 	pais = new BusinessDelegate().getBusinessService().getPais(Integer.parseInt(request.getParameter("txtNewPaisDestinatario")));
			 } 
			 catch (PaisException e) 
			 {
				 error = "DEBE INDICAR LOS AUTORIZANTES DEL DESTINATARIO";
        		 displayError = "";
			 }
			
     		 ProvinciaDTO provincia = null;
     		 try 
			 {
     			provincia = new BusinessDelegate().getBusinessService().getProvincia(Integer.parseInt(request.getParameter("txtNewProvinciaDestinatario")));
			 } 
			 catch (ProvinciaException e) 
			 {
				 error = "DEBE INDICAR LOS AUTORIZANTES DEL DESTINATARIO";
				 displayError = "";
			 }
     		
     		 ClienteDTO cliente = (ClienteDTO)misession.getAttribute("clienteById");
     		 
     		 if(cliente == null)
     		 {
				 error = "SE HA PERDIDO LA SESION, Y LOS DATOS GUARDADOS. POR FAVOR VUELVA A INICIAR EL PROCESO DE CARGA DEL ENVIO.";
				 displayError = "";
			 }
        	 
        	 if (displayError.equals("none"))
        	 {
	        	 DestinatarioDTO nDetinatario = new DestinatarioDTO(request.getParameter("txtNewNombreDestinatario"),
	        			 											request.getParameter("txtNewDomicilioDestinatario"),
													    			request.getParameter("txtNewCodPostalDestinatario"),
													    			pais,
													    			provincia,
													    			Integer.parseInt(request.getParameter("txtNewPisoDestinatario")),
													    			request.getParameter("txtNewDtoDestinatario"),
													    			Integer.parseInt(request.getParameter("txtNewNumDocDestinatario")),
													    			request.getParameter("txtNewAutorizantesDestinatario"),
													    			cliente);
	        	 try 
	        	 {
	        		 nDetinatario = new BusinessDelegate().getBusinessService().crearDestinatario(nDetinatario);
	        		 
	        		 viewState = new viewStateAbmEnvios("",	 //divParticular
	        				    "none",  //divSeleccionCliente
								"none",  //ctlSearchCliente
								"none",  //ctlNewCliente
								"none",  //divBuscarClienteParticular
								"none",  //divNuevoClienteParticular
								"",  //ctlClienteEnvio
								"",  //divCargasParticular
								"",  //ctlCargas
								"none",  //divDestinatario
								"",  //ctlDestinatarioEnvio
								"none", //divGuardar
								"none", //errorDisplay
								""); //error
	        	 } 
	        	 catch (DestinatarioException e) 
	        	 {
	        		 nDetinatario = null;
	        		 viewState = new viewStateAbmEnvios("",	 //divParticular
	        				    "none",  //divSeleccionCliente
								"none",  //ctlSearchCliente
								"none",  //ctlNewCliente
								"none",  //divBuscarClienteParticular
								"none",  //divNuevoClienteParticular
								"",  //ctlClienteEnvio
								"",  //divCargasParticular
								"",  //ctlCargas
								"",  //divDestinatario
								"none",  //ctlDestinatarioEnvio
								"none", //divGuardar
								"OCURRIÒ UN ERROR AL TRATAR DE GRABAR EL CLIENTE", //errorDisplay
								""); //error
	        	 }
	        	 
	        	 request.setAttribute("destinatario", nDetinatario);
	        	 misession.setAttribute("destinatario",nDetinatario);
	        	 
        	 }
        	 else
        	 {
        		 viewState = new viewStateAbmEnvios("",	 //divParticular
        				    "none",  //divSeleccionCliente
							"none",  //ctlSearchCliente
							"none",  //ctlNewCliente
							"none",  //divBuscarClienteParticular
							"none",  //divNuevoClienteParticular
							"",  //ctlClienteEnvio
							"",  //divCargasParticular
							"",  //ctlCargas
							"",  //divDestinatario
							"none",  //ctlDestinatarioEnvio
							"none", //divGuardar
							displayError, //errorDisplay
							error); //error
        	 }
        	 
        	 request.setAttribute("cargasAgregadas",misession.getAttribute("cargasAgregadas"));
        	 request.setAttribute("clienteById", misession.getAttribute("clienteById"));
        	 request.setAttribute("viewState", viewState);
             jspPage = "/abmEnvios.jsp";
             dispatch(jspPage, request, response); 
         }  
        	 
	}
	
	 protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
         if (jsp != null)
         {
         	/*Envía el control al JSP que pasamos como parámetro, y con los 
         	 * request / response cargados con los parámetros */
             RequestDispatcher rd = request.getRequestDispatcher(jsp);
             rd.forward(request, response);
         }
     }
	 
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
      {
          doPost(request, response);
      }
}
