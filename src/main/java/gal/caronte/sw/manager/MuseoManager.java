package gal.caronte.sw.manager;

import java.util.List;

import gal.caronte.sw.modelo.edificio.Edificio;

public interface MuseoManager {

	List<Edificio> getTodosEdificios();

	Edificio getEdificio(Integer idEdificio);

}
