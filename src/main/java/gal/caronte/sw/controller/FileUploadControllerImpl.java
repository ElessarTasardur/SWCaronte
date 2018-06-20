package gal.caronte.sw.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import gal.caronte.sw.manager.ImaxeManager;
import gal.caronte.sw.modelo.imaxe.Imaxe;
import gal.caronte.sw.util.StringUtil;

@RestController
@EnableWebMvc
public class FileUploadControllerImpl implements FileUploadController {

	public static final Logger log = LoggerFactory.getLogger(FileUploadControllerImpl.class);
	
	@Autowired
	private ImaxeManager imaxeManager;
	
    @Override
    @GetMapping("/recuperar/{idEdificio}/{idPoi}/{idImaxe}")
    public ResponseEntity<Resource> recuperarImaxe(@PathVariable short idEdificio, @PathVariable short idPoi, @PathVariable int idImaxe) {

    	ResponseEntity<Resource> retorno = null;
    	
    	String rutaImaxe = StringUtil.creaString(idEdificio, StringUtil.BARRA_SEPARADORA, idPoi, StringUtil.BARRA_SEPARADORA);
        Resource file = this.imaxeManager.loadAsResource(rutaImaxe, idImaxe);
        if (file == null) {
        	log.error(StringUtil.creaString("Non se atopou a imaxe ", idImaxe, " para o POI ", idPoi, " do edificio ", idEdificio));
        }
        else {
        	//MIME
        	String mime = "";
        	try {
        		Path source = Paths.get(rutaImaxe.concat(file.getFilename()));
        		mime = Files.probeContentType(source);
			}
        	catch (IOException e) {
				log.error("Erro ao recuperar o MIME", e);
			}
        	retorno = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, StringUtil.creaString("attachment; filename=\"", file.getFilename(), "\"")).header(HttpHeaders.CONTENT_TYPE, mime).body(file);
        }
        return retorno;
    }

    @Override
    @RequestMapping(value = "/subir", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer subirImaxe(@RequestParam MultipartFile file, @RequestParam short idEdificio, @RequestParam short idPoi, @RequestParam String nome, @RequestParam String descricion) {
        return this.imaxeManager.store(file, idEdificio, idPoi, nome, descricion);
    }
    
    @Override
    @PostMapping("/actualizar/{idImaxe}/{nome}/{descricion}")
	public void modificarDatosImaxe(@PathVariable short idImaxe, @PathVariable String nome, @PathVariable String descricion) {
		this.imaxeManager.modificarDatosImaxe(new Imaxe(idImaxe, null, nome, descricion));
	}

	@Override
	@RequestMapping(value = "/eliminar/{idImaxe}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean eliminarImaxe(@PathVariable short idImaxe) {
		
		log.info(StringUtil.creaString("Eliminar imaxe: ", idImaxe));
		
		boolean correcto = this.imaxeManager.eliminarImaxe(idImaxe);

		log.info(StringUtil.creaString("Imaxe ", idImaxe, " eliminada correctamente: ", correcto));
		
		return correcto;
		
	}

}
