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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import gal.caronte.sw.manager.ImaxeManager;
import gal.caronte.sw.modelo.imaxe.Imaxe;
import gal.caronte.sw.util.StringUtil;

@Controller
public class FileUploadControllerImpl implements FileUploadController {

	public static final Logger log = LoggerFactory.getLogger(FileUploadControllerImpl.class);
	
	@Autowired
	private ImaxeManager imaxeManager;
	
    @Override
	@GetMapping("/recuperar/{idEdificio}/{idPoi}/{idImaxe}")
    @ResponseBody
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
	@PostMapping("/subir/{idEdificio}/{idPoi}/{nome}/{descricion}")
    public Integer subirImaxe(@RequestParam MultipartFile file, @PathVariable short idEdificio, @PathVariable short idPoi, @PathVariable String nome, @PathVariable String descricion) {

        return this.imaxeManager.store(file, idEdificio, idPoi, nome, descricion);

    }
    
    @Override
    @PostMapping("/actualizar/{idImaxe}/{nome}/{descricion}")
	public void modificarDatosImaxe(@PathVariable short idImaxe, @PathVariable String nome, @PathVariable String descricion) {
		this.imaxeManager.modificarDatosImaxe(new Imaxe(idImaxe, null, nome, descricion));
	}

	@Override
	@DeleteMapping("/eliminar/{idImaxe}")
	public void eliminarImaxe(@PathVariable short idImaxe) {
		this.imaxeManager.eliminarImaxe(idImaxe);
	}

//    @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }
}
