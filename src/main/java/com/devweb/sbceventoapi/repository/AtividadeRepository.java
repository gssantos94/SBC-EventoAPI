package com.devweb.sbceventoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.sbceventoapi.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
