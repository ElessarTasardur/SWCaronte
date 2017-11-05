package gal.caronte.sw.modelo.puntointerese;

import java.util.List;

public interface PuntoIntereseDao {

	PuntoInterese getPorId(Integer idPuntoInterese);
	
	List<PuntoInterese> getPorIdEdificio(Integer idEdificio);
	
	List<PuntoInterese> getPorIdPercorrido(Integer idPercorrido);
	
	Short engadir(PuntoInterese puntoInterese);

	void modificar(PuntoInterese puntoInterese);

	void eliminar(Short idPuntoInterese);
	
}
