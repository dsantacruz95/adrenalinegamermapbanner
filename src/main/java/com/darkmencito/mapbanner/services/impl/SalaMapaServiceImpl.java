package com.darkmencito.mapbanner.services.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkmencito.mapbanner.models.SalaMapa;
import com.darkmencito.mapbanner.repositories.SalaMapaRepository;
import com.darkmencito.mapbanner.services.SalaMapaService;
import com.darkmencito.mapbanner.utils.RespuestaServicio;

@Service
public class SalaMapaServiceImpl implements SalaMapaService {

	@Autowired
	private SalaMapaRepository salaMapaRepository;

	@Override
	public RespuestaServicio banearMapa(String id, String nickname) {
		RespuestaServicio retorno = new RespuestaServicio();
		int codigo = 0;
		String mensaje = "";
		try {
			Optional<SalaMapa> salaMapa = salaMapaRepository.findById(Long.valueOf(id));
			if (salaMapa.isPresent()) {
				SalaMapa salaMapaVal = salaMapa.get();
				if ("B".equals(salaMapaVal.getEstado())) {
					mensaje = "El mapa ya se encuentra baneado!";
				} else {
					salaMapaVal.setEstado("B");
					salaMapaVal.setNicknameEdita(nickname);
					salaMapaVal.setFechaBanea(new Date());
					salaMapaRepository.save(salaMapaVal);

					codigo = 1;
					mensaje = "Mapa baneado!";
				}

			} else {
				mensaje = "Código enviado no válido!";
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		retorno.setCodigo(codigo);
		retorno.setMensaje(mensaje);
		return retorno;
	}

}
