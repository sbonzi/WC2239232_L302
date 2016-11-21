package dao;

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
import dto.SucursalDTO;
import entities.Carga;
import entities.ClienteParticular;
import entities.Envio;
import entities.EstadoEnvio;
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
		session.beginTransaction();
		
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

		//Generamos nuevo envio
		Envio envio = new Envio(cp//cliente
								,(float)100.2//cobro
								,true//cobroOrigen
								,new Date()//fechaMaxLlegada
								,true//retiroEnSucursal
								,sucDestino//sucursalDestino
								,SucursalConverter.sucursalToEntity(sOrigen)//sucursalOrigen
								,false//tercerizarEnvio
								,true//trajoCargaEnPersona
								,estadoEnvio//estadoEnvio
								,false//esClienteEmpresa
								,DestinatarioConverter.destinatarioToEntity(destinatario));
		
		//Asignamos el id_envio a la carga
		List<Carga> c = CargaConverter.cargasToEntity(cargas);
		for(int j = 0;j<c.size();j++){
			c.get(j).setEnvio(envio);
			
			//asigno id_Carga al manifiesto
			c.get(j).getManifiesto().setCarga(c.get(j));
		}
		
		//asignamos las cargas al envio
		envio.setCargas(c);
		
		//Persistimos objeto en BD
		session.save(envio);
		
		//Commit de la transacción
		//session.flush();
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
