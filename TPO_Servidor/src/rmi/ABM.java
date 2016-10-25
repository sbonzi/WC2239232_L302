package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.EmpleadoDTO;
import dto.RolEmpleadoDTO;
import dto.RutaDTO;
import dto.SucursalDTO;
import exceptions.EmpleadoException;
import exceptions.RolEmpleadoException;
import exceptions.RutaException;
import exceptions.SucursalException;
import interfaz.IABM;
import srv.EmpleadoSRV;
import srv.RolEmpleadoSRV;
import srv.RutaSRV;
import srv.SucursalSRV;

public class ABM extends UnicastRemoteObject implements IABM{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1008609970298811391L;

	public ABM() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public SucursalDTO crearSucursal(SucursalDTO s) {
		return SucursalSRV.crearSucursal(s);
	}

	@Override
	public SucursalDTO modificarSucursal(int idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalDTO eliminarSucursal(int idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalDTO getSucursalById(int idSucursal) throws RemoteException, SucursalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SucursalDTO> getSucursales() throws RemoteException, SucursalException {
		return SucursalSRV.getSucursales();
	}

	@Override
	public RutaDTO crearRuta(RutaDTO ruta) throws RemoteException, RutaException {
		return RutaSRV.crearRuta(ruta);
	}

	@Override
	public List<RutaDTO> getRutas() throws RemoteException, RutaException {
		return RutaSRV.getRutas();
	}

	@Override
	public RolEmpleadoDTO crearRolEmpleado(RolEmpleadoDTO rolEmpleado) throws RemoteException, RolEmpleadoException {
		return RolEmpleadoSRV.crearRolEmpleado(rolEmpleado);
	}
	
	@Override
	public List<RolEmpleadoDTO> getRoles() throws RemoteException, RolEmpleadoException {
		return RolEmpleadoSRV.getRoles();
	}

	@Override
	public EmpleadoDTO crearEmpleado(EmpleadoDTO empleado) throws RemoteException, EmpleadoException {
		return EmpleadoSRV.crearEmpleado(empleado);
	}
	
	@Override
	public List<EmpleadoDTO> getEmpleados() throws RemoteException, EmpleadoException {
		return EmpleadoSRV.getEmpleados();
	}

}
