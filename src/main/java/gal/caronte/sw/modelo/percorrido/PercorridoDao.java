package gal.caronte.sw.modelo.percorrido;

import java.util.List;

public interface PercorridoDao {

	Percorrido getPercorrido(Short idPercorrido);

	List<Percorrido> getListaPercorridoPorIdEdificio(Short idEdificio);

	Short engadir(Percorrido percorrido);

	void modificar(Percorrido percorrido);

	void eliminar(Short idPercorrido);
	
}
