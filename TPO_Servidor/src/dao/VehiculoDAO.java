package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.Envio;
import entities.Vehiculo;
import hbt.HibernateUtil;

public class VehiculoDAO {
	public static VehiculoDAO instancia = null;
	private static SessionFactory sf = null;

	public static VehiculoDAO getInstancia() {
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new VehiculoDAO();
		} 
		return instancia;
	}

	public List<Vehiculo> getVehiculosDisponibles() {
		Session session = sf.openSession();
		List<Vehiculo> list = session.createQuery("SELECT v "
												+ "	FROM Vehiculo v "
												+ " WHERE habilitadoParaUtilizar = 1").list();
		session.close();
		return list;
	}
}
