package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;


import dto.ParticularDTO;
import entities.ClienteParticular;
import hbt.HibernateUtil;

public class ClienteParticularDAO {
	public static ClienteParticularDAO instancia;
	
	private static SessionFactory sf = null;

	public static ClienteParticularDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ClienteParticularDAO();
		} 
		return instancia;
	}

	/*PRUEBA*/
	public ClienteParticular crearClienteParticular(ParticularDTO p){
		Session session = sf.openSession();
		session.beginTransaction();
		
		ClienteParticular particular = new ClienteParticular(p.getNumDoc(),p.getTipoDoc());
		
		particular.setEsParticular(true);
		particular.setNombre(p.getNombre());
		particular.setDomicilio(p.getDomicilio());
		
		
		session.save(particular);
		
		session.getTransaction().commit();

		session.close();
		
		return particular;
	}

	@SuppressWarnings("unchecked")
	public ClienteParticular getClienteParticular(int numDoc, char tipoDoc) {
		Session session = sf.openSession();
		List<ClienteParticular> list = session.createQuery("SELECT c FROM Cliente c WHERE esParticular = 1 AND c.numDoc = :numDoc").setParameter("numDoc",numDoc).list();
		session.close();
		
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}
}
