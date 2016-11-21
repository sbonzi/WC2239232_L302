package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.MantenimientoConverter;
import dto.VehiculoDTO;
import entities.Envio;
import entities.Mantenimiento;
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

	@SuppressWarnings("unchecked")
	public List<Vehiculo> getVehiculosDisponibles() {
		Session session = sf.openSession();
		List<Vehiculo> list = session.createQuery("SELECT v "
												+ "	FROM Vehiculo v "
												+ " WHERE habilitadoParaUtilizar = 1").list();
		session.close();
		return list;
	}
	
	public boolean guardarMantenimientoPorVehiculo(VehiculoDTO vehiculo) {
		
		Vehiculo v = new Vehiculo(vehiculo.getAnio(),
								  vehiculo.isHabilitadoParaUtilizar(),
								  vehiculo.getKilometraje(),
								  vehiculo.getMarca(),
								  vehiculo.getModelo(),
								  vehiculo.getPatente(),
								  vehiculo.getPeso(),
								  vehiculo.getTara());
				 v.setId(vehiculo.getNumero());
		
		List<Mantenimiento> mantenimientos = MantenimientoConverter.mantenimientosToEntity(vehiculo.getMantenimientos());
		for(Mantenimiento m:mantenimientos){
			m.setVehiculo(v);
		}
		
		v.setMantenimientos(mantenimientos);

		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.merge(v);
		
		session.getTransaction().commit();

		session.close();
		
		return true;
	}
}
