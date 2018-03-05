package gal.caronte.sw.util;

public class StringUtil {

	public static StringBuilder creaStringBuilder(Object... textos) {
		StringBuilder mensaje = new StringBuilder();
		for (Object texto : textos) {
			mensaje.append(String.valueOf(texto));
		}
		return mensaje;
	}

	public static String creaString(Object... textos) {
		return creaStringBuilder(textos).toString();
	}
	
}
