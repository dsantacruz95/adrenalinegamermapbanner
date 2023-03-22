package com.darkmencito.mapbanner.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkmencito.mapbanner.models.Sala;
import com.darkmencito.mapbanner.models.SalaParticipante;
import com.darkmencito.mapbanner.repositories.SalaParticipanteRepository;
import com.darkmencito.mapbanner.repositories.SalaRepository;
import com.darkmencito.mapbanner.services.SalaParticipanteService;
import com.darkmencito.mapbanner.utils.RespuestaServicio;

@Service
public class SalaParticipanteServiceImpl implements SalaParticipanteService {

	@Autowired
	SalaRepository salaRepository;

	@Autowired
	SalaParticipanteRepository salaParticipanteRepository;

	@Override
	public RespuestaServicio accederSala(String idSala, String tipo, String nickname) {
		RespuestaServicio respuesta = new RespuestaServicio();
		int codigo = 0;
		String mensaje = "";
		try {
			Optional<Sala> sala = salaRepository.findById(Long.valueOf(idSala));
			if (sala.isPresent()) {
				Sala salaVal = sala.get();
				boolean ingreso = true;
				int jugadores = 0;
				boolean mismonick = false;
				for (SalaParticipante participante : salaVal.getParticipantes()) {
					jugadores += (participante.getTipoParticipante().equals("P") ? 1 : 0);
					if (!mismonick)
						mismonick = participante.getNickname().trim().equals(nickname.trim());
				}

				if ("P".equals(tipo)) {
					ingreso = jugadores < 2;
					if (!ingreso) {
						mensaje = "Ya se encuentran registrados los 2 jugadores participantes del encuentro!";
					}
				}

				if (ingreso && mismonick) {
					ingreso = !mismonick;
					mensaje = "El nick ingresado ya se encuentra registrado!";
				}

				if (ingreso) {
					SalaParticipante participantNuevo = new SalaParticipante();
					participantNuevo.setSala(salaVal);
					participantNuevo.setNickname(nickname);
					participantNuevo.setTipoParticipante(tipo);
					salaParticipanteRepository.save(participantNuevo);

					codigo = 1;
					mensaje = "Participante ha sido registrado en la sala!";
				}
			} else {
				mensaje = "Código de sala enviado inválido!";
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		respuesta.setCodigo(codigo);
		respuesta.setMensaje(mensaje);
		return respuesta;
	}

}
