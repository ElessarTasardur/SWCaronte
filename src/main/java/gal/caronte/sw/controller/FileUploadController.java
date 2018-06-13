package gal.caronte.sw.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadController {

	ResponseEntity<Resource> recuperarImaxe(short idEdificio, short idPoi, int idImaxe);
	
	Integer subirImaxe(MultipartFile file, short idEdificio, short idPoi, String nome, String descricion);
	
	void modificarDatosImaxe(short idImaxe, String nome, String descricion);
	
	boolean eliminarImaxe(short idImaxe);
	
}
