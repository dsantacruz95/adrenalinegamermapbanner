package com.darkmencito.mapbanner.services;

import com.darkmencito.mapbanner.utils.RespuestaServicio;

public interface SalaParticipanteService {

	public RespuestaServicio accederSala(String idSala, String tipo, String nickname);

}
