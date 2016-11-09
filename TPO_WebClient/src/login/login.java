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
	
	 //metodo encargado de la gesti�n del m�todo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        //deber�amos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo c�digo
        if(sesion.getAttribute("usuario") != null)
        {
        	 String jspPage = "/home.jsp";
             dispatch(jspPage, request, response);
        }
        else if(usu.equals("admin") && pass.equals("admin") && sesion.getAttribute("usuario") == null){
            //si coincide usuario y password y adem�s no hay sesi�n iniciada
            sesion.setAttribute("usuario", usu);
            //redirijo a p�gina con informaci�n de login exitoso
            String jspPage = "/home.jsp";
            dispatch(jspPage, request, response);
        }else{
            //l�gica para login inv�lido
        	String jspPage = "/login.jsp";
            dispatch(jspPage, request, response);
        }
    }
 
    protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (jsp != null)
        {
        	/*Env�a el control al JSP que pasamos como par�metro, y con los 
        	 * request / response cargados con los par�metros */
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }

    
   //m�todo encargado de la gesti�n del m�todo GET
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
