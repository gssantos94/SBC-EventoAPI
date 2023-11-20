package com.devweb.sbceventoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devweb.sbceventoapi.model.Espaco;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Long> {
}
