package gal.caronte.sw.modelo.puntointerese;

import java.util.List;

public interface PuntoIntereseDao {

	PuntoInterese getPorId(Short idPuntoInterese);
	
	List<PuntoInterese> getPorIdEdificio(Short idEdificio);
	
	List<PuntoInterese> getPorIdEdificioExterno(Short idEdificioExterno);
	
	List<PuntoInterese> getPorIdPercorrido(Short idPercorrido);
	
	Short engadir(PuntoInterese puntoInterese);

	void modificar(PuntoInterese puntoInterese);

	boolean eliminar(Short idPuntoInterese);
	
}
