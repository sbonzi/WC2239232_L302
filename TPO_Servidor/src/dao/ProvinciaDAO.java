package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.PaisDTO;
import dto.ProvinciaDTO;
import entities.Provincia;
import hbt.HibernateUtil;

public class ProvinciaDAO {
	public static ProvinciaDAO instancia;
	
	private static SessionFactory sf = null;

	public static ProvinciaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProvinciaDAO();
		} 
		return instancia;
	}

	public List<Provincia> getProvincias(PaisDTO pais) {
		Session session = sf.openSession();
		List<Provincia> list = session.createQuery("SELECT p FROM Provincia p WHERE p.habilitado = 'True' AND p.id_Pais = :idPais").setParameter("id", pais.getId()).list();
		session.close();
		return list;
	}
	
	public Provincia getProvincia(int id) {
		Session session = sf.openSession();
		List<Provincia> list = session.createQuery("SELECT p FROM Provincia p WHERE p.habilitado = 'True' AND p.id = :id").setParameter("id", id).list();
		session.close();

		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}
}