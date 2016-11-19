package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.EmpresaSeguro;
import hbt.HibernateUtil;

public class EmpresaSeguroDAO {
	public static EmpresaSeguroDAO instancia;
	public static SessionFactory sf;
	
	public static EmpresaSeguroDAO getInstancia(){
		if(instancia == null){
			instancia 	= new EmpresaSeguroDAO();
			sf 			= HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpresaSeguro> getListadoAseguradoras(){
		Session session = sf.openSession();
		List<EmpresaSeguro> listado = session.createQuery("SELECT e FROM EmpresaSeguro e").list();
		session.close();
		return listado;
	}
}
