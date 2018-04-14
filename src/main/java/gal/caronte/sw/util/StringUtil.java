package gal.caronte.sw.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

	public static final Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	public static final String BARRA_SEPARADORA = "/";
	public static final String COMA = ",";
	
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
	
	public static List<Short> convertirCSVListaShort(String csv) {
		List<Short> listaRetorno = new ArrayList<>();
		
		if (csv != null) {
			try {
				String[] cadeas = csv.split(COMA);
				for (String cadea : cadeas) {
					listaRetorno.add(Short.valueOf(cadea));
				}
			}
			catch (NumberFormatException e) {
				log.error(StringUtil.creaString("Produciuse un erro convertindo a cadea CSV ", csv, ": ", e.getMessage()), e);
			}
		}
		
		
		return listaRetorno;
	}
}
