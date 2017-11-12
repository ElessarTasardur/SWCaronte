package gal.caronte.sw.modelo.edificio;

import java.util.List;

public interface EdificioDao {

	List<Edificio> getTodos();
	
	Edificio getEdificio(Short idEdificio);
	
}
