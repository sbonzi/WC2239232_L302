package dao;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.EnvioConverter;
import converters.VehiculoConverter;
import dto.EmpleadoDTO;
import dto.EnvioDTO;
import dto.VehiculoDTO;
import entities.Envio;
import entities.EstadoViaje;
import entities.Vehiculo;
import entities.Viaje;
import hbt.HibernateUtil;

public class ViajeDAO {
	public static ViajeDAO instancia = null;
	private static SessionFactory sf = null;

	public static ViajeDAO getInstancia() {
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ViajeDAO();
		} 
		return instancia;
	}

	public List<Viaje> gestionarViajes(List<EmpleadoDTO> choferesDisponibles,
				  					  List<EnvioDTO> enviosPendientes,
				  					  List<VehiculoDTO> vehiculosDisponibles) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		List<Viaje> viajes = new ArrayList<Viaje>();
		AbstractMap<Integer,List<Envio>> enviosPorSucursal = new HashMap<>();

		System.out.println("enviosPendientes.size(): " + enviosPendientes.size());
		/**
		 * Se distribuyen los envios basados en la misma sucursal de origen 
		 */
		int nroSucursal = 0;
		for(EnvioDTO envio:enviosPendientes){
			nroSucursal = envio.getSucursalOrigen().getNumero();
			if(enviosPorSucursal.containsKey(nroSucursal)){
				//Obtenemos el listado de envios asociados a la sucursal
				List<Envio> envios = enviosPorSucursal.get(nroSucursal);
				envios.add(EnvioConverter.envioToEntity(envio));
				//Actualizamos el listado de envios asociados a la sucursal
				enviosPorSucursal.replace(nroSucursal, envios);
			}else{
				List<Envio> envios = new ArrayList<Envio>();
				envios.add(EnvioConverter.envioToEntity(envio));
				enviosPorSucursal.put(nroSucursal, envios);
			}
		}
		
		/**
		 * Los envios separados por sucursal de origen, se asignan a viajes
		 */
		System.out.println("enviosPorSucursal.size(): " + enviosPorSucursal.size());
		/*
		Iterator it = enviosPorSucursal.entrySet().iterator();
		while(it.hasNext()){
	        Map.Entry pair = (Map.Entry)it.next();
	        List<Envio> envios = (List<Envio>) pair.getValue();
	        System.out.println(pair.getKey() + " = " + EnvioConverter.enviosToDTO(envios));
	        it.remove();
		}
		*/
		
		/*
		Viaje viaje = new Viaje();
		viaje.setEnvios(enviosAsignados);
		viajes.add(viaje);
		session.save(viaje);
		session.getTransaction().commit();
		session.close();
		*/
		
		return viajes;
	}

	public List<Envio> getEnviosPendientes() {
		Session session = sf.openSession();
		List<Envio> list = session.createQuery("SELECT e "
											+ "	FROM Envio e "
											+ " WHERE estadoEnvio = 1").list();
		session.close();
		return list;
	}
	
	public Viaje crearViaje(List<EnvioDTO> envios,VehiculoDTO vehiculoDTO){
		Session session = sf.openSession();
		session.beginTransaction();
		
		EstadoViaje estadoViaje = new EstadoViaje();
		estadoViaje.setDescripcion("Saliendo de sucursal origen");
		estadoViaje.setHabilitado(true);
		estadoViaje.setId(1);

		Viaje viaje = new Viaje();
		viaje.setLatitud("0");
		viaje.setLongitud("0");
		viaje.setFechaSalida(new Date());
		viaje.setFechaLlegada(new Date());
		viaje.setEstadoViaje(estadoViaje);
		viaje.setVehiculoDesignado(VehiculoConverter.vehiculoToEntity(vehiculoDTO));
		
		session.save(viaje);
		
		session.getTransaction().commit();

		session.close();
		
		actualizarEstadoEnvios(viaje.getId(), envios);
		
		return viaje;
	}
	
	public void actualizarEstadoEnvios(int idViaje, List<EnvioDTO> envios){
		Session session = sf.openSession();
		for(EnvioDTO e:envios){
			session.beginTransaction();
			String hqlUpdate = "UPDATE Envio e "
							 + "SET e.estadoEnvio.id = :idEstadoEnvio "
							 + ",e.viaje.id = :idViaje "
							 + "WHERE e.idEnvio = :idEnvio ";
			
			session.createQuery(hqlUpdate)
				   .setInteger("idEnvio",e.getIdEnvio())
				   .setInteger("idViaje",idViaje)
				   .setInteger("idEstadoEnvio",3)
				   .executeUpdate();
			
			session.getTransaction().commit();
		}
		session.close();
	}
}