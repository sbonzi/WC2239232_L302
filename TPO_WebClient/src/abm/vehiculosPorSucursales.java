package abm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessDelegate.BusinessDelegate;
import config.viewStateArribos;
import dto.SucursalDTO;
import dto.VehiculoDTO;
import exceptions.SucursalException;
import exceptions.VehiculoException;


@WebServlet("/vehiculosPorSucursales")
public class vehiculosPorSucursales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public vehiculosPorSucursales() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession misession = request.getSession(true);
		 if(misession == null || misession.getAttribute("usuario") == null)
		 {
			response.sendRedirect("/TPO_WebClient/login.jsp");
			misession.removeAttribute("envios");
			misession.removeAttribute("sucursales");
		 }
		
		String action = request.getParameter("action");
        String jspPage = "/vehiculosPorSucursales.jsp";
       
       if(misession.getAttribute("sucursales")==null)
       {
       	List<SucursalDTO> sucursales = new ArrayList<SucursalDTO>();
			try 
			{
				sucursales = new BusinessDelegate().getBusinessService().getSucursales();
				misession.setAttribute("sucursales", sucursales);
				request.setAttribute("sucursales", sucursales);
			} 
			catch (SucursalException e) 
			{
				viewStateArribos viewState = new viewStateArribos("", //divFiltroArribos
											    				  "none", //divGrillaArribos
											    				  "", //divErrorArribos
											    				  "HA OCURRIDO UN ERROR AL OBTENER LAS SUCURSALES"); //error
				
				request.setAttribute("viewState", viewState);
	            jspPage = "/vehiculosPorSucursales.jsp";
	            dispatch(jspPage, request, response);
			}
       }
       else
       {
       	request.setAttribute("sucursales", misession.getAttribute("sucursales"));
       }


       if ((action == null) || (action.length() < 1))
       {
           action = "default";
       }

       if ("default".equals(action))
       {
       	viewStateArribos viewState = new viewStateArribos("", //divFiltroArribos
										   				  "none", //divGrillaArribos
										   				  "none", //divErrorArribos
										   				  ""); //error
   	
      	   request.setAttribute("viewState", viewState);
           jspPage = "/vehiculosPorSucursales.jsp";
           dispatch(jspPage, request, response);
       }
       else if ("filterVehiculos".equals(action))
       {
       	 viewStateArribos viewState;
       	 
       	 try 
       	 {
       		 SucursalDTO suc = null;
       		 if (request.getParameter("cmbSUC")!=null && Integer.parseInt(request.getParameter("cmbSUC")) != 0)
           	 {
       			 suc = new BusinessDelegate().getBusinessService().getSucursalById(Integer.parseInt(request.getParameter("cmbSUC").toString()));
           	 }
       		
				List<VehiculoDTO> vehiculos = new BusinessDelegate().getBusinessService().getVehiculosPorSucursal(suc);
				
				viewState = new viewStateArribos("", //divFiltroArribos
							    				"", //divGrillaArribos
							    				"none", //divErrorArribos
							    				""); //error
				
				 request.setAttribute("vehiculos", vehiculos);
	        	 misession.setAttribute("vehiculos",vehiculos);
	    	
			 } 
       	 catch (VehiculoException | NumberFormatException | SucursalException e) {
       		 viewState = new viewStateArribos("", //divFiltroArribos
						 	    				"none", //divGrillaArribos
						 	    				"", //divErrorArribos
						 	    				"HA OCURRIDO UN ERROR AL OBTENER LOS ENVIOS"); //error
			}
       	 
       	 request.setAttribute("viewState", viewState);
            jspPage = "/vehiculosPorSucursales.jsp";
            dispatch(jspPage, request, response); 
       }
	}

}
