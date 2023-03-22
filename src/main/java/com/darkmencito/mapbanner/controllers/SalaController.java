package com.darkmencito.mapbanner.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darkmencito.mapbanner.models.Sala;
import com.darkmencito.mapbanner.services.SalaMapaService;
import com.darkmencito.mapbanner.services.SalaParticipanteService;
import com.darkmencito.mapbanner.services.SalaService;
import com.darkmencito.mapbanner.utils.RespuestaServicio;

@RestController
@RequestMapping(path = "/sala")
public class SalaController {

	@Autowired
	private SalaService salaService;

	@Autowired
	private SalaMapaService salaMapaService;
	
	@Autowired
	private SalaParticipanteService salaParticipanteService;

	@RequestMapping(value = "/encontrar", method = RequestMethod.GET)
	public Sala encontrar(@RequestParam(name = "session") String sessionid) {
		return salaService.obtenerSalaxSessionId(sessionid);
	}
	
	@RequestMapping(value = "/acceder-sala", method = RequestMethod.POST)
	public RespuestaServicio accederSala(@RequestBody Map<String, String> json) {
		return salaParticipanteService.accederSala(json.get("idSala"), json.get("tipo"), json.get("nickname"));
	}

	@RequestMapping(value = "/banear-mapa", method = RequestMethod.POST)
	public RespuestaServicio banearMapa(@RequestBody Map<String, String> json) {
		return salaMapaService.banearMapa(json.get("idMapa"), json.get("nickname"));
	}

}
