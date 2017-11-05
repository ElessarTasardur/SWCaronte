package gal.caronte.sw.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.edificio.EdificioDao;

@Service
public class MuseoManagerImpl implements MuseoManager {

	@Autowired
	private EdificioDao edificioDao;
	
	@Override
	public List<Edificio> getTodosEdificios() {
		return this.edificioDao.getTodos();
	}

	@Override
	public Edificio getEdificio(Integer idEdificio) {
		return this.edificioDao.getEdificio(idEdificio);
	}

}
