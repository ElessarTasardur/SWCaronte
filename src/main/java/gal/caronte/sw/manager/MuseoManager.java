package gal.caronte.sw.manager;

import java.util.List;

import gal.caronte.sw.modelo.contasitum.ContaSitum;
import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.percorridopuntointerese.PercorridoPuntoInterese;
import gal.caronte.sw.modelo.puntointerese.PuntoInterese;

public interface MuseoManager {

	List<Edificio> getTodosEdificios();

	Edificio getEdificio(Short idEdificio);
	
	List<PuntoInterese> getPorIdEdificioExterno(Short idEdificioExterno);

	List<ContaSitum> getListaContaSitum();
	
	List<PercorridoPuntoInterese> getListaPercorridoPuntoInterese(Short idPercorrido);

}
