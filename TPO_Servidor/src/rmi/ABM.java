package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.DestinatarioDTO;
import dto.EmpleadoDTO;
import dto.EmpresaSeguridadDTO;
import dto.ParticularDTO;
import dto.ProvinciaDTO;
import dto.EmpresaSeguroDTO;
import dto.EnvioDTO;
import dto.EstadoEnvioDTO;
import dto.PaisDTO;
import dto.RolEmpleadoDTO;
import dto.RutaDTO;
import dto.ServicioTercerizadoDTO;
import dto.SucursalDTO;
import dto.VehiculoDTO;
import exceptions.DestinatarioException;
import exceptions.EmpleadoException;
import exceptions.EmpresaSeguridadException;
import exceptions.ParticularException;
import exceptions.ProvinciaException;
import exceptions.EmpresaSeguroException;
import exceptions.EnvioException;
import exceptions.EstadoEnvioException;
import exceptions.MantenimientoException;
import exceptions.PaisException;
import exceptions.RolEmpleadoException;
import exceptions.RutaException;
import exceptions.ServicioTercerizadoException;
import exceptions.SucursalException;
import exceptions.VehiculoException;
import interfaz.IABM;
import srv.DestinatarioSRV;
import srv.EmpleadoSRV;
import srv.EmpresaSeguridadSRV;
import srv.EnvioSRV;
import srv.EstadoEnvioSRV;
import srv.PaisSRV;
import srv.ParticularSRV;
import srv.ProvinciaSRV;
import srv.RolEmpleadoSRV;
import srv.RutaSRV;
import srv.ServicioTercerizadoSRV;
import srv.SucursalSRV;
import srv.VehiculoSRV;

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
		return SucursalSRV.getSucursalById(idSucursal);
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

	@Override
	public boolean existeEmpleado(String cuit) throws RemoteException, EmpleadoException {
		return EmpleadoSRV.existeEmpleado(cuit);
	}

	@Override
	public EmpleadoDTO obtenerEmpleado(String cuit) throws RemoteException, EmpleadoException {
		return EmpleadoSRV.obtenerEmpleado(cuit);
	}

	@Override
	public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleado) throws RemoteException, EmpleadoException {
		return EmpleadoSRV.actualizarEmpleado(empleado);
	}

	@Override
	public boolean eliminarEmpleado(EmpleadoDTO empleado) throws RemoteException, EmpleadoException {
		return true;
	}

	@Override

	public ParticularDTO getClienteParticular(int dniCliente, char tipoDoc) throws RemoteException, ParticularException {
		return ParticularSRV.getClienteParticular(dniCliente, tipoDoc);
	}
	
	@Override
	public ParticularDTO crearClienteParticular(ParticularDTO clienteParticular) throws RemoteException, ParticularException {
		return ParticularSRV.crearParticular(clienteParticular);
	}

	@Override
	public List<EmpresaSeguroDTO> getListadoAseguradoras() throws RemoteException, EmpresaSeguroException {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public DestinatarioDTO crearDestinatario(DestinatarioDTO destinatario)
			throws RemoteException, DestinatarioException {
		return DestinatarioSRV.crearDestinatario(destinatario);
	}

	@Override
	public List<PaisDTO> getPaises() throws RemoteException, PaisException {
		return PaisSRV.getPaises();
	}

	@Override
	public List<ProvinciaDTO> getProvincias(PaisDTO pais) throws RemoteException, ProvinciaException {
		return ProvinciaSRV.getProvincias(pais);
	}

	@Override
	public PaisDTO getPais(int id) throws RemoteException, PaisException {
		return PaisSRV.getPais(id);
	}

	@Override
	public ProvinciaDTO getProvincia(int id) throws RemoteException, ProvinciaException {
		return ProvinciaSRV.getProvincia(id);
	}

	@Override
	public boolean guardarMantenimientoPorVehiculo(VehiculoDTO vehiculo)
			throws RemoteException, MantenimientoException {
		return VehiculoSRV.guardarMantenimientoPorVehiculo(vehiculo);
	}

	@Override
	public List<ServicioTercerizadoDTO> getListadoServiciosTercerizados()
			throws RemoteException, ServicioTercerizadoException {
		return ServicioTercerizadoSRV.getListadoServiciosTercerizados();
	}

	@Override
	public ServicioTercerizadoDTO actualizarServicioTercerizado(ServicioTercerizadoDTO st)
			throws RemoteException, ServicioTercerizadoException {
		return ServicioTercerizadoSRV.actualizarServicioTercerizado(st);
	}

	@Override
	public List<EmpresaSeguridadDTO> getListadoEmpresasSeguridad() throws RemoteException, EmpresaSeguridadException {
		return EmpresaSeguridadSRV.getListadoEmpresasSeguridad();
	}

	@Override
	public EmpresaSeguridadDTO actualizarEmpresasSeguridad(EmpresaSeguridadDTO empresaSeguridad)
			throws RemoteException, EmpresaSeguridadException {
		return EmpresaSeguridadSRV.actualizarEmpresaSeguridad(empresaSeguridad);
	}
	public List<EnvioDTO> getEnviosPorSucursalOrigen(SucursalDTO sucOrigen) throws RemoteException, EnvioException {
		return EnvioSRV.getEnviosPorSucursalOrigen(sucOrigen);
	}

	@Override
	public List<EnvioDTO> getEnviosPorSucursalDestinoEstado(SucursalDTO sucDestino, int estado)
			throws RemoteException, EnvioException {
		return EnvioSRV.getEnviosPorSucursalDestinoEstado(sucDestino, estado);
	}

	@Override
	public List<VehiculoDTO> getVehiculosDisponiblesPorSucursal(SucursalDTO sucursal)
			throws RemoteException, VehiculoException {
		return VehiculoSRV.getVehiculosDisponiblesPorSucursal(sucursal);
	}
	
	@Override
	public List<VehiculoDTO> getVehiculosPorSucursal(SucursalDTO sucursal)
			throws RemoteException, VehiculoException {
		return VehiculoSRV.getVehiculosPorSucursal(sucursal);
	}

	@Override
	public List<EstadoEnvioDTO> getEstadosEnvios() throws RemoteException, EstadoEnvioException {
		return EstadoEnvioSRV.getEstadosEnvio();
	}

	@Override
	public EstadoEnvioDTO getEstadoEnvio(int idEstadoEnvio) throws RemoteException, EstadoEnvioException {
		return EstadoEnvioSRV.getEstadoEnvioById(idEstadoEnvio);
	}

}
