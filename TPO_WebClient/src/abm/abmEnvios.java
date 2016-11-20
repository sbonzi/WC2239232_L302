package abm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.txw2.Document;

import businessDelegate.BusinessDelegate;
import config.viewStateAbmEnvios;
import dto.ParticularDTO;
import exceptions.ParticularException;
//import negocio.Particular;

public class abmEnvios extends HttpServlet {

	private static final long serialVersionUID = -7930123587008023709L;
	
	public abmEnvios (){
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
