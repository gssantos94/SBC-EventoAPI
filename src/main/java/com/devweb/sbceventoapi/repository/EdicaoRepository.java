package com.devweb.sbceventoapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.sbceventoapi.model.Edicao;
import com.devweb.sbceventoapi.model.Evento;

public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
    Optional<Edicao> findByAnoAndEvento(String ano, Evento evento);
}
