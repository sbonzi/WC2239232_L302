package util;

public class Formato {
	public static boolean isNumeric(String numero){
	  try  {  
	    Double.parseDouble(numero);  
	  }catch(NumberFormatException nfe){  
	    return false;  
	  }  
	  return true;
	}
}
