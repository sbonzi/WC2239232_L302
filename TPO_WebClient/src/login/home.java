package login;

import   java.io.*;
import   javax.servlet.*;
import   javax.servlet.http.*;

public   class   home   extends   HttpServlet
{

	private static final long serialVersionUID = 1087702007634924546L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
    	 	HttpSession sesion = request.getSession();
            String action = request.getParameter("action");
            String jspPage = "/home.jsp";
           

            if ((action == null) || (action.length() < 1))
            {
                action = "default";
            }

            if ("default".equals(action))
            {
                jspPage = "/home.jsp";
                dispatch(jspPage, request, response);
            }
            else if ("login".equals(action))
            {
            	if (sesion.getAttribute("usuario") == null)
            	{
            		jspPage = "/TPO_WebClient/login.jsp";
            		response.sendRedirect(jspPage);
            	}
            	else
            	{
            		 jspPage = "/home.jsp";
                     dispatch(jspPage, request, response);
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