package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.ServicioTercerizadoDTO;
import entities.ServicioTercerizado;
import hbt.HibernateUtil;

public class ServicioTercerizadoDAO {
	public static ServicioTercerizadoDAO instancia;
	private static SessionFactory sf = null;
	
	public static ServicioTercerizadoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ServicioTercerizadoDAO();
		} 
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<ServicioTercerizado> getServicioTercerizados() {
		Session session = sf.openSession();
		List<ServicioTercerizado> list = session.createQuery("SELECT s FROM ServicioTercerizado s").list();
		session.close();
		return list;
	}
	
	public ServicioTercerizado actualizarServicioTercerizado(ServicioTercerizadoDTO s) {
		Session session = sf.openSession();
				 
		ServicioTercerizado st = new ServicioTercerizado(s.getId(),
														 s.getNombre(),
														 s.getDescripcion(),
														 s.getTiempoDeEntregaDias(),
														 s.getSeguridadDeCarga(),
														 s.getTarifa());
		session.beginTransaction();
		
		session.merge(st);
		
		session.getTransaction().commit();

		session.close();
		
		return st;
	}
}
