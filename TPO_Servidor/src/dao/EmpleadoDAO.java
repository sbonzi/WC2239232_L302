package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.RolEmpleadoConverter;
import converters.SucursalConverter;
import dto.EmpleadoDTO;
import entities.Empleado;
import hbt.HibernateUtil;

public class EmpleadoDAO {
	public static EmpleadoDAO instancia;
	
	private static SessionFactory sf = null;

	public static EmpleadoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EmpleadoDAO();
		} 
		return instancia;
	}

	/*PRUEBA*/
	public Empleado crearEmpleado(EmpleadoDTO e){
		Session session = sf.openSession();
		session.beginTransaction();
		
		Empleado empleado = new Empleado(e.getCuit(),
										e.getNombre());
		
		empleado.setPassword(e.getPassword());
		
		empleado.setRolEmpleado(RolEmpleadoConverter.rolEmpleadoToEntity(e.getRolEmpleado()));
				 
		empleado.setSucursal(SucursalConverter.sucursalToEntity(e.getSucursal()));
		
		session.save(empleado);
		
		session.getTransaction().commit();

		session.close();
		
		return empleado;
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> getEmpleados() {
		Session session = sf.openSession();
		List<Empleado> list = session.createQuery("SELECT e FROM Empleado e").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> getChoferesDisponibles() {
		Session session = sf.openSession();
		List<Empleado> list = session.createQuery("SELECT e "
												+ "FROM Empleado e "
												+ "JOIN e.rolEmpleado r "
												+ "WHERE r.descripcion = 'chofer'").list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public boolean existeEmpleado(String cuit) {
		boolean existeEmpleado 	= false;
		List<Empleado> empleado	= null;
		Session session = sf.openSession();
		empleado = session.createQuery("SELECT 1 "
						   			+ "FROM Empleado e "
						   			+ "WHERE e.cuit = :cuit").setParameter("cuit",cuit).list();
		session.close();

		if(empleado.size() > 0){
			existeEmpleado = true;
		}
		
		return existeEmpleado;
	}

	public Empleado obtenerEmpleado(String cuit) {
		Session session = sf.openSession();
		Empleado empleado = null;
		Query query = session.createQuery("SELECT e "
								  	    + "FROM Empleado e "
								  	    + "WHERE e.cuit = :cuit ").setString("cuit",cuit);
		empleado = (Empleado) query.uniqueResult();
		return empleado;
	}

	public Empleado actualizarEmpleado(EmpleadoDTO e) {
		Session session = sf.openSession();
	
		Empleado empleado = new Empleado(e.getCuit(),
										e.getNombre());
				 empleado.setId(e.getNumero());
		
		empleado.setRolEmpleado(RolEmpleadoConverter.rolEmpleadoToEntity(e.getRolEmpleado()));
		
		empleado.setSucursal(SucursalConverter.sucursalToEntity(e.getSucursal()));
		
		empleado.setPassword(e.getPassword());

		session.beginTransaction();
		
		session.merge(empleado);
		
		session.getTransaction().commit();

		session.close();
		
		return empleado;
	}

	public boolean eliminarEmpleado(EmpleadoDTO e) {
		Session session = sf.openSession();
		
		Empleado empleado = new Empleado(e.getCuit(),
										e.getNombre());
				 empleado.setId(e.getNumero());
		
		empleado.setRolEmpleado(RolEmpleadoConverter.rolEmpleadoToEntity(e.getRolEmpleado()));
		
		empleado.setSucursal(SucursalConverter.sucursalToEntity(e.getSucursal()));

		session.beginTransaction();
		
		session.delete(empleado);
		
		session.getTransaction().commit();

		session.close();
		
		return true;
	}
}
