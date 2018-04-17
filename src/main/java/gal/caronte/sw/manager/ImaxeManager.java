package gal.caronte.sw.manager;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import gal.caronte.sw.modelo.imaxe.Imaxe;

public interface ImaxeManager {

	Integer store(MultipartFile file, short idEdificio, short idPoi, String nome, String descricion);

    Resource loadAsResource(String filename, int idImaxe);

	void eliminarImaxe(short idImaxe);

	void modificarDatosImaxe(Imaxe imaxe);

}
