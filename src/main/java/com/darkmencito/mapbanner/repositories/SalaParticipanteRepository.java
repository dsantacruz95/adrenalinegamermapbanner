package com.darkmencito.mapbanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkmencito.mapbanner.models.SalaParticipante;

@Repository
public interface SalaParticipanteRepository extends JpaRepository<SalaParticipante, Long> {

}
