package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6682978410902534081L;
	
	
	public Login(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nombre_usuario 		= request.getParameter("nombre_usuario");
		 String password_usuario 	=  request.getParameter("password_usuario");
		 
		 //TODO Consultar contra la BD las credenciales del usuario
		 //En éste caso lo simulamos
		 if(nombre_usuario.equalsIgnoreCase("pepe") && password_usuario.equalsIgnoreCase("1234")){
			 //Redireccionamos al panel de control
			 System.out.println("El usuario y password son correctos");
			 
		 }else{
			 System.out.println("El usuario y password son incorrectos");
		 }

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
