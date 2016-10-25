package interfaz;

import java.rmi.Remote;

public interface ISistemaEnvios extends Remote,
										INegocioEnvio,
										INegocioViaje,
										INegocioFacturacion,
										IABM{

}
