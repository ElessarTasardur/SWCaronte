package gal.caronte.sw.manager;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gal.caronte.sw.modelo.contasitum.ContaSitum;
import gal.caronte.sw.modelo.contasitum.ContaSitumDao;
import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.edificio.EdificioDao;
import gal.caronte.sw.modelo.imaxe.Imaxe;
import gal.caronte.sw.modelo.imaxe.ImaxeDao;
import gal.caronte.sw.modelo.percorrido.Percorrido;
import gal.caronte.sw.modelo.percorrido.PercorridoDao;
import gal.caronte.sw.modelo.percorridopuntointerese.PercorridoPuntoInterese;
import gal.caronte.sw.modelo.percorridopuntointerese.PercorridoPuntoIntereseDao;
import gal.caronte.sw.modelo.puntointerese.PuntoInterese;
import gal.caronte.sw.modelo.puntointerese.PuntoIntereseDao;
import gal.caronte.sw.modelo.usuario.Usuario;
import gal.caronte.sw.modelo.usuario.UsuarioDao;
import gal.caronte.sw.modelo.usuarioedificio.UsuarioEdificio;
import gal.caronte.sw.modelo.usuarioedificio.UsuarioEdificioDao;
import gal.caronte.sw.util.StringUtil;

@Service
public class MuseoManagerImpl implements MuseoManager {

	public static final Logger log = LoggerFactory.getLogger(MuseoManagerImpl.class);
	
	@Autowired
	private ContaSitumDao contaSitumDao;
	
	@Autowired
	private EdificioDao edificioDao;
	
	@Autowired
	private ImaxeDao imaxeDao;
	
	@Autowired
	private PercorridoDao percorridoDao;
	
	@Autowired
	private PercorridoPuntoIntereseDao percorridoPuntoIntereseDao;
	
	@Autowired
	private PuntoIntereseDao puntoIntereseDao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private UsuarioEdificioDao usuarioEdificioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Edificio> getTodosEdificios() {
		return this.edificioDao.getTodos();
	}

	@Override
	@Transactional(readOnly = true)
	public Edificio getEdificio(Short idEdificio) {
		return this.edificioDao.getEdificio(idEdificio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PuntoInterese> getPorIdEdificioExterno(Short idEdificioExterno) {
		return this.puntoIntereseDao.getPorIdEdificioExterno(idEdificioExterno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ContaSitum> getListaContaSitum() {
		return this.contaSitumDao.getPublica();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ContaSitum> getListaContaSitum(Short idUsuario) {
		return this.contaSitumDao.getContaPorIdUsuario(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PercorridoPuntoInterese> getListaPercorridoPuntoInterese(Short idPercorrido) {
		return this.percorridoPuntoIntereseDao.getListaPercorridoPuntoInteresePorIdPercorrido(idPercorrido);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Percorrido> getListaPercorridoPorIdEdificio(short idEdificio) {
		return this.percorridoDao.getListaPercorridoPorIdEdificio(idEdificio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Percorrido> getListaPercorridoPorIdEdificioExterno(short idEdificioExterno) {
		return this.percorridoDao.getListaPercorridoPorIdEdificioExterno(idEdificioExterno);
	}

	@Override
	@Transactional
	public Short gardarPercorrido(Percorrido percorrido, List<PuntoInterese> listaPuntoInterese) {
		Short idPercorrido = percorrido.getIdPercorrido();
		
		//Crear puntos de interese que non existen
		for (PuntoInterese poi : listaPuntoInterese) {
			if (poi.getIdPuntoInterese() == null) {
				poi.setIdPuntoInterese(this.puntoIntereseDao.engadir(poi));
			}
		}
		
		//Se o percorrido xa existia, gardamos a modificacion
		if (idPercorrido != null) {
			this.percorridoDao.modificar(percorrido);
			
			//Se se envian puntos comprobamos as modificacions
			if (!listaPuntoInterese.isEmpty()) {
				List<PercorridoPuntoInterese> listaPuntoPrevio = this.percorridoPuntoIntereseDao.getListaPercorridoPuntoInteresePorIdPercorrido(idPercorrido);
				List<PercorridoPuntoInterese> listaPuntoEngadir = new ArrayList<>();
				
				short posicion = 1;
				PercorridoPuntoInterese ppi;
				for (PuntoInterese poi : listaPuntoInterese) {
					ppi = new PercorridoPuntoInterese(idPercorrido, poi.getIdPuntoInterese(), posicion);
					listaPuntoEngadir.add(ppi);
					posicion++;
				}
				
				//Lista de puntos a eliminar
				for (PercorridoPuntoInterese ppiEliminar : listaPuntoPrevio) {
					this.percorridoPuntoIntereseDao.eliminar(idPercorrido, ppiEliminar.getIdPuntoInterese());
				}
				
				//Lista de puntos a engadir
				for (PercorridoPuntoInterese ppiEngadir : listaPuntoEngadir) {
					this.percorridoPuntoIntereseDao.engadir(ppiEngadir);
				}
			}
			
		}
		//Se o percorrido non ten identificador, creamos un novo en BD
		else {
			idPercorrido = this.percorridoDao.engadir(percorrido);
			
			short posicion = 1;
			//Gardamos os puntos de interese
			for (PuntoInterese poi : listaPuntoInterese) {
				this.percorridoPuntoIntereseDao.engadir(new PercorridoPuntoInterese(idPercorrido, poi.getIdPuntoInterese(), posicion));
				posicion++;
			}
			
		}
		
		return idPercorrido;
	
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioEdificio> getListaUsuarioEdificioPorIdUsuario(Short idUsuario) {
		return this.usuarioEdificioDao.getPorIdUsuario(idUsuario);
	}

	@Override
	@Transactional
	public Usuario getUsuario(String email) {
		Usuario usuario = this.usuarioDao.getPorContaUsuario(email);
		if (usuario == null) {
			usuario = new Usuario(null, email);
			Short idUsuario = this.usuarioDao.engadir(usuario);
			usuario.setIdUsuario(idUsuario);
		}
		return usuario;
	}

	@Override
	@Transactional
	public Short gardarPuntoInterese(PuntoInterese puntoInterese) {
		Short idPuntoInterese = puntoInterese.getIdPuntoInterese();
		if (idPuntoInterese != null) {
			this.puntoIntereseDao.modificar(puntoInterese);
		}
		else {
			idPuntoInterese = this.puntoIntereseDao.engadir(puntoInterese);
		}
		return idPuntoInterese;
	}

	@Override
	@Transactional
	public void eliminarPercorrido(Short idPercorrido) {
		this.percorridoPuntoIntereseDao.eliminarPorIdPercorrido(idPercorrido);
		this.percorridoDao.eliminar(idPercorrido);
	}

	@Override
	@Transactional
	public boolean eliminarPuntoInterese(Short idPoi) {
		
		boolean retorno = false;
		if (this.percorridoPuntoIntereseDao.getNumeroPercorridoPorIdPuntoInterese(idPoi) == 0) {
			retorno = this.puntoIntereseDao.eliminar(idPoi);
		}
		else {
			log.info(StringUtil.creaString("Non se pode eliminar o punto de interese ", idPoi, " porque esta incluido nalgun percorrido "));
		}
		return retorno;
	}

	@Override
	public List<Imaxe> getListaImaxe(List<Short> listaIdImaxe) {
		List<Imaxe> listaImaxe = this.imaxeDao.getListaImaxePorListaIdImaxe(listaIdImaxe);
		log.info(StringUtil.creaString("Recuperadas as imaxes: ", listaImaxe));
		
		return listaImaxe;
	}
}
