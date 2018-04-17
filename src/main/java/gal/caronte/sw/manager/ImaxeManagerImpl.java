package gal.caronte.sw.manager;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import gal.caronte.sw.modelo.imaxe.Imaxe;
import gal.caronte.sw.modelo.imaxe.ImaxeDao;
import gal.caronte.sw.util.ParametrosProperties;
import gal.caronte.sw.util.StringUtil;

@Service
public class ImaxeManagerImpl implements ImaxeManager {

	public static final Logger log = LoggerFactory.getLogger(ImaxeManagerImpl.class);
	
	@Autowired
	private ImaxeDao imaxeDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Integer store(MultipartFile multipartFile, short idEdificio, short idPoi, String nome, String descricion) {
		
		//Crear imaxe en BD
		Integer idImaxe = this.imaxeDao.engadir(new Imaxe(null, idPoi, nome, descricion));
		
		log.info(StringUtil.creaString("Nome orixinal: ", multipartFile.getOriginalFilename()));
		String[] particion = multipartFile.getOriginalFilename().split("\\.");
		String extension = particion[particion.length-1];
		
		//Comprobamos a ruta do edificio
		String ruta = StringUtil.creaString(ParametrosProperties.getRutaFicheiro(), idEdificio);
	    File file = new File(ruta);
	    if (!file.exists()) {
	    	file.mkdir();
	    }
	    
	    //Comprobamos a ruta do poi
	    ruta = StringUtil.creaString(ruta, StringUtil.BARRA_SEPARADORA, idPoi);
	    file = new File(ruta);
	    if (!file.exists()) {
	    	file.mkdir();
	    }
	    
	    //Creamos a imaxe
	    ruta = StringUtil.creaString(ruta, StringUtil.BARRA_SEPARADORA, idImaxe, ".", extension);
	    file = new File(ruta);
		try {
			multipartFile.transferTo(file);
		}
		catch (IllegalStateException | IOException e) {
			log.error("Non se puido gardar a imaxe", e);
			idImaxe = null;
			//TODO lanzar excepcion
		}
	    
		return idImaxe;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Resource loadAsResource(String filename, int idImaxe) {
		
		String ruta = StringUtil.creaString(ParametrosProperties.getRutaFicheiro(), filename);
		log.info(StringUtil.creaString("Ruta construida para recuperar a imaxe: ", ruta));
		
		File directorio = new File(ruta);
		File[] listaFicheiros = directorio.listFiles();
		
		Resource resource = null;
		String inicio = String.valueOf(idImaxe).concat(".");
		try {
			for (File file : listaFicheiros) {
				if (file.isFile()
						&& file.getName().startsWith(inicio)) {
					resource = new UrlResource(Paths.get(ruta.concat(file.getName())).toUri());
					break;
				}
			}
        }
		catch (MalformedURLException e) {
			log.error("Non se puido atopar a imaxe", e);
		}
		
		return resource;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void eliminarImaxe(short idImaxe) {
		this.imaxeDao.eliminar(idImaxe);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modificarDatosImaxe(Imaxe imaxe) {
		this.imaxeDao.modificar(imaxe);
	}

}
