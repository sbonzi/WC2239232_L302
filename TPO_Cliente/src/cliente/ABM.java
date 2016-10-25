package cliente;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.RolEmpleadoDTO;
import dto.RutaDTO;
import dto.SucursalDTO;
import exceptions.EmpleadoException;
import exceptions.RolEmpleadoException;
import exceptions.RutaException;
import exceptions.SucursalException;
import interfaz.IABM;
import interfaz.INegocioEnvio;
import util.InputUsuario;

public class ABM {
	INegocioEnvio controladorEnvios;
	
	public static void main(String[] args){
		new ABM();
	}
	
	public ABM(){
		this.opcionesABM();
	}
	
	public void opcionesABM(){
		
		int opcionElegida = 0;
		do{
			System.out.println("####### Ingrese la opción #######");
			System.out.println("- 1 (Alta de sucursal)");
			System.out.println("- 2 (Alta de ruta)");
			System.out.println("- 3 (Alta rol empleado)");
			System.out.println("- 4 (Alta Empleado)");
			System.out.println("- 0 (Salir)");
	
			try {
				opcionElegida = InputUsuario.ingresoInt("Ingrese opción: ");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			System.out.println("Opcion elegida: " + opcionElegida);
			
			switch(opcionElegida){
				case 1:
					this.altaSucursal();
				break;
				case 2:
					this.altaRuta();
				break;
				case 3:
					this.altaRolEmpleado();
				break;
				case 4:
					this.altaEmpleado();
				break;
			}
		}while(opcionElegida != 0);
	}
	
	//ABM Empleado
	private void altaEmpleado() {
		List<RolEmpleadoDTO> rolesEmpleadoDTO 	= this.getRoles();
		List<SucursalDTO> sucursalesDTO 		= this.getSucursales();
		
		if(rolesEmpleadoDTO.size() > 0 && sucursalesDTO.size() > 0){
			
			//Cuit
			String cuit 			= null;
			boolean empleadoValido 	= false;
			do{
				try {
					cuit = InputUsuario.ingresoString("Cuit del empleado: ");
					if(!this.existeEmpleado(cuit)){
						empleadoValido = true;
					}else{
						System.out.println("### El empleado ingresado ya existe, ingrese otro ###");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}while(!empleadoValido);
			
			//Nombre
			String nombre = null;
			try {
				nombre = InputUsuario.ingresoString("Nombre del empleado: ");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//Listamos roles disponibles para el empleado	
			this.printListadoRolesEmpleado(rolesEmpleadoDTO);
			
			boolean rolValido 			= false;
			int nroRolEmpleado			= 0;
			RolEmpleadoDTO rolEmpleado	= null;
			do{
				try {
					nroRolEmpleado = InputUsuario.ingresoInt("Nro de rol: ");
					rolEmpleado = this.getRolEmpleadoByNro(nroRolEmpleado); 
					if(rolEmpleado != null){
						rolValido = true;
					}else{
						System.out.println("### El rol de empleado ingresado no es válido ###");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}while(!rolValido);
			
			//Listamos sucursales disponibles para el empleado
			this.printListadoSucursales(sucursalesDTO);
			
			boolean sucursalValida 	= false;
			int nroSucursal			= 0;
			SucursalDTO sucursal	= null;
			do{
				try {
					nroSucursal = InputUsuario.ingresoInt("Nro de sucursal: ");
					sucursal = this.getSucursalByNro(nroSucursal); 
					if(sucursal != null){
						sucursalValida = true;
					}else{
						System.out.println("### La sucursal ingresada no es válida ###");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}while(!sucursalValida);
			
			EmpleadoDTO empleado = new EmpleadoDTO(cuit, nombre);
			//Asignamos rol y sucursal al empleado
			empleado.setRolEmpleado(rolEmpleado);
			empleado.setSucursal(sucursal);
			
			EmpleadoDTO empleadoCreado;
			try {
				empleadoCreado	= new BusinessDelegate().getBusinessService().crearEmpleado(empleado);
				System.out.println("Empleado creado: " + empleadoCreado);
			} catch (RemoteException | EmpleadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			System.out.println("### Sólo se puede crear un empleado si hay algún rol y sucursal cargado ###");
		}
	}

	private boolean existeEmpleado(String cuit) {
		boolean resultado = false;
		List<EmpleadoDTO> empleados = this.getEmpleados();
		for(EmpleadoDTO e:empleados){
			if(e.getCuit().equalsIgnoreCase(cuit)){
				resultado = true;
				break;
			}
		}
		return resultado;
	}

	private List<EmpleadoDTO> getEmpleados() {
		List<EmpleadoDTO> empleados = null;
		try {
			empleados = new BusinessDelegate().getBusinessService().getEmpleados();
		} catch (RemoteException | EmpleadoException e) {
			e.printStackTrace();
		}
		return empleados;
	}

	//ABM Roles empleado
	private void altaRolEmpleado() {
		String descripcion 			= null;
		boolean rolEmpleadoValido 	= false;
		do{
			try {
				descripcion = InputUsuario.ingresoString("Descripción del rol: ");
				if(!this.existeRolEmpleado(descripcion)){
					rolEmpleadoValido = true;
				}else{
					System.out.println("### El rol ingresado ya existe, ingrese otra descripción ###");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}while(!rolEmpleadoValido);
		
		RolEmpleadoDTO rolEmpleado = new RolEmpleadoDTO(descripcion);
		
		RolEmpleadoDTO RolEmpleadoCreado;
		try {
			RolEmpleadoCreado = new BusinessDelegate().getBusinessService().crearRolEmpleado(rolEmpleado);
			System.out.println("Rol empleado creado: " + RolEmpleadoCreado);
		} catch (RemoteException | RolEmpleadoException e) {
			e.printStackTrace();
		}
		
	}

	private boolean existeRolEmpleado(String descripcionRol) {
		boolean resultado = false;
		List<RolEmpleadoDTO> rolesEmpleado = this.getRoles();
		for(RolEmpleadoDTO r:rolesEmpleado){
			if(r.getDescripcion().equalsIgnoreCase(descripcionRol)){
				resultado = true;
				break;
			}
		}
		return resultado;
	}
	
	private RolEmpleadoDTO getRolEmpleadoByNro(int nroRolEmpleado) {
		RolEmpleadoDTO rolEmpleado = null;
		List<RolEmpleadoDTO> rolesEmpleado = this.getRoles();
		for(RolEmpleadoDTO r:rolesEmpleado){
			if(r.getId() == nroRolEmpleado){
				rolEmpleado = r;
				break;
			}
		}
		return rolEmpleado;
	}

	private List<RolEmpleadoDTO> getRoles() {
		List<RolEmpleadoDTO> roles = null;
		try {
			roles = new BusinessDelegate().getBusinessService().getRoles();
		} catch (RemoteException | RolEmpleadoException e) {
			e.printStackTrace();
		}
		return roles;
	}
	
	public void printListadoRolesEmpleado(List<RolEmpleadoDTO> rolesEmpleadoDTO){	
		if(rolesEmpleadoDTO.size() > 0){
			System.out.println("------Listado de roles de empleado------");
			for(RolEmpleadoDTO r:rolesEmpleadoDTO){
				System.out.println("nroRol=" + r.getId() + ", descripcion=" + r.getDescripcion());
			}
			System.out.println("---------------------------------");
		}
	}

	//ABM Rutas
	public void altaRuta(){
		
		SucursalDTO sucursalOrigen 	= null;
		SucursalDTO sucursalDestino = null;
		
		List<SucursalDTO> sucursalesDTO = new ArrayList<SucursalDTO>();
		try {
			sucursalesDTO = new BusinessDelegate().getBusinessService().getSucursales();
		} catch (RemoteException | SucursalException e) {
			e.printStackTrace();
		}
		
		System.out.println("####### Seleccione una sucursal de origen y destino #######");
		this.printListadoSucursales(sucursalesDTO);
		
		boolean rutaValida = false;
		do{
			int nroSucursalOrigen 			= 0;
			boolean nroSucursalOrigenValido = false;
			do{
				try {
					nroSucursalOrigen 	= InputUsuario.ingresoInt("Nro sucursal origen: ");
					sucursalOrigen 		= this.getSucursalDelListado(sucursalesDTO,nroSucursalOrigen);
					if(sucursalOrigen != null){
						nroSucursalOrigenValido = true;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}while(!nroSucursalOrigenValido);
			
			int nroSucursalDestino 			= 0;
			boolean nroSucursalDestinoValido = false;
			do{
				try {
					nroSucursalDestino 	= InputUsuario.ingresoInt("Nro sucursal destino: ");
					sucursalDestino 	= this.getSucursalDelListado(sucursalesDTO,nroSucursalDestino);
					if(sucursalDestino != null){
						nroSucursalDestinoValido = true;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}while(!nroSucursalDestinoValido);
			
			//Verificamos si la combinación de origen y destino no existen
			if(!this.existeRuta(sucursalOrigen, sucursalDestino)){
				rutaValida = true;
			}else{
				System.out.println("### La ruta indicada ya existe, ingrese otra combinación ###");
			}
		}while(!rutaValida);
		
		int duracionViaje = 0;
		try {
			duracionViaje = InputUsuario.ingresoInt("Duración del viaje (hs): ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Float costoViaje = null;
		try {
			costoViaje = InputUsuario.ingresoFloat("Costo del viaje: ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		RutaDTO ruta = new RutaDTO(duracionViaje,
								   costoViaje,
								   sucursalOrigen,
								   sucursalDestino);
		
		try {
			RutaDTO rutaCreada = new BusinessDelegate().getBusinessService().crearRuta(ruta);
			System.out.println("Ruta creada: " + rutaCreada);
		} catch (RemoteException | RutaException e) {
			e.printStackTrace();
		}
		
	}
	
	private List<RutaDTO> getRutas(){
		List<RutaDTO> rutas = null;
		try {
			rutas = new BusinessDelegate().getBusinessService().getRutas();
		} catch (RemoteException | RutaException e) {
			e.printStackTrace();
		}
		return rutas;
	}
	
	private boolean existeRuta(SucursalDTO sucursalOrigen,SucursalDTO sucursalDestino){
		boolean resultado = false;
		List<RutaDTO> rutas = this.getRutas();
		for(RutaDTO r:rutas){
			if(r.getSucursalOrigen().getNumero() == sucursalOrigen.getNumero() &&
			   r.getSucursalDestino().getNumero() == sucursalDestino.getNumero()){
				resultado = true;
				break;
			}
		}
		return resultado;
	}
	
	//ABM Sucursales
	private SucursalDTO getSucursalDelListado(List<SucursalDTO> sucursalesDTO, int nroSucursalOrigen) {
		SucursalDTO sucursalDTO = null;
		for(SucursalDTO s:sucursalesDTO){
			if(s.getNumero() == nroSucursalOrigen){
				sucursalDTO = s;
				break;
			}
		}
		return sucursalDTO;
	}
	
	public void altaSucursal(){
		String nombre = null;
		try {
			nombre = InputUsuario.ingresoString("Nombre de la sucursal: ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String direccion = null;
		try {
			direccion = InputUsuario.ingresoString("Dirección de la sucursal: ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String latitud = null;
		try {
			latitud = InputUsuario.ingresoString("Latitud de la sucursal: ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String longitud = null;
		try {
			longitud = InputUsuario.ingresoString("Longitud de la sucursal: ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		SucursalDTO sucursal = new SucursalDTO(nombre,
											   direccion,
											   latitud,
											   longitud);
		
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
	}
	
	public void printListadoSucursales(List<SucursalDTO> sucursalesDTO){	
		if(sucursalesDTO.size() > 0){
			System.out.println("------Listado de sucursales------");
			for(SucursalDTO s:sucursalesDTO){
				System.out.println("NroSucursal: " + s.getNumero() + ", nombre: " + s.getNombre());
			}
			System.out.println("---------------------------------");
		}
	}

	private List<SucursalDTO> getSucursales() {
		List<SucursalDTO> sucursales = null;
		try {
			sucursales = new BusinessDelegate().getBusinessService().getSucursales();
		} catch (RemoteException | SucursalException e) {
			e.printStackTrace();
		}
		return sucursales;
	}
	
	private SucursalDTO getSucursalByNro(int nroSucursal) {
		SucursalDTO sucursal = null;
		List<SucursalDTO> sucursales = this.getSucursales();
		for(SucursalDTO s:sucursales){
			if(s.getNumero() == nroSucursal){
				sucursal = s;
				break;
			}
		}
		return sucursal;
	}
	
}
