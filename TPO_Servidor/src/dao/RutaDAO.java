package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.SucursalConverter;
import dto.RutaDTO;
import entities.Ruta;
import hbt.HibernateUtil;

public class RutaDAO {
	public static RutaDAO instancia;
	
	private static SessionFactory sf = null;

	public static RutaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new RutaDAO();
		} 
		return instancia;
	}
	
	public Ruta crearRuta(RutaDTO r){
		Session session = sf.openSession();
		session.beginTransaction();
		
		Ruta ruta = new Ruta(r.getDuracionViaje(),
							 r.getCostoViaje(),
							 SucursalConverter.sucursalToEntity(r.getSucursalOrigen()),
							 SucursalConverter.sucursalToEntity(r.getSucursalDestino()));
		
		session.save(ruta);
		
		session.getTransaction().commit();

		session.close();
		
		return ruta;
	}

	public List<Ruta> getRutas() {
		Session session = sf.openSession();
		List<Ruta> list = session.createQuery("SELECT r FROM Ruta r").list();
		session.close();
		return list;
	}
}
