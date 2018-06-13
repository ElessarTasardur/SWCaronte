package gal.caronte.sw.modelo.imaxe;

import java.util.List;

public interface ImaxeDao {

	int engadir(Imaxe imaxe);

	void modificar(Imaxe imaxe);

	boolean eliminar(Short idImaxe);
	
	void eliminarPorIdPuntoInterese(Short idPuntoInterese);
	
	List<Imaxe> getListaImaxePorIdPuntoInterese(Short idPuntoInterese);
	
	List<Imaxe> getListaImaxePorListaIdImaxe(List<Short> listaIdImaxe);
	
}
