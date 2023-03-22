package com.darkmencito.mapbanner.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darkmencito.mapbanner.models.Sala;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long> {
	
	public Sala findBySessionid(String sessionid);
	
}
