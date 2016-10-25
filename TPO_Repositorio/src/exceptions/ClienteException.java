package exceptions;

public class ClienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4677171667930606396L;
	
	public ClienteException(String mensaje){
		super(mensaje);
	}

}
