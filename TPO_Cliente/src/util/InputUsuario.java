package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUsuario {
	
	public static String ingresoString(String mensaje) throws IOException{
		System.out.print(mensaje);
		BufferedReader buffer	=	new BufferedReader(new InputStreamReader(System.in));
		String input = buffer.readLine();
		return input;
	}
	
	public static float ingresoFloat(String mensaje) throws IOException{
		System.out.print(mensaje);
		BufferedReader buffer	=	new BufferedReader(new InputStreamReader(System.in));
		Float input = Float.parseFloat(buffer.readLine());
		return input;
	}
	
	public static int ingresoInt(String mensaje) throws IOException{
		System.out.print(mensaje);
		BufferedReader buffer	=	new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(buffer.readLine());
		return input;
	}
}
