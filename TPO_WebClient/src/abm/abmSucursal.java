package abm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class abmSucursal extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7930123587008023709L;
	
	public abmSucursal (){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nombre_sucursal 	= request.getParameter("nombre_sucursal");
		 String direccion_sucursal 	=  request.getParameter("direccion_sucursal");
		 String latitud_sucursal 	=  request.getParameter("latitud_sucursal");
		 String longitud_sucursal 	=  request.getParameter("longitud_sucursal");
		 
		 //debug
		 System.out.println("nombre_sucursal: " + nombre_sucursal);
		 System.out.println("direccion_sucursal: " + direccion_sucursal);
		 System.out.println("latitud_sucursal: " + latitud_sucursal);
		 System.out.println("longitud_sucursal: " + longitud_sucursal);
		 
		 
		 
		 //Lo consultamos con los profesores en clase
		 //Validamos que los datos tengan contenido
		 /*
		 if(nombre_sucursal.length() > 0){
			 
		 }
		 */
		 
		 //Validamos que no exista en la BD (pseudocodigo)
		 /*
		 boolean existeSucursal = new BusinessDelegate().getBusinessService().existeSucursal(nombre_sucursal);
		 if(existeSucursal){
		 	//muestro mensaje en pantalla que ya existe
		 }else{
		 	//sigo con el flujo de alta
		 }
		 */
		 
		 /*
		 //LLamamos metodo de alta de sucursal
			SucursalDTO sucursal = new SucursalDTO(nombre_sucursal,
												   direccion_sucursal,
												   latitud_sucursal,
												   longitud_sucursal);

		//Obtenemos el listado de rutas actualizado
		List<RutaDTO> rutas = new ArrayList<RutaDTO>();
		
		//Asignamos las rutas a la sucursal creada
		if(rutas.size() > 0){
			sucursal.setRutas(rutas);
		}
		
		SucursalDTO sucursalCreada;
		try {
			sucursalCreada = new BusinessDelegate().getBusinessService().crearSucursal(sucursal);
			System.out.println("Sucursal creada: " + sucursalCreada);
		} catch (RemoteException | SucursalException e) {
			e.printStackTrace();
		}
		
		//Ejemplo de como listar sucursales
		List<SucursalDTO> sucursales;
		try {
			sucursales = new BusinessDelegate().getBusinessService().getSucursales();
			for(SucursalDTO s:sucursales){
				System.out.print("Sucursal: " + s.getNombre());
			}
		} catch (SucursalException e) {
			e.printStackTrace();
		}
		*/

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
