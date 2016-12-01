package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.EstadoEnvio;
import hbt.HibernateUtil;

public class EstadoEnvioDAO {
	public static EstadoEnvioDAO instancia;
	
	private static SessionFactory sf = null;

	public static EstadoEnvioDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EstadoEnvioDAO();
		} 
		return instancia;
	}
	
	public List<EstadoEnvio> getEstadosEnvio() {
		Session session = sf.openSession();
		List<EstadoEnvio> list = session.createQuery("SELECT e FROM EstadoEnvio e").list();
		session.close();
		return list;
	}
	
	public EstadoEnvio getEstadoEnvioById(int idEstadoEnvio) {
		Session session = sf.openSession();
		List<EstadoEnvio> list = session.createQuery("SELECT e FROM EstadoEnvio e WHERE e.id = :id").setParameter("id", idEstadoEnvio).list();
		session.close();

		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}
}
