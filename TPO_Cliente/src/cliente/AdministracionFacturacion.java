package cliente;

import java.rmi.RemoteException;

import businessDelegate.BusinessDelegate;
import dto.EnvioDTO;
import dto.FacturaDTO;
import dto.RemitoDTO;
import exceptions.EnvioException;
import exceptions.FacturaException;
import exceptions.RemitoException;
import interfaz.INegocioFacturacion;

public class AdministracionFacturacion {
	INegocioFacturacion controladorFacturacion;
	
	public AdministracionFacturacion(EnvioDTO envio){
		try{
			RemitoDTO remito = new BusinessDelegate().getBusinessService().generarRemito(envio);
		
			System.out.println("RemitoDTO: " + remito);
			
		}catch(RemoteException | EnvioException | RemitoException e){
			e.printStackTrace();
		}
		
		try{				
			FacturaDTO factura = new BusinessDelegate().getBusinessService().generarFactura(envio);
			
			System.out.println("FacturaDTO: " + factura);
			
		}catch(RemoteException | EnvioException | FacturaException e){
			e.printStackTrace();
		}
	}
}
