package gal.caronte.sw.modelo.percorridopuntointerese;

import java.util.List;

public interface PercorridoPuntoIntereseDao {

	void engadir(PercorridoPuntoInterese percorridoPuntoInterese);

	void modificar(PercorridoPuntoInterese percorridoPuntoInterese);

	void eliminar(Short idPercorrido, Short idPuntoInterese);
	
	List<PercorridoPuntoInterese> getListaPercorridoPuntoInteresePorIdPercorrido(Short idPercorrido);
	
}
