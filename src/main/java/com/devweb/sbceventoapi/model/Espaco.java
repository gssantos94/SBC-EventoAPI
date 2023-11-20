package com.devweb.sbceventoapi.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Espaco")
public class Espaco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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

    // Construtor padrão
    public Espaco() {
    }

    // Construtor com parâmetros
    public Espaco(String nome, String localizacao, int capacidade, List<String> recursos) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.recursos = recursos;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    // Método toString
    @Override
    public String toString() {
        return "Espaco{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", capacidade=" + capacidade +
                ", recursos='" + recursos +
                '}';
    }
}