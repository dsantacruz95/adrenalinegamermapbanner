package com.darkmencito.mapbanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkmencito.mapbanner.models.SalaMapa;

@Repository
public interface SalaMapaRepository extends JpaRepository<SalaMapa, Long> {

}
