package gal.caronte.sw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import gal.caronte.sw.custom.ComprobarLoginGoogleCustom;
import gal.caronte.sw.custom.GardarPercorridoParam;
import gal.caronte.sw.custom.PercorridoCustom;
import gal.caronte.sw.custom.PercorridoPuntoIntereseCustom;
import gal.caronte.sw.custom.PuntoIntereseCustom;
import gal.caronte.sw.modelo.contasitum.ContaSitum;
import gal.caronte.sw.modelo.edificio.Edificio;

public interface MuseoController {

	String test(HttpServletRequest request);
	
	List<Edificio> getEdificios();
	
	List<PuntoIntereseCustom> getPois(@PathVariable short idEdificioExterno);
	
	List<ContaSitum> getContasSitum();
	
	List<PercorridoCustom> getPercorridoEdificio(@PathVariable short idEdificio);
	
	List<PercorridoCustom> getPercorridoEdificioExterno(@PathVariable short idEdificioExterno);
	
	List<PercorridoPuntoIntereseCustom> getPuntosInteresePercorrido(@PathVariable short idPercorrido);
	
	Short gardarPercorrido(@RequestBody GardarPercorridoParam gardarPercorridoCustom);
	
	ComprobarLoginGoogleCustom comprobarUsuarioGoogle(@RequestBody String tokenId);
	
	Short gardarPuntoInterese(@RequestBody PuntoIntereseCustom poiCustom);
	
}
