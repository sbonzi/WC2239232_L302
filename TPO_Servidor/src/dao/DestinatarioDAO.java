package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.ClienteConverter;
import converters.PaisConverter;
import converters.ProvinciaConverter;
import dto.DestinatarioDTO;
import entities.Destinatario;
import hbt.HibernateUtil;

public class DestinatarioDAO {
	public static DestinatarioDAO instancia;
	
	private static SessionFactory sf = null;

	public static DestinatarioDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new DestinatarioDAO();
		} 
		return instancia;
	}

	/*PRUEBA*/
	public Destinatario crearDestinatario(DestinatarioDTO d){
		Session session = sf.openSession();
		session.beginTransaction();
		
		Destinatario destintario = new Destinatario(d.getNombre(),
													d.getDomicilio(),
													d.getCodigoPostal(),
													PaisConverter.paisToEntity(d.getPais()),
													ProvinciaConverter.provinciaToEntity(d.getProvincia()),
													d.getPiso(),
													d.getDepartamento(),
													d.getNroDocumento(),
													d.getPersonasAutorizadas(),
													ClienteConverter.clienteToEntity(d.getClienteRemitente()));
		
		
		session.save(destintario);
		
		session.getTransaction().commit();

		session.close();
		
		return destintario;
	}
}
