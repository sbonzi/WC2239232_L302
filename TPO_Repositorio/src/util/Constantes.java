package util;

import java.io.Serializable;

public class Constantes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5711850445798355838L;
	
	public static int puerto_rmi_envios 			= 1099;
	public static String ubicacion_rmi_envios 		= "//localhost/ServicioRemotoEnvios";
	public static int puerto_rmi_viajes 			= 1100;
	public static String ubicacion_rmi_viajes		= "//localhost/ServicioRemotoViajes";
	public static int puerto_rmi_facturacion 		= 1101;
	public static String ubicacion_rmi_facturacion	= "//localhost/ServicioRemotoFacturacion";
	public static int puerto_rmi_abm				= 1102;
	public static String ubicacion_rmi_abm			= "//localhost/ServicioRemotoABM";
	public static String tipo_control_viaje_salida	= "SALIDA";
	public static String tipo_control_viaje_llegada	= "LLEGADA";
	public static int tiempo_delay_envio_mje_xml	= 2000;
	
}
