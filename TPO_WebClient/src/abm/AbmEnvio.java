package abm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbmEnvio extends HttpServlet {

	private static final long serialVersionUID = -7930123587008023709L;
	
	public AbmEnvio (){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String dniCliente 	= request.getParameter("dniCliente");
		
		 //debug
		 System.out.println("dniCliente: " + dniCliente);
	
	}
}
