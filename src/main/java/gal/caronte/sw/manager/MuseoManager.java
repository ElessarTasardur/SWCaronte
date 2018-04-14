package gal.caronte.sw.manager;

import java.util.List;

import gal.caronte.sw.modelo.contasitum.ContaSitum;
import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.imaxe.Imaxe;
import gal.caronte.sw.modelo.percorrido.Percorrido;
import gal.caronte.sw.modelo.percorridopuntointerese.PercorridoPuntoInterese;
import gal.caronte.sw.modelo.puntointerese.PuntoInterese;
import gal.caronte.sw.modelo.usuario.Usuario;
import gal.caronte.sw.modelo.usuarioedificio.UsuarioEdificio;

public interface MuseoManager {

	List<Edificio> getTodosEdificios();

	Edificio getEdificio(Short idEdificio);
	
	List<PuntoInterese> getPorIdEdificioExterno(Short idEdificioExterno);

	List<ContaSitum> getListaContaSitum();
	
	List<ContaSitum> getListaContaSitum(Short idUsuario);
	
	List<PercorridoPuntoInterese> getListaPercorridoPuntoInterese(Short idPercorrido);

	List<Percorrido> getListaPercorridoPorIdEdificio(short idEdificio);
	
	List<Percorrido> getListaPercorridoPorIdEdificioExterno(short idEdificioExterno);
	
	Short gardarPercorrido(Percorrido percorrido, List<PuntoInterese> listaIdPuntoInterese);
	
	void eliminarPercorrido(Short idPercorrido);
	
	List<UsuarioEdificio> getListaUsuarioEdificioPorIdUsuario(Short idUsuario);

	Usuario getUsuario(String email);
	
	Short gardarPuntoInterese(PuntoInterese puntoInterese);
	
	boolean eliminarPuntoInterese(Short idPoi);
	
	List<Imaxe> getListaImaxe(List<Short> listaIdImaxe);

}
