package gal.caronte.sw.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
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

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import gal.caronte.sw.custom.ComprobarLoginGoogleCustom;
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
import gal.caronte.sw.modelo.usuario.Usuario;
import gal.caronte.sw.modelo.usuarioedificio.UsuarioEdificio;
import gal.caronte.sw.util.StringUtil;

@RestController
@RequestMapping(value = "/")
@Configuration
@EnableWebMvc
public class MuseoControllerImpl implements MuseoController {

	public static final Logger log = LoggerFactory.getLogger(MuseoControllerImpl.class);

	@Autowired
	private MuseoManager museoManager;

	@Override
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String test(HttpServletRequest request) {

		String retorno = String.valueOf(request.getRemoteAddr());
		log.info("Direccion IP request: " + retorno);

		try {
			log.info("Direccion IP localhost: " + String.valueOf(InetAddress.getLocalHost()));
			retorno = retorno + " - " + String.valueOf(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			log.error("Erro ao recuperar a direccion localhost", e);
		}

		return retorno;
	}

	@Override
	@RequestMapping(value = "/edificios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Edificio> getEdificios() {
		List<Edificio> lista = this.museoManager.getTodosEdificios();

		log.info(StringUtil.creaString("Recuperados ", lista.size(), " edificios"));
		
		return lista;
	}

	@Override
	@RequestMapping(value = "/pois/{idEdificioExterno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PuntoIntereseCustom> getPois(@PathVariable short idEdificioExterno) {
		List<PuntoInterese> lista = this.museoManager.getPorIdEdificioExterno(idEdificioExterno);

		log.info(StringUtil.creaString("Recuperados ", lista.size(), " POIs do edificio con id externo ", idEdificioExterno));
		
		return convertirPuntoInteresePuntoIntereseCustom(lista);
	}

	private static List<PuntoIntereseCustom> convertirPuntoInteresePuntoIntereseCustom(List<PuntoInterese> lista) {

		List<PuntoIntereseCustom> listaPIC = new ArrayList<>();

		if (lista != null) {
			for (PuntoInterese poi : lista) {
				listaPIC.add(new PuntoIntereseCustom(poi.getIdPuntoInterese(), poi.getNome(), poi.getDescricion(),
						new PosicionCustom(poi.getIdEdificio(), poi.getIdPlanta(), poi.getNivel(), poi.getLatitude(),
								poi.getLonxitude()), StringUtil.convertirCSVListaInteger(poi.getListaIdImaxe())));
			}
		}

		return listaPIC;
	}

	private static List<PuntoInterese> convertirPuntoIntereseCustomPuntoInterese(List<PuntoIntereseCustom> lista) {

		List<PuntoInterese> listaPIC = new ArrayList<>();

		if (lista != null) {
			for (PuntoIntereseCustom poi : lista) {
				listaPIC.add(convertirPuntoIntereseCustomPuntoInterese(poi));
			}
		}

		return listaPIC;
	}
	
	private static PuntoInterese convertirPuntoIntereseCustomPuntoInterese(PuntoIntereseCustom poiCustom) {
		PuntoInterese poi = null;
		if (poiCustom != null) {
			PosicionCustom posicion = poiCustom.getPosicion();
			poi = new PuntoInterese(poiCustom.getIdPuntoInterese(), poiCustom.getNome(), poiCustom.getDescricion(),
					posicion.getIdEdificio(), posicion.getIdPlanta(), posicion.getNivel(), posicion.getLatitude(),
					posicion.getLonxitude(), null);
		}
		return poi;
	}

	@Override
	@RequestMapping(value = "/contas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ContaSitum> getContasSitum() {
		List<ContaSitum> lista = this.museoManager.getListaContaSitum(null);
		
		log.info(StringUtil.creaString("Recuperadas ", lista.size(), " contas de Situm"));

		return lista;
	}
	
	@Override
	@RequestMapping(value = "/contas/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ContaSitum> getContasSitum(@PathVariable short idUsuario) {
		List<ContaSitum> lista = this.museoManager.getListaContaSitum(idUsuario);
		
		log.info(StringUtil.creaString("Recuperadas ", lista.size(), " contas de Situm para o usuario con id ", idUsuario));

		return lista;
	}

	@Override
	@RequestMapping(value = "/percorridos/{idEdificio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PercorridoCustom> getPercorridoEdificio(@PathVariable short idEdificio) {
		List<Percorrido> lista = this.museoManager.getListaPercorridoPorIdEdificio(idEdificio);

		log.info(StringUtil.creaString("Recuperados ", lista.size(), " percorridos do edificio con id ", idEdificio));
		
		return convertirPercorridoPercorridoCustom(lista);
	}

	@Override
	@RequestMapping(value = "/percorridosidexterno/{idEdificioExterno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PercorridoCustom> getPercorridoEdificioExterno(@PathVariable short idEdificioExterno) {
		List<Percorrido> lista = this.museoManager.getListaPercorridoPorIdEdificioExterno(idEdificioExterno);

		log.info(StringUtil.creaString("Recuperados ", lista.size(), " percorridos do edificio con id externo ", idEdificioExterno));
		
		return convertirPercorridoPercorridoCustom(lista);
	}

	private static List<PercorridoCustom> convertirPercorridoPercorridoCustom(List<Percorrido> lista) {

		List<PercorridoCustom> listaPC = new ArrayList<>();

		if (lista != null) {
			for (Percorrido percorrido : lista) {
				listaPC.add(new PercorridoCustom(percorrido.getIdPercorrido(), percorrido.getNome(),
						percorrido.getDescricion(), percorrido.getIdEdificio()));
			}
		}

		return listaPC;
	}

	@Override
	@RequestMapping(value = "/ppi/{idPercorrido}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PercorridoPuntoIntereseCustom> getPuntosInteresePercorrido(@PathVariable short idPercorrido) {
		List<PercorridoPuntoInterese> lista = this.museoManager.getListaPercorridoPuntoInterese(idPercorrido);

		log.info(StringUtil.creaString("Recuperados os ", lista.size(), " POIs do percorrido: ", idPercorrido));
		
		return convertirPPIPPIC(lista);
	}

	private static List<PercorridoPuntoIntereseCustom> convertirPPIPPIC(List<PercorridoPuntoInterese> lista) {

		List<PercorridoPuntoIntereseCustom> listaPPIC = new ArrayList<>();

		if (lista != null) {
			for (PercorridoPuntoInterese ppi : lista) {
				listaPPIC.add(new PercorridoPuntoIntereseCustom(ppi.getIdPercorrido(), ppi.getIdPuntoInterese(),
						ppi.getPosicion()));
			}
		}

		return listaPPIC;
	}

	@Override
	@RequestMapping(value = "/percorrido/gardar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Short gardarPercorrido(@RequestBody GardarPercorridoParam gardarPercorridoCustom) {

		log.info(StringUtil.creaString("Gardar percorrido: ", gardarPercorridoCustom));
		PercorridoCustom percorridoCustom = gardarPercorridoCustom.getPercorrido();
		Percorrido percorrido = new Percorrido(percorridoCustom.getIdPercorrido(), percorridoCustom.getNome(),
				percorridoCustom.getDescricion(), percorridoCustom.getIdEdificio());

		List<PuntoInterese> listaPoi = convertirPuntoIntereseCustomPuntoInterese(gardarPercorridoCustom.getListaPoi());

		Short idPercorrido = this.museoManager.gardarPercorrido(percorrido, listaPoi);

		log.info(StringUtil.creaString("Identificador percorrido gardado: ", idPercorrido));
		
		return idPercorrido;
	}

	@Override
	@RequestMapping(value = "/comprobarUsuarioGoogle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ComprobarLoginGoogleCustom comprobarUsuarioGoogle(@RequestBody String idTokenString) {

		ComprobarLoginGoogleCustom resposta = new ComprobarLoginGoogleCustom();
		try {
			HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
					//Id do cliente da aplicacion para acceder a Google
					.setAudience(Collections.singletonList("448237493715-f8qnmr9mblorb5bqqaoc836sftm7jl6k.apps.googleusercontent.com"))
					.build();

			GoogleIdToken idToken = verifier.verify(idTokenString);
			if (idToken != null) {
				Payload payload = idToken.getPayload();
				boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
				if (emailVerified) {
					String userId = payload.getSubject();
					log.info("User ID: " + userId);
	
					// Get profile information from payload
					String email = payload.getEmail();
	//				String name = (String) payload.get("name");
	//				String pictureUrl = (String) payload.get("picture");
	//				String locale = (String) payload.get("locale");
	//				String familyName = (String) payload.get("family_name");
	//				String givenName = (String) payload.get("given_name");
	
					//Recupera a conta de usuario a traves dun email. Se non existe a conta, creaa
					Usuario usuario = this.museoManager.getUsuario(email);
					resposta.setIdUsuario(usuario.getIdUsuario());
					resposta.setContaUsuario(email);
					
					List<UsuarioEdificio> listaUsuarioEdificio = this.museoManager.getListaUsuarioEdificioPorIdUsuario(usuario.getIdUsuario());
					for (UsuarioEdificio ue : listaUsuarioEdificio) {
						if (ue.getAdministrador()) {
							resposta.getListaIdEdificioAdministrador().add(ue.getIdEdificio());
						}
					}
				}
				
			}
			else {
				log.error("Invalid ID token.");
			}

		}
		catch (GeneralSecurityException | IOException e) {
			log.error("Incidencia ao comprobar o usuario", e);
		}
		
		return resposta;
	}
	
	@Override
	@RequestMapping(value = "/poi/gardar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Short gardarPuntoInterese(@RequestBody PuntoIntereseCustom poiCustom) {

		log.info(StringUtil.creaString("Gardar poi: ", poiCustom));
		
		PuntoInterese poi = convertirPuntoIntereseCustomPuntoInterese(poiCustom);

		Short idPoi = this.museoManager.gardarPuntoInterese(poi);

		log.info(StringUtil.creaString("Identificador poi gardado: ", idPoi));
		
		return idPoi;
	}

	@Override
	@RequestMapping(value = "/percorrido/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Boolean eliminarPercorrido(@RequestBody Short idPercorrido) {
		
		log.info(StringUtil.creaString("Eliminar percorrido: ", idPercorrido));
		
		this.museoManager.eliminarPercorrido(idPercorrido);
		
		log.info(StringUtil.creaString("Percorrido ", idPercorrido, " eliminado correctamente"));
		
		return true;
	}

	@Override
	@RequestMapping(value = "/poi/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Boolean eliminarPuntoInterese(@RequestBody Short idPoi) {
		
		log.info(StringUtil.creaString("Eliminar poi: ", idPoi));
		
		boolean correcto = this.museoManager.eliminarPuntoInterese(idPoi);

		log.info(StringUtil.creaString("Punto interese ", idPoi, " eliminado correctamente: ", correcto));
		
		return correcto;
	}
	
}
