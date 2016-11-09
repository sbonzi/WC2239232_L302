package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet{

	private static final long serialVersionUID = 6682978410902534081L;
	
	 //metodo encargado de la gestión del método POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        //deberíamos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo código
        if(sesion.getAttribute("usuario") != null)
        {
        	 String jspPage = "/home.jsp";
             dispatch(jspPage, request, response);
        }
        else if(usu.equals("admin") && pass.equals("admin") && sesion.getAttribute("usuario") == null){
            //si coincide usuario y password y además no hay sesión iniciada
            sesion.setAttribute("usuario", usu);
            //redirijo a página con información de login exitoso
            String jspPage = "/home.jsp";
            dispatch(jspPage, request, response);
        }else{
            //lógica para login inválido
        	String jspPage = "/login.jsp";
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

    
   //método encargado de la gestión del método GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        //me llega la url "proyecto/login/out"
        String action = request.getParameter("action");
        HttpSession sesion = request.getSession();
        if(action.equals("out")){
            sesion.invalidate();
            String jspPage = "/home.jsp";
            dispatch(jspPage, request, response);
        }else{
 
        }
    }
	
}
