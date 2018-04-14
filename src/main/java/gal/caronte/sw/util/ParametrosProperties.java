package gal.caronte.sw.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gal.caronte.sw.manager.MuseoManagerImpl;

public class ParametrosProperties {

	public static final Logger log = LoggerFactory.getLogger(MuseoManagerImpl.class);
	
	private static Properties prop = new Properties();
	
	static {
		
		try (InputStream input = ParametrosProperties.class.getClassLoader().getResourceAsStream("parametros.properties")) {
			prop.load(input);
		}
		catch (IOException e) {
			log.error("Erro cargando o ficheiro de propiedades: ", e.getMessage());
		}
	}
	
	private static final String RUTA_FICHEIRO = "rutaFicheiro";
	
	
	public static String getRutaFicheiro() {
		return (String) prop.get(RUTA_FICHEIRO);
	}
	
}
