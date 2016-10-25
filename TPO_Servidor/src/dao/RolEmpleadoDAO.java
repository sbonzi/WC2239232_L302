package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.RolEmpleadoDTO;
import entities.RolEmpleado;
import hbt.HibernateUtil;

public class RolEmpleadoDAO {
	public static RolEmpleadoDAO instancia;
	
	private static SessionFactory sf = null;

	public static RolEmpleadoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new RolEmpleadoDAO();
		} 
		return instancia;
	}

	public RolEmpleado crearRolEmpleado(RolEmpleadoDTO r){
		Session session = sf.openSession();
		session.beginTransaction();
		
		RolEmpleado rolEmpleado = new RolEmpleado(r.getDescripcion());
		
		session.save(rolEmpleado);
		
		session.getTransaction().commit();

		session.close();
		
		return rolEmpleado;
	}

	public List<RolEmpleado> getRoles() {
		Session session = sf.openSession();
		List<RolEmpleado> list = session.createQuery("SELECT r FROM RolEmpleado r").list();
		session.close();
		return list;
	}
}
