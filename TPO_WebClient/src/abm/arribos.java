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

import businessDelegate.BusinessDelegate;
import config.viewStateArribos;
import dto.EnvioDTO;
import dto.EstadoEnvioDTO;
import dto.SucursalDTO;
import exceptions.EnvioException;
import exceptions.EstadoEnvioException;
import exceptions.SucursalException;

public class arribos extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320029929826324548L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 HttpSession misession = request.getSession(true);
		 if(misession == null || misession.getAttribute("usuario") == null)
		 {
 			response.sendRedirect("/TPO_WebClient/login.jsp");
 			misession.removeAttribute("envios");
 			misession.removeAttribute("sucursales");
		 }
		
		String action = request.getParameter("action");
        String jspPage = "/arribos.jsp";
        
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
	            jspPage = "/arribos.jsp";
	            dispatch(jspPage, request, response);
			}
        }
        else
        {
        	request.setAttribute("sucursales", misession.getAttribute("sucursales"));
        }
        
        if(misession.getAttribute("estadosEnvios")==null)
        {
        	List<EstadoEnvioDTO> estados = new ArrayList<EstadoEnvioDTO>();
			try 
			{
				estados = new BusinessDelegate().getBusinessService().getEstadosEnvios();
				misession.setAttribute("estadosEnvios", estados);
				request.setAttribute("estadosEnvios", estados);
			} 
			catch (EstadoEnvioException e) 
			{
				viewStateArribos viewState = new viewStateArribos("", //divFiltroArribos
 	    				"none", //divGrillaArribos
 	    				"", //divErrorArribos
 	    				"HA OCURRIDO UN ERROR AL OBTENER LOS ESTADOS DE LOS ENVIOS"); //error
				
				request.setAttribute("viewState", viewState);
	            jspPage = "/arribos.jsp";
	            dispatch(jspPage, request, response);
			}
        }
        else
        {
        	request.setAttribute("estadosEnvios", misession.getAttribute("estadosEnvios"));
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
            jspPage = "/arribos.jsp";
            dispatch(jspPage, request, response);
        }
        else if ("filterEnvios".equals(action))
        {
        	 String error = "";
        	 String displayError = "none";
        	 viewStateArribos viewState;
        	 
        	 try 
        	 {
        		 SucursalDTO suc = null;
        		 if (request.getParameter("cmbSUCDESTINO")!=null && Integer.parseInt(request.getParameter("cmbSUCDESTINO")) != 0)
            	 {
        			 suc = new BusinessDelegate().getBusinessService().getSucursalById(Integer.parseInt(request.getParameter("cmbSUCDESTINO").toString()));
            	 }
        		 
        		 int estado =0;
        		 if (request.getParameter("cmbESTADO")!=null && Integer.parseInt(request.getParameter("cmbESTADO")) != 0)
            	 {
        			 estado = Integer.parseInt(request.getParameter("cmbESTADO").toString());
            	 }
        		
				List<EnvioDTO> envios = new BusinessDelegate().getBusinessService().getEnviosPorSucursalDestinoEstado(suc, estado);
				
				viewState = new viewStateArribos("", //divFiltroArribos
							    				"", //divGrillaArribos
							    				"none", //divErrorArribos
							    				""); //error
				
				 request.setAttribute("envios", envios);
	        	 misession.setAttribute("envios",envios);
	    	
			 } 
        	 catch (EnvioException | NumberFormatException | SucursalException e) {
        		 viewState = new viewStateArribos("", //divFiltroArribos
						 	    				"none", //divGrillaArribos
						 	    				"", //divErrorArribos
						 	    				"HA OCURRIDO UN ERROR AL OBTENER LOS ENVIOS"); //error
			}
        	 
        	 request.setAttribute("viewState", viewState);
             jspPage = "/arribos.jsp";
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
