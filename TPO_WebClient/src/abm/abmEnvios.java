package abm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.txw2.Document;

import config.viewStateAbmEnvios;
//import dto.ParticularDTO;
import negocio.Particular;

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
             //Cliente cliente = AdminCliente.getInstancia().getClientes();
        	// ParticularDTO client = new ParticularDTO();
        	// client.setNombre("JORGe2");
        	// client.setDomicilio("SAN MARTIN 492");
        	// client.setNumDoc(33688562);
        	// client.setTipoDoc('1');
        	 //Particular nParticular = new Particular(client.getTipoDoc(),client.getNumDoc(),client.getDomicilio(),client.getNombre());
        	 
        	Particular nParticular = new Particular('1',34678902,"URQUIZA 1034","MONICA BUSCADA");
        	 request.setAttribute("clienteById", nParticular);
        	 viewStateAbmEnvios viewState = new viewStateAbmEnvios("",	 //divParticular
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
        		 error = "Debe indicar el Domicilio del Cliente";
        		 displayError = "";
        	 }
        	         	 
        	 if (request.getParameter("newApellido")==null || request.getParameter("newApellido").length() < 1)
        	 {
        		 error = "Debe indicar el Apellido del Cliente";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("newNombre")==null || request.getParameter("newNombre").length() < 1)
        	 {
        		 error = "Debe indicar el Nombre del Cliente";
        		 displayError = "";
        	 }
        	 
        	 if (request.getParameter("newDNI")==null || request.getParameter("newDNI").length() < 1)
        	 {
        		 error = "Debe indicar el DNI del Cliente";
        		 displayError = "";
        	 }
             	 
        	 
        	 if (displayError.equals("none"))
        	 {
	        	 Particular nParticular = new Particular('1',
	        			 								Integer.parseInt(request.getParameter("newDNI").toString()),
	        			 								request.getParameter("newDomicilio").toString(),
	        			 								request.getParameter("newNombre").toString() + " " + request.getParameter("newApellido").toString());
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
	        			 											displayError, //errorDisplay
	 					error); //error
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
