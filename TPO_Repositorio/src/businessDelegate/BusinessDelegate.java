package businessDelegate;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import dto.CargaDTO;
import dto.ClienteDTO;
import dto.DestinatarioDTO;
import dto.EmpleadoDTO;
import dto.EmpresaSeguridadDTO;
import dto.EmpresaSeguroDTO;
import dto.EnvioDTO;
import dto.EstadoEnvioDTO;
import dto.FacturaDTO;
import dto.PaisDTO;
import dto.ParticularDTO;
import dto.ProvinciaDTO;
import dto.RemitoDTO;
import dto.RolEmpleadoDTO;
import dto.RutaDTO;
import dto.ServicioTercerizadoDTO;
import dto.SucursalDTO;
import dto.VehiculoDTO;
import dto.ViajeDTO;
import exceptions.CargaException;
import exceptions.ClienteException;
import exceptions.DestinatarioException;
import exceptions.EmpleadoException;
import exceptions.EmpresaSeguridadException;
import exceptions.EmpresaSeguroException;
import exceptions.EnvioException;
import exceptions.FacturaException;
import exceptions.MantenimientoException;
import exceptions.PaisException;
import exceptions.ParticularException;
import exceptions.ProvinciaException;
import exceptions.RemitoException;
import exceptions.RolEmpleadoException;
import exceptions.RutaException;
import exceptions.ServicioTercerizadoException;
import exceptions.SucursalException;
import exceptions.VehiculoException;
import exceptions.ViajeException;
import exceptions.EstadoEnvioException;
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
	public EnvioDTO gestionarEnvio(ClienteDTO cliente, List<CargaDTO> cargas, DestinatarioDTO destinatario, SucursalDTO sOrigen, SucursalDTO sDestino)
			throws ClienteException, CargaException, RemoteException {
		return businessService.gestionarEnvio(cliente, cargas, destinatario, sOrigen, sDestino);
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

	@Override

	public ParticularDTO getClienteParticular(int dniCliente, char tipoDoc) throws RemoteException, ParticularException {
		return businessService.getClienteParticular(dniCliente, tipoDoc);
	}

	@Override
	public ParticularDTO crearClienteParticular(ParticularDTO clienteParticular) throws RemoteException, ParticularException {
		return businessService.crearClienteParticular(clienteParticular);
	}

	@Override
	public List<EmpresaSeguroDTO> getListadoAseguradoras() throws RemoteException, EmpresaSeguroException {
		return businessService.getListadoAseguradoras();
	}

	@Override
	public DestinatarioDTO crearDestinatario(DestinatarioDTO destinatario)
			throws RemoteException, DestinatarioException {
		return businessService.crearDestinatario(destinatario);
	}

	@Override
	public List<PaisDTO> getPaises() throws RemoteException, PaisException {
		return businessService.getPaises();
	}

	@Override
	public List<ProvinciaDTO> getProvincias(PaisDTO pais) throws RemoteException, ProvinciaException {
		return businessService.getProvincias(pais);
	}

	@Override
	public PaisDTO getPais(int id) throws RemoteException, PaisException {
		return businessService.getPais(id);
	}

	@Override
	public ProvinciaDTO getProvincia(int id) throws RemoteException, ProvinciaException {
		return businessService.getProvincia(id);
	}

	@Override
	public boolean guardarMantenimientoPorVehiculo(VehiculoDTO vehiculo)
			throws RemoteException, MantenimientoException {
		return businessService.guardarMantenimientoPorVehiculo(vehiculo);
	}

	@Override
	public List<ServicioTercerizadoDTO> getListadoServiciosTercerizados()
			throws RemoteException, ServicioTercerizadoException {
		return businessService.getListadoServiciosTercerizados();
	}

	@Override
	public ServicioTercerizadoDTO actualizarServicioTercerizado(ServicioTercerizadoDTO st)
			throws RemoteException, ServicioTercerizadoException {
		return businessService.actualizarServicioTercerizado(st);
	}

	@Override
	public List<EmpresaSeguridadDTO> getListadoEmpresasSeguridad() throws RemoteException, EmpresaSeguridadException {
		return businessService.getListadoEmpresasSeguridad();
	}

	@Override
	public EmpresaSeguridadDTO actualizarEmpresasSeguridad(EmpresaSeguridadDTO empresaSeguridad)
			throws RemoteException, EmpresaSeguridadException {
		return businessService.actualizarEmpresasSeguridad(empresaSeguridad);
	}

	@Override
	public List<EnvioDTO> getEnviosPorSucursalOrigen(SucursalDTO sucOrigen) throws RemoteException, EnvioException {
		return businessService.getEnviosPorSucursalOrigen(sucOrigen);
	}

	@Override
	public List<EnvioDTO> getEnviosPorSucursalDestinoEstado(SucursalDTO sucDestino, int estado)
			throws RemoteException, EnvioException {
		return businessService.getEnviosPorSucursalDestinoEstado(sucDestino, estado);
	}

	@Override
	public List<VehiculoDTO> getVehiculosDisponiblesPorSucursal(SucursalDTO sucursal)
			throws RemoteException, VehiculoException {
		return businessService.getVehiculosDisponiblesPorSucursal(sucursal);
	}

	@Override
	public List<EstadoEnvioDTO> getEstadosEnvios() throws RemoteException, EstadoEnvioException {
		return businessService.getEstadosEnvios();
	}

	@Override
	public EstadoEnvioDTO getEstadoEnvio(int idEstadoEnvio) throws RemoteException, EstadoEnvioException {
		return businessService.getEstadoEnvio(idEstadoEnvio);
	}

}
