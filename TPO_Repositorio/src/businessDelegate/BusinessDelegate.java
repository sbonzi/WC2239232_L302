package businessDelegate;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import dto.CargaDTO;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.EnvioDTO;
import dto.FacturaDTO;
import dto.RemitoDTO;
import dto.RolEmpleadoDTO;
import dto.RutaDTO;
import dto.SucursalDTO;
import dto.VehiculoDTO;
import dto.ViajeDTO;
import exceptions.CargaException;
import exceptions.ClienteException;
import exceptions.EmpleadoException;
import exceptions.EnvioException;
import exceptions.FacturaException;
import exceptions.RemitoException;
import exceptions.RolEmpleadoException;
import exceptions.RutaException;
import exceptions.SucursalException;
import exceptions.VehiculoException;
import exceptions.ViajeException;
import interfaz.ISistemaEnvios;
import util.Constantes;

public class BusinessDelegate implements ISistemaEnvios{
	
	private ISistemaEnvios businessService;
	
	public ISistemaEnvios getBusinessService(){
		return businessService;
	}
	
	public BusinessDelegate(){
		super();
		try{		
			this.businessService = (ISistemaEnvios) Naming.lookup(Constantes.ubicacion_rmi_envios);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public EnvioDTO gestionarEnvio(ClienteDTO cliente, List<CargaDTO> cargas, SucursalDTO sOrigen, SucursalDTO sDestino)
			throws ClienteException, CargaException, RemoteException {
		return businessService.gestionarEnvio(cliente, cargas, sOrigen, sDestino);
	}

	@Override
	public List<EnvioDTO> obtenerEnviosPorCliente(ClienteDTO cliente) throws ClienteException, RemoteException {
		return businessService.obtenerEnviosPorCliente(cliente);
	}

	@Override
	public List<CargaDTO> obtenerCargasPorEnvio(EnvioDTO envio) throws EnvioException, RemoteException {
		return businessService.obtenerCargasPorEnvio(envio);
	}

	@Override
	public List<ViajeDTO> gestionarViaje(List<EmpleadoDTO> choferesDisponibles, List<EnvioDTO> enviosPendientes,
			List<VehiculoDTO> vehiculosDisponibles)
			throws EmpleadoException, EnvioException, VehiculoException, RemoteException, ViajeException {
		return businessService.gestionarViaje(choferesDisponibles, enviosPendientes, vehiculosDisponibles);
	}

	@Override
	public List<EnvioDTO> getEnviosPendientes() throws EnvioException, RemoteException {
		return businessService.getEnviosPendientes();
	}

	@Override
	public List<VehiculoDTO> getVehiculosDisponibles() throws VehiculoException, RemoteException {
		return businessService.getVehiculosDisponibles();
	}

	@Override
	public List<EmpleadoDTO> getChoferesDisponibles() throws EmpleadoException, RemoteException {
		return businessService.getChoferesDisponibles();
	}

	@Override
	public List<RutaDTO> getRutasDisponibles() throws RutaException, RemoteException {
		return businessService.getRutasDisponibles();
	}

	@Override
	public FacturaDTO generarFactura(EnvioDTO envio) throws EnvioException, FacturaException, RemoteException {
		return businessService.generarFactura(envio);
	}

	@Override
	public List<FacturaDTO> obtenerFacturasPorCliente(ClienteDTO cliente)
			throws ClienteException, FacturaException, RemoteException {
		return businessService.obtenerFacturasPorCliente(cliente);
	}

	@Override
	public FacturaDTO obtenerUltimaFactura(ClienteDTO cliente)
			throws ClienteException, FacturaException, RemoteException {
		return businessService.obtenerUltimaFactura(cliente);
	}

	@Override
	public RemitoDTO generarRemito(EnvioDTO envio) throws EnvioException, RemitoException, RemoteException {
		return businessService.generarRemito(envio);
	}

	@Override
	public List<RemitoDTO> obtenerRemitosPorCliente(ClienteDTO cliente)
			throws ClienteException, RemitoException, RemoteException {
		return null;
	}

	@Override
	public RemitoDTO obtenerUltimoRemito(ClienteDTO cliente) throws ClienteException, RemitoException, RemoteException {
		return null;
	}

	@Override
	public SucursalDTO crearSucursal(SucursalDTO sucursal) throws RemoteException, SucursalException {
		return businessService.crearSucursal(sucursal);
	}

	@Override
	public SucursalDTO modificarSucursal(int idSucursal) throws RemoteException, SucursalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalDTO eliminarSucursal(int idSucursal) throws RemoteException, SucursalException {
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
		return businessService.getSucursales();
	}

	@Override
	public RutaDTO crearRuta(RutaDTO ruta) throws RemoteException, RutaException {
		return businessService.crearRuta(ruta);
	}

	@Override
	public List<RutaDTO> getRutas() throws RemoteException, RutaException {
		return businessService.getRutas();
	}

	@Override
	public RolEmpleadoDTO crearRolEmpleado(RolEmpleadoDTO rolEmpleado) throws RemoteException, RolEmpleadoException {
		return businessService.crearRolEmpleado(rolEmpleado);
	}

	@Override
	public List<RolEmpleadoDTO> getRoles() throws RemoteException, RolEmpleadoException {
		return businessService.getRoles();
	}

	@Override
	public List<EmpleadoDTO> getEmpleados() throws RemoteException, EmpleadoException {
		return businessService.getEmpleados();
	}

	@Override
	public EmpleadoDTO crearEmpleado(EmpleadoDTO empleado) throws RemoteException, EmpleadoException {
		return businessService.crearEmpleado(empleado);
	}

	@Override
	public boolean existeEmpleado(String cuit) throws RemoteException, EmpleadoException {
		return businessService.existeEmpleado(cuit);
	}

	@Override
	public EmpleadoDTO obtenerEmpleado(String cuit) throws RemoteException, EmpleadoException {
		return businessService.obtenerEmpleado(cuit);
	}

	@Override
	public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleado) throws RemoteException, EmpleadoException {
		return businessService.actualizarEmpleado(empleado);
	}

	@Override
	public boolean eliminarEmpleado(EmpleadoDTO empleado) throws RemoteException, EmpleadoException {
		return businessService.eliminarEmpleado(empleado);
	}


}
