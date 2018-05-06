package gal.caronte.sw.controller;

import java.util.List;

import gal.caronte.sw.custom.ComprobarLoginGoogleCustom;
import gal.caronte.sw.custom.GardarPercorridoParam;
import gal.caronte.sw.custom.ImaxeCustom;
import gal.caronte.sw.custom.PercorridoCustom;
import gal.caronte.sw.custom.PercorridoPuntoIntereseCustom;
import gal.caronte.sw.custom.PuntoIntereseCustom;
import gal.caronte.sw.modelo.contasitum.ContaSitum;
import gal.caronte.sw.modelo.edificio.Edificio;

public interface MuseoController {

	List<Edificio> getEdificios();
	
	List<PuntoIntereseCustom> getPois(short idEdificioExterno);
	
	List<ContaSitum> getContasSitum();
	
	List<ContaSitum> getContasSitum(short idUsuario);
	
	List<PercorridoCustom> getPercorridoEdificio(short idEdificio);
	
	List<PercorridoCustom> getPercorridoEdificioExterno(short idEdificioExterno);
	
	List<PercorridoPuntoIntereseCustom> getPuntosInteresePercorrido(short idPercorrido);
	
	Short gardarPercorrido(GardarPercorridoParam gardarPercorridoCustom);
	
	Boolean eliminarPercorrido(Short idPercorrido);
	
	ComprobarLoginGoogleCustom comprobarUsuarioGoogle(String tokenId);
	
	Short gardarPuntoInterese(PuntoIntereseCustom poiCustom);
	
	Boolean eliminarPuntoInterese(Short idPoi);
	
	List<ImaxeCustom> getListaImaxe(String listaIdImaxeCSV);
	
}
