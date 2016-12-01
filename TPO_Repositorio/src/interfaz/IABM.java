package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
import exceptions.DestinatarioException;

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
	
	ParticularDTO getClienteParticular(int dniCliente, char tipoDoc)throws RemoteException,ParticularException;
	
	ParticularDTO crearClienteParticular(ParticularDTO clienteParticular) throws RemoteException,ParticularException;
	
	//ABM Clientes Empresa
	
	//ABM Vehiculos
	boolean guardarMantenimientoPorVehiculo(VehiculoDTO vehiculo) throws RemoteException,MantenimientoException;
	
	//ABM Proveedores
	List<ServicioTercerizadoDTO> getListadoServiciosTercerizados() throws RemoteException,ServicioTercerizadoException;
	
	ServicioTercerizadoDTO actualizarServicioTercerizado(ServicioTercerizadoDTO st) throws RemoteException,ServicioTercerizadoException;
	
	//Empresas aseguradoras
	List<EmpresaSeguroDTO> getListadoAseguradoras() throws RemoteException,EmpresaSeguroException;

	DestinatarioDTO crearDestinatario(DestinatarioDTO destinatario) throws RemoteException, DestinatarioException;
	
	List<PaisDTO> getPaises()throws RemoteException,PaisException;
	
	List<ProvinciaDTO> getProvincias(PaisDTO pais)throws RemoteException,ProvinciaException;
	
	PaisDTO getPais(int id)throws RemoteException,PaisException;
	
	ProvinciaDTO getProvincia(int id)throws RemoteException,ProvinciaException;
	

	//Empresa seguridad
	List<EmpresaSeguridadDTO> getListadoEmpresasSeguridad() throws RemoteException,EmpresaSeguridadException;
	
	EmpresaSeguridadDTO actualizarEmpresasSeguridad(EmpresaSeguridadDTO empresaSeguridad) throws RemoteException,EmpresaSeguridadException;
	

	//envios por suc origen
	List<EnvioDTO> getEnviosPorSucursalOrigen(SucursalDTO sucOrigen) throws RemoteException,EnvioException;
	
	//envios por suc destino y estado
	List<EnvioDTO> getEnviosPorSucursalDestinoEstado(SucursalDTO sucDestino, int estado) throws RemoteException,EnvioException;
	
	//vehiculos disponibles por sucursal
	List<VehiculoDTO> getVehiculosDisponiblesPorSucursal(SucursalDTO sucursal) throws RemoteException,VehiculoException;

	List<EstadoEnvioDTO> getEstadosEnvios() throws RemoteException,EstadoEnvioException;
	
	EstadoEnvioDTO getEstadoEnvio(int idEstadoEnvio)throws RemoteException,EstadoEnvioException;
	
}
