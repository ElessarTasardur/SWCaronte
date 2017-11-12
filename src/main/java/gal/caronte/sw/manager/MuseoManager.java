package gal.caronte.sw.manager;

import java.util.List;

import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.puntointerese.PuntoInterese;

public interface MuseoManager {

	List<Edificio> getTodosEdificios();

	Edificio getEdificio(Short idEdificio);
	
	List<PuntoInterese> getPorIdEdificioExterno(Short idEdificioExterno);

}
