package com.devweb.sbceventoapi.dto;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EspacoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String localizacao;

    @NotNull
    private int capacidade;

    @ElementCollection
    @CollectionTable(name = "recursos", joinColumns = @JoinColumn(name = "espaco_id"))
    @Column(name = "recurso")
    private List<String> recursos;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<String> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<String> recursos) {
        this.recursos = recursos;
    }
}

