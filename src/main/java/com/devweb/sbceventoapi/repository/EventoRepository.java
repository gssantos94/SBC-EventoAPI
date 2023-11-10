package com.devweb.sbceventoapi.repository;

import com.devweb.sbceventoapi.model.Evento;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    Optional<Evento> findByPath(String path);
}
