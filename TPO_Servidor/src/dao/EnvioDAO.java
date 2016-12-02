package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.CargaConverter;
import converters.DestinatarioConverter;
import converters.SucursalConverter;
import dto.CargaDTO;
import dto.ClienteDTO;
import dto.DestinatarioDTO;
import dto.EnvioDTO;
import dto.EstadoEnvioDTO;
import dto.SucursalDTO;
import entities.Carga;
import entities.ClienteParticular;
import entities.Destinatario;
import entities.Envio;
import entities.EstadoEnvio;
import entities.Manifiesto;
import entities.Sucursal;
import hbt.HibernateUtil;


public class EnvioDAO {
	public static EnvioDAO instancia = null;
	private static SessionFactory sf = null;

	public static EnvioDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EnvioDAO();
		} 
		return instancia;
	}
	
	/**
	 * Gestiona el alta de un envio para un cliente y sus cargas
	 * @param cliente
	 * @param cargas
	 * @param sOrigen
	 * @param sDestino
	 * @return Envio
	 */
	public Envio gestionarEnvio(ClienteDTO cliente, List<CargaDTO> cargas, DestinatarioDTO destinatario, SucursalDTO sOrigen,SucursalDTO sDestino)
	{
		Session session = sf.openSession();
		
		ClienteParticular cp = null;
		
		//Verificamos si es particular o empresa
		if(cliente.getEsParticular()){
			cp = new ClienteParticular();
			cp.setNombre(cliente.getNombre());
			cp.setDomicilio(cliente.getDomicilio());
			cp.setId(cliente.getId());
		}
		
		//Irá manejando distintos estados (recibido,enDeposito,despachado,enViaje,etc)
		//Se realizó carga en BD, hay que hacer ABM de éstos valores
		//INSERT INTO [dbo].[EstadoEnvio] VALUES(1,'En recep',1);
		EstadoEnvio estadoEnvio	= new EstadoEnvio();
		estadoEnvio.setDescripcion("En recepcion");
		estadoEnvio.setId(1);
		
		Sucursal sucDestino = null;
		
		if (sDestino != null)
			sucDestino = SucursalConverter.sucursalToEntity(sDestino);
		
		session.beginTransaction();
		
		Destinatario dest = null; 
		//Guardamos el destinatario
		if (destinatario != null)
			dest = DestinatarioConverter.destinatarioToEntity(destinatario);
		
		session.save(dest);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		//Generamos nuevo envio
		Envio envio = new Envio(cp//cliente
								,(float)100.2//cobro
								,true//cobroOrigen
								,null//fechaMaxLlegada
								,true//retiroEnSucursal
								,sucDestino//sucursalDestino
								,SucursalConverter.sucursalToEntity(sOrigen)//sucursalOrigen
								,false//tercerizarEnvio
								,true//trajoCargaEnPersona
								,estadoEnvio//estadoEnvio
								,false//esClienteEmpresa
								,dest);
		
		
		
		//Persistimos objeto en BD
		session.save(envio);
		
		//Commit de la transacción
		//session.flush();
		session.getTransaction().commit();

		session.beginTransaction();

			//Asignamos el id_envio a la carga
			List<Carga> c = CargaConverter.cargasToEntity(cargas);
			for (Carga carga : c) {
				carga.setEnvio(envio);
				carga.setManifiesto(null);
				session.save(carga);
			}
		
		session.getTransaction().commit();
		
		//asignamos las cargas al envio
		envio.setCargas(c);
		
		session.beginTransaction();
		
			List<Carga> cManifiestos = CargaConverter.cargasToEntity(cargas);
		
			for(int j = 0;j<cManifiestos.size();j++)
			{
				Manifiesto m = cManifiestos.get(j).getManifiesto();
				m.setCarga(envio.getCargas().get(j));
				session.save(m);
				
				envio.getCargas().get(j).setManifiesto(m);
			}
		
		session.getTransaction().commit();
		session.close();
		return envio;
	}
	
	@SuppressWarnings("unchecked")
	public List<Envio> obtenerEnviosPorCliente(ClienteDTO cliente){
		Session session = sf.openSession();
		List<Envio> envios = session.createQuery(
				"select env from Envio env where env.Cliente = :idCliente")
				.setParameter("idCliente", cliente.getId())
				.list();
		session.close();
		return envios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Envio> obtenerEnviosPorSucursalOrigen(SucursalDTO sucOrigen){
		Session session = sf.openSession();
		List<Envio> envios = session.createQuery(
				"select e from Envio e "
				+ "JOIN e.sucursalOrigen s "
				+ "JOIN e.estadoEnvio v "
				+ "WHERE s.id = :idSucOrigen AND v.id = :idEstadoEnvio")
				.setParameter("idSucOrigen", sucOrigen.getNumero())
				.setParameter("idEstadoEnvio", 1)
				.list();
		session.close();
		return envios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Envio> obtenerEnviosPorSucursalDestinoEstado(SucursalDTO sucDestino, int estado){
		Session session = sf.openSession();
		List<Envio> envios = new ArrayList<Envio>();
		String query =  "select e from Envio e ";
		
		if (sucDestino != null || estado != 0)
		{
			if (sucDestino != null && estado == 0)
			{
			envios = session.createQuery(query 
					+ "JOIN e.sucursalDestino s "
					+ "WHERE s.id = :idSucDestino")
					.setParameter("idSucDestino", sucDestino.getNumero())
					.list();
			}
			else if (sucDestino == null && estado != 0)
				{
				envios = session.createQuery(query 
						+ "JOIN e.estadoEnvio s "
						+ "WHERE s.id = :idEstadoEnvio")
						.setParameter("idEstadoEnvio", estado)
						.list();
				}
			else
			{
				envios = session.createQuery(query
						+ "JOIN e.sucursalDestino s "
						+ "JOIN e.estadoEnvio v "
						+ "WHERE s.id = :idSucDestino and v.id = :idEstadoEnvio")
						.setParameter("idSucDestino", sucDestino.getNumero())
						.setParameter("idEstadoEnvio", estado)
						.list();
			}
		}
		else
			envios = session.createQuery(query).list();
			
		session.close();
		return envios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Carga> obtenerCargasPorEnvio(EnvioDTO envio){
		Session session = sf.openSession();
		List<Carga> cargas = session.createQuery(
				"select car from Carga car where car.envio = :idEnvio")
				.setParameter("idEnvio", envio.getIdEnvio())
				.list();
		session.close();
		return cargas;
	}
}
