package util;

import java.io.File;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Cada vehiculo envia un mensaje en formato XML con los siguientes datos
 * - nro de vehiculo
 * - fecha y hora
 * - latitud y longitud 
 * @author Daniel PC
 *
 */
public class GenerarArchivoXML {
	
	public GenerarArchivoXML(int p_nroVehiculo,
							 Date p_fecha,
							 String p_latitud,
							 String p_longitud) {

		  try {

			DocumentBuilderFactory docFactory 	= DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder 			= docFactory.newDocumentBuilder();

			//Elementos raiz
			Document doc 		= docBuilder.newDocument();
			Element rootElement = doc.createElement("control_viaje");
			doc.appendChild(rootElement);

			Element vehiculo = doc.createElement("nro_vehiculo");
			rootElement.appendChild(vehiculo);

			Attr attr = doc.createAttribute("id");
			attr.setValue(Integer.toString(p_nroVehiculo));
			vehiculo.setAttributeNode(attr);
			
			Element fecha = doc.createElement("fecha");
			fecha.appendChild(doc.createTextNode(p_fecha.toString()));
			vehiculo.appendChild(fecha);
			
			Element latitud = doc.createElement("latitud");
			latitud.appendChild(doc.createTextNode(p_latitud));
			vehiculo.appendChild(latitud);
			
			Element longitud = doc.createElement("longitud");
			longitud.appendChild(doc.createTextNode(p_longitud));
			vehiculo.appendChild(longitud);

			//Escribe el contenido en eun archivo XML
			TransformerFactory transformerFactory 	= TransformerFactory.newInstance();
			Transformer transformer 				= transformerFactory.newTransformer();
			DOMSource source 						= new DOMSource(doc);
			//StreamResult result 					= new StreamResult(new File("C:\\Users\\Daniel PC\\Documents\\file.xml"));

			// Salida consola
			StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("Archivo XML guardado");

		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}
}
