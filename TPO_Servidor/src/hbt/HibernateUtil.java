package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Camino;
import entities.Carga;
import entities.CategoriaFragilidad;
import entities.CategoriaTratamiento;
import entities.ClienteEmpresa;
import entities.ClienteParticular;
import entities.CuentaCorrienteEmpresa;
import entities.Empleado;
import entities.Envio;
import entities.EstadoEnvio;
import entities.EstadoViaje;
import entities.Factura;
import entities.ItemFactura;
import entities.ItemRemito;
import entities.Manifiesto;
import entities.Mantenimiento;
import entities.MovimientoEmpresa;
import entities.ProductoEmpresa;
import entities.Remito;
import entities.RolEmpleado;
import entities.Ruta;
import entities.Sucursal;
import entities.Vehiculo;
import entities.Viaje;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static{
		try{
       	 	AnnotationConfiguration config = new AnnotationConfiguration();
       	 	config.addAnnotatedClass(Carga.class);
       	 	config.addAnnotatedClass(CategoriaFragilidad.class);
       	 	config.addAnnotatedClass(CategoriaTratamiento.class);
       	 	config.addAnnotatedClass(Manifiesto.class);
       	 	config.addAnnotatedClass(Envio.class);
       	 	config.addAnnotatedClass(ClienteParticular.class);
       	 	config.addAnnotatedClass(ClienteEmpresa.class);
       	 	config.addAnnotatedClass(Sucursal.class);
       	 	config.addAnnotatedClass(EstadoEnvio.class);
       	 	config.addAnnotatedClass(Viaje.class);
       	 	config.addAnnotatedClass(RolEmpleado.class);
       	 	config.addAnnotatedClass(Vehiculo.class);
       	 	config.addAnnotatedClass(Empleado.class);
       	 	config.addAnnotatedClass(EstadoViaje.class);
       	 	config.addAnnotatedClass(Ruta.class);
       	 	config.addAnnotatedClass(Mantenimiento.class);
       	 	config.addAnnotatedClass(Factura.class);
       	 	config.addAnnotatedClass(ItemFactura.class);
       	 	config.addAnnotatedClass(Remito.class);
       	 	config.addAnnotatedClass(ItemRemito.class);
       	 	config.addAnnotatedClass(ProductoEmpresa.class);
       	 	config.addAnnotatedClass(Camino.class);
       	 	config.addAnnotatedClass(CuentaCorrienteEmpresa.class);
       	 	config.addAnnotatedClass(MovimientoEmpresa.class);
       	 	sessionFactory = config.buildSessionFactory();
       	 	
		}catch(Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
