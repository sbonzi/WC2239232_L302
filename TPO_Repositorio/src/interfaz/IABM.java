package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.EmpleadoDTO;
import dto.RolEmpleadoDTO;
import dto.RutaDTO;
import dto.SucursalDTO;
import exceptions.EmpleadoException;
import exceptions.RolEmpleadoException;
import exceptions.RutaException;
import exceptions.SucursalException;

/**
 * Gestiona todas las operacines de ABM del sistema
 * @author Daniel PC
 *
 */
public interface IABM extends Remote{
	
	//ABM Sucursales
	SucursalDTO crearSucursal(SucursalDTO sucursal) throws RemoteException,SucursalException;
	
	SucursalDTO modificarSucursal(int idSucursal) throws RemoteException,SucursalException;
	
	SucursalDTO eliminarSucursal(int idSucursal) throws RemoteException,SucursalException;
	
	SucursalDTO getSucursalById(int idSucursal) throws RemoteException,SucursalException;
	
	List<SucursalDTO> getSucursales() throws RemoteException,SucursalException;
	
	//ABM Rutas
	RutaDTO crearRuta(RutaDTO ruta) throws RemoteException,RutaException;

	List<RutaDTO> getRutas() throws RemoteException,RutaException;

	//ABM Roles empleado
	RolEmpleadoDTO crearRolEmpleado(RolEmpleadoDTO rolEmpleado) throws RemoteException,RolEmpleadoException;

	List<RolEmpleadoDTO> getRoles() throws RemoteException,RolEmpleadoException;

	//ABM Empleados
	List<EmpleadoDTO> getEmpleados()throws RemoteException,EmpleadoException;

	EmpleadoDTO crearEmpleado(EmpleadoDTO empleado)throws RemoteException,EmpleadoException;
	
	boolean existeEmpleado(String cuit) throws RemoteException,EmpleadoException;
	
	EmpleadoDTO obtenerEmpleado(String cuit) throws RemoteException,EmpleadoException;
	
	EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleado)throws RemoteException,EmpleadoException;
	
	boolean eliminarEmpleado(EmpleadoDTO empleado)throws RemoteException,EmpleadoException;
	
	//ABM Clientes Particulares
	
	//ABM Clientes Empresa
	
	//ABM Vehiculos
	
	//ABM Proveedores
}
