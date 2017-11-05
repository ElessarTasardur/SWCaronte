package gal.caronte.sw.modelo.percorridopuntointerese;

public interface PercorridoPuntoIntereseDao {

	void engadir(PercorridoPuntoInterese percorridoPuntoInterese);

	void modificar(PercorridoPuntoInterese percorridoPuntoInterese);

	void eliminar(Short idPercorrido, Short idPuntoInterese);
	
}
