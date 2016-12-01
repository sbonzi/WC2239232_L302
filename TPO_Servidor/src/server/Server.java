package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import interfaz.ISistemaEnvios;
import rmi.SistemaEnviosRMI;
import util.Constantes;

/**
 * Disponibiliza un objeto remoto
 * @author Daniel PC
 *
 */
public class Server {

	public static void main(String[] args) {
		new Server();
		GenerarViaje.iniciar();
	}
	
	public Server(){
		iniciar();
	}
	
	private void iniciar() {
		ISistemaEnvios enviosRMI;
		String ubicacion = null;
		int puerto;
		
		try {
			enviosRMI 	= new SistemaEnviosRMI();
			puerto 		= Constantes.puerto_rmi_envios;
			ubicacion 	= Constantes.ubicacion_rmi_envios;
			LocateRegistry.createRegistry(puerto);
			Naming.bind(ubicacion, enviosRMI);
			System.out.println("*** Servicio disponible en " + ubicacion + "/" + puerto);
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}