package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.CargaConverter;
import dto.EnvioDTO;
import entities.Carga;
import entities.ItemRemito;
import entities.Remito;
import hbt.HibernateUtil;
/**
 * 
 * @author lvommaro
 *
 */
public class RemitoDAO {
	public static RemitoDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static RemitoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new RemitoDAO();
		}
		return instancia;
	}
	
	public Remito generarRemito(EnvioDTO envio){
		Session session = sf.openSession();
		session.beginTransaction();

		//Creamos una instancia *Remito*
		Remito remito = new Remito();
		remito.setFecha(new Date());
		
		//Por cada carga generamos un *ItemRemito* y lo agregamos al listado
		List<ItemRemito> itemsRemito = new ArrayList<ItemRemito>();
		
		//Obtenemos cargas asociadas al envio	
		List<Carga> cargas = CargaConverter.cargasToEntity(envio.getCargas());
		
		for(Carga c:cargas){
			ItemRemito itemRemito = new ItemRemito();
			itemRemito.setRemito(remito);
			itemRemito.setCarga(c);
			
			//Asignamos id_ItemRemito a la *Carga*
			c.setItemRemito(itemRemito);
			
			//Asigno Id_Carga al *Manifiesto* incluido en *Carga*
			c.getManifiesto().setCarga(c);

			//Almacenamos el *ItemRemito* en el listado
			itemsRemito.add(itemRemito);
		}
			
		//Asociamos listado de *ItemRemito* a la instancia *Remito*
		remito.setItemsRemito(itemsRemito);
		
		//Persistimos *Remito* en la BD
		session.save(remito);
		
		//Commit de la transacción
		//session.flush();
		session.getTransaction().commit();
		
		session.close();
		
		return remito;
	}
}
