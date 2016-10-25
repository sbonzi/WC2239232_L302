package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.SucursalDTO;
import entities.Sucursal;
import hbt.HibernateUtil;

public class SucursalDAO {
	public static SucursalDAO instancia;
	
	private static SessionFactory sf = null;

	public static SucursalDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new SucursalDAO();
		} 
		return instancia;
	}
	
	public Sucursal crearSucursal(SucursalDTO s){
		Session session = sf.openSession();
		session.beginTransaction();
		
		Sucursal sucursal = new Sucursal(s.getNombre(),
										 s.getDireccion(),
										 s.getLatitud(),
										 s.getLongitud());
		
		session.save(sucursal);
		
		session.getTransaction().commit();

		session.close();
		
		return sucursal;
	}

	public List<Sucursal> getSucursales() {
		Session session = sf.openSession();
		List<Sucursal> list = session.createQuery("SELECT s FROM Sucursal s").list();
		session.close();
		return list;
	}
}
