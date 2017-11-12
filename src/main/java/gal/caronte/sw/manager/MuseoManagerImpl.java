package gal.caronte.sw.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.edificio.EdificioDao;
import gal.caronte.sw.modelo.puntointerese.PuntoInterese;
import gal.caronte.sw.modelo.puntointerese.PuntoIntereseDao;

@Service
public class MuseoManagerImpl implements MuseoManager {

	@Autowired
	private EdificioDao edificioDao;
	
	@Autowired
	private PuntoIntereseDao puntoIntereseDao;
	
	@Override
	public List<Edificio> getTodosEdificios() {
		return this.edificioDao.getTodos();
	}

	@Override
	public Edificio getEdificio(Short idEdificio) {
		return this.edificioDao.getEdificio(idEdificio);
	}

	@Override
	public List<PuntoInterese> getPorIdEdificioExterno(Short idEdificioExterno) {
		return this.puntoIntereseDao.getPorIdEdificioExterno(idEdificioExterno);
	}

}
