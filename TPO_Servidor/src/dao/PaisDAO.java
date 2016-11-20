package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.PaisDTO;
import entities.Pais;
import hbt.HibernateUtil;

public class PaisDAO {
	public static PaisDAO instancia;
	
	private static SessionFactory sf = null;

	public static PaisDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new PaisDAO();
		} 
		return instancia;
	}

	
	public List<Pais> getPaises() {
		Session session = sf.openSession();
		List<Pais> list = session.createQuery("SELECT p FROM Pais p WHERE p.habilitado = 'True'").list();
		session.close();
		return list;
	}
	
	public Pais getPais(int id) {
		Session session = sf.openSession();
		List<Pais> list = session.createQuery("SELECT p FROM Pais p WHERE p.habilitado = 'True' AND p.id = :id").setParameter("id", id).list();
		session.close();

		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}
}