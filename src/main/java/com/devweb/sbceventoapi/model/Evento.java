package com.devweb.sbceventoapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id do evento")
    private Long id;

    @Schema(description = "Nome do evento")
    @NotBlank
    private String nome;

    @Schema(description = "Sigla do evento")
    @NotBlank
    private String sigla;

    @Schema(description = "Descrição do evento")
    @NotBlank
    private String descricao;

    @Schema(description = "Caminho do evento")
    @NotBlank
    private String path;

    // Construtor padrão
    public Evento() {
    }

    // Construtor com parâmetros
    public Evento(String nome, String sigla, String descricao, String path) {
        this.nome = nome;
        this.sigla = sigla;
        this.descricao = descricao;
        this.path = path;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // Método toString
    @Override
    public String toString() {
        return "Evento{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", descricao='" + descricao + '\'' +
                ", path='" + path +
                '}';
    }
}
