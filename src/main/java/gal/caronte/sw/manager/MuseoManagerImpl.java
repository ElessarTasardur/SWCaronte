package gal.caronte.sw.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gal.caronte.sw.modelo.contasitum.ContaSitum;
import gal.caronte.sw.modelo.contasitum.ContaSitumDao;
import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.edificio.EdificioDao;
import gal.caronte.sw.modelo.percorrido.Percorrido;
import gal.caronte.sw.modelo.percorrido.PercorridoDao;
import gal.caronte.sw.modelo.percorridopuntointerese.PercorridoPuntoInterese;
import gal.caronte.sw.modelo.percorridopuntointerese.PercorridoPuntoIntereseDao;
import gal.caronte.sw.modelo.puntointerese.PuntoInterese;
import gal.caronte.sw.modelo.puntointerese.PuntoIntereseDao;

@Service
public class MuseoManagerImpl implements MuseoManager {

	@Autowired
	private ContaSitumDao contaSitumDao;
	
	@Autowired
	private EdificioDao edificioDao;
	
	@Autowired
	private PercorridoDao percorridoDao;
	
	@Autowired
	private PercorridoPuntoIntereseDao percorridoPuntoIntereseDao;
	
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

	@Override
	public List<ContaSitum> getListaContaSitum() {
		return this.contaSitumDao.getTodas();
	}

	@Override
	public List<PercorridoPuntoInterese> getListaPercorridoPuntoInterese(Short idPercorrido) {
		return this.percorridoPuntoIntereseDao.getListaPercorridoPuntoInteresePorIdPercorrido(idPercorrido);
	}

	@Override
	public List<Percorrido> getListaPercorridoPorIdEdificio(short idEdificio) {
		return this.percorridoDao.getListaPercorridoPorIdEdificio(idEdificio);
	}

}
