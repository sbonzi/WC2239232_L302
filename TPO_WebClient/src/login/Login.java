package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{

	private static final long serialVersionUID = 6682978410902534081L;
	
	public Login(){
		super();
	}
	
	 //metodo encargado de la gestión del método POST
    protected void doPOST(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        //deberíamos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo código
        if(usu.equals("admin") && pass.equals("admin") && sesion.getAttribute("usuario") == null){
            //si coincide usuario y password y además no hay sesión iniciada
            sesion.setAttribute("usuario", usu);
            //redirijo a página con información de login exitoso
            response.sendRedirect("Home.hmtl");
        }else{
            //lógica para login inválido
        	System.out.println("El usuario y password son incorrectos");
        }
    }
 
   //método encargado de la gestión del método GET
    protected void doGET(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        //me llega la url "proyecto/login/out"
        String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        HttpSession sesion = request.getSession();
        if(action.equals("/out")){
            sesion.invalidate();
            response.sendRedirect("Exit.hmtl");
        }else{
 
        }
    }
	
}
