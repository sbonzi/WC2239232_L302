package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.EmpresaSeguridadDTO;
import entities.EmpresaSeguridad;
import hbt.HibernateUtil;

public class EmpresaSeguridadDAO {
	public static EmpresaSeguridadDAO instancia;
	
	private static SessionFactory sf = null;

	public static EmpresaSeguridadDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EmpresaSeguridadDAO();
		} 
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpresaSeguridad> getEmpresasSeguridad() {
		Session session = sf.openSession();
		List<EmpresaSeguridad> list = session.createQuery("SELECT e FROM EmpresaSeguridad e").list();
		session.close();
		return list;
	}
	
	public EmpresaSeguridad actualizarEmpresaSeguridad(EmpresaSeguridadDTO s) {
		Session session = sf.openSession();
				 
		EmpresaSeguridad es = new EmpresaSeguridad(s.getId(),
												   s.getNombre(),
												   s.getServicio(),
												   s.getTarifa());
		
		session.beginTransaction();
		
		session.merge(es);
		
		session.getTransaction().commit();

		session.close();
		
		return es;
	}

}
