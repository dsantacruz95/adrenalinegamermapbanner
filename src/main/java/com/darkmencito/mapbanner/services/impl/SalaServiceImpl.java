package com.darkmencito.mapbanner.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkmencito.mapbanner.models.Sala;
import com.darkmencito.mapbanner.repositories.SalaRepository;
import com.darkmencito.mapbanner.services.SalaService;

@Service
public class SalaServiceImpl implements SalaService {

	@Autowired
	private SalaRepository salaRepository;

	@Override
	public Sala obtenerSalaxSessionId(String sessionid) {
		try {
			return salaRepository.findBySessionid(sessionid);
		} catch (Exception e) {
			return new Sala();
		}
	}

}
