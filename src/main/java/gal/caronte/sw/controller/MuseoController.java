package gal.caronte.sw.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import gal.caronte.sw.custom.GardarPercorridoParam;
import gal.caronte.sw.custom.PercorridoCustom;
import gal.caronte.sw.custom.PercorridoPuntoIntereseCustom;
import gal.caronte.sw.custom.PosicionCustom;
import gal.caronte.sw.custom.PuntoIntereseCustom;
import gal.caronte.sw.manager.MuseoManager;
import gal.caronte.sw.modelo.contasitum.ContaSitum;
import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.percorrido.Percorrido;
import gal.caronte.sw.modelo.percorridopuntointerese.PercorridoPuntoInterese;
import gal.caronte.sw.modelo.puntointerese.PuntoInterese;

@RestController
@RequestMapping(value = "/")
@Configuration
@EnableWebMvc
public class MuseoController {

	public static final Logger log = LoggerFactory.getLogger(MuseoController.class);
	
	@Autowired
	private MuseoManager museoManager;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String test(HttpServletRequest request) {
		
		String retorno = String.valueOf(request.getRemoteAddr());
		log.info("Direccion IP request: " + retorno);
		
		try {
			log.info("Direccion IP localhost: " + String.valueOf(InetAddress.getLocalHost()));
			retorno = retorno + " - " +String.valueOf(InetAddress.getLocalHost());
		}
		catch (UnknownHostException e) {
			log.error("Erro ao recuperar a direccion localhost", e);
		}
		
		return retorno;
	}
	
	@RequestMapping(value = "/edificios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Edificio> getEdificios() {
		List<Edificio> lista = this.museoManager.getTodosEdificios();
		
		return lista;
	}
	
	@RequestMapping(value = "/pois/{idEdificioExterno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PuntoIntereseCustom> getPois(@PathVariable short idEdificioExterno) {
		List<PuntoInterese> lista = this.museoManager.getPorIdEdificioExterno(idEdificioExterno);
		
		return convertirPuntoInteresePuntoIntereseCustom(lista);
		
	}
	
	private static List<PuntoIntereseCustom> convertirPuntoInteresePuntoIntereseCustom(List<PuntoInterese> lista) {
		
		List<PuntoIntereseCustom> listaPIC = new ArrayList<>();
		
		if (lista != null) {
			for (PuntoInterese poi : lista) {
				listaPIC.add(new PuntoIntereseCustom(poi.getIdPuntoInterese(), poi.getNome(), poi.getDescricion(),
						new PosicionCustom(poi.getIdEdificio(), poi.getIdPlanta(), poi.getNivel(), poi.getLatitude(), poi.getLonxitude())));
			}
		}
		
		return listaPIC;
	}
	
	private static List<PuntoInterese> convertirPuntoIntereseCustomPuntoInterese(List<PuntoIntereseCustom> lista) {
		
		List<PuntoInterese> listaPIC = new ArrayList<>();
		
		if (lista != null) {
			for (PuntoIntereseCustom poi : lista) {
				PosicionCustom posicion = poi.getPosicion();
				listaPIC.add(new PuntoInterese(poi.getIdPuntoInterese(), poi.getNome(), poi.getDescricion(), posicion.getIdEdificio(), posicion.getIdPlanta(), posicion.getNivel(), posicion.getLatitude(), posicion.getLonxitude()));
			}
		}
		
		return listaPIC;
	}

	@RequestMapping(value = "/contas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ContaSitum> getContasSitum() {
		List<ContaSitum> lista = this.museoManager.getListaContaSitum();
		
		return lista;
	}
	
	@RequestMapping(value = "/percorridos/{idEdificio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PercorridoCustom> getPercorridoEdificio(@PathVariable short idEdificio) {
		List<Percorrido> lista = this.museoManager.getListaPercorridoPorIdEdificio(idEdificio);
		
		return convertirPercorridoPercorridoCustom(lista);
	}
	
	@RequestMapping(value = "/percorridosidexterno/{idEdificioExterno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PercorridoCustom> getPercorridoEdificioExterno(@PathVariable short idEdificioExterno) {
		
		List<Percorrido> lista = this.museoManager.getListaPercorridoPorIdEdificioExterno(idEdificioExterno);
		
		return convertirPercorridoPercorridoCustom(lista);
	}
	
	private static List<PercorridoCustom> convertirPercorridoPercorridoCustom(List<Percorrido> lista) {
		
		List<PercorridoCustom> listaPC = new ArrayList<>();
		
		if (lista != null) {
			for (Percorrido percorrido : lista) {
				listaPC.add(new PercorridoCustom(percorrido.getIdPercorrido(), percorrido.getNome(), percorrido.getDescricion(), percorrido.getIdEdificio()));
			}
		}
		
		return listaPC;
	}

	@RequestMapping(value = "/ppi/{idPercorrido}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PercorridoPuntoIntereseCustom> getPuntosInteresePercorrido(@PathVariable short idPercorrido) {
		List<PercorridoPuntoInterese> lista = this.museoManager.getListaPercorridoPuntoInterese(idPercorrido);
		
		return convertirPPIPPIC(lista);
	}
	
	private static List<PercorridoPuntoIntereseCustom> convertirPPIPPIC(List<PercorridoPuntoInterese> lista) {
		
		List<PercorridoPuntoIntereseCustom> listaPPIC = new ArrayList<>();
		
		if (lista != null) {
			for (PercorridoPuntoInterese ppi : lista) {
				listaPPIC.add(new PercorridoPuntoIntereseCustom(ppi.getIdPercorrido(), ppi.getIdPuntoInterese(), ppi.getPosicion()));
			}
		}
		
		return listaPPIC;
	}
	
	@RequestMapping(value = "/percorrido/gardar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Short gardarPercorrido(@RequestBody GardarPercorridoParam gardarPercorridoCustom) {
		
		log.info("Gardar percorrido: " + gardarPercorridoCustom);
		PercorridoCustom percorridoCustom = gardarPercorridoCustom.getPercorrido();
		Percorrido percorrido = new Percorrido(percorridoCustom.getIdPercorrido(), percorridoCustom.getNome(), percorridoCustom.getDescricion(), percorridoCustom.getIdEdificio());
		
		List<PuntoInterese> listaPoi = convertirPuntoIntereseCustomPuntoInterese(gardarPercorridoCustom.getListaPoi());
		
		Short idPercorrido = this.museoManager.gardarPercorrido(percorrido, listaPoi);
		
		log.info("Identificador percorrido gardado: " + idPercorrido);
		
		return idPercorrido;
	}
	
}
