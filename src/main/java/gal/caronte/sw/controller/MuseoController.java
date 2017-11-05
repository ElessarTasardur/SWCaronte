package gal.caronte.sw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import gal.caronte.sw.manager.MuseoManager;
import gal.caronte.sw.modelo.edificio.Edificio;
import gal.caronte.sw.modelo.puntointerese.PuntoInterese;

@RestController
@RequestMapping(value = "/")
@Configuration
@EnableWebMvc
//@ComponentScan("gal.caronte.sw.controller")
public class MuseoController {

	public static final Logger log = LoggerFactory.getLogger(MuseoController.class);
	
	@Autowired
	private MuseoManager museoManager;
	
	@RequestMapping(value = "/edificios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Edificio> getEdificios() {
		List<Edificio> lista = this.museoManager.getTodosEdificios();
		
		return lista;
	}
	
	@RequestMapping(value = "/pois/{idEdificio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PuntoInterese> getPois(@PathVariable int idEdificio) {
		List<PuntoInterese> lista = this.museoManager.getPorIdEdificio(idEdificio);
		
		return lista;
	}
	
//	@RequestMapping(value = "/nha", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public String nha() {
//		log.info("nha");
//		return "nha";
//	}
	
}
