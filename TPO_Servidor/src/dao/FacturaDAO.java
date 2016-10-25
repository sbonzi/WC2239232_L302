package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.CargaConverter;
import dto.EnvioDTO;
import entities.Carga;
import entities.Factura;
import entities.ItemFactura;
import hbt.HibernateUtil;

public class FacturaDAO {
	public static FacturaDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static FacturaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new FacturaDAO();
		}
		return instancia;
	}
	
	public Factura generarFactura(EnvioDTO envio){
		Session session = sf.openSession();
		session.beginTransaction();

		//Creamos una instancia *Factura*
		Factura factura = new Factura();
		factura.setFecha(new Date());
		
		//Por cada carga generamos un *ItemFactura* y lo agregamos al listado
		List<ItemFactura> itemsFactura = new ArrayList<ItemFactura>();
		
		//Obtenemos cargas asociadas al envio	
		List<Carga> cargas = CargaConverter.cargasToEntity(envio.getCargas());
		
		for(Carga c:cargas){
			ItemFactura itemFactura = new ItemFactura();
			itemFactura.setFactura(factura);
			itemFactura.setCarga(c);
			
			//Asignamos id_ItemFactura a la *Carga*
			c.setItemFactura(itemFactura);
			
			//Asigno Id_Carga al *Manifiesto* incluido en *Carga*
			c.getManifiesto().setCarga(c);

			//Almacenamos el *ItemFactura* en el listado
			itemsFactura.add(itemFactura);
		}
			
		//Asociamos listado de *ItemFactura* a la instancia *Factura*
		factura.setItemsFactura(itemsFactura);
		
		//Persistimos *Factura* en la BD
		session.save(factura);
		
		//Commit de la transacción
		//session.flush();
		session.getTransaction().commit();
		
		session.close();
		
		return factura;
	}
	
}