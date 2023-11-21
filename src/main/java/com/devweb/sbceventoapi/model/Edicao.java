package com.devweb.sbceventoapi.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Edicao")
public class Edicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Id da edição")
    @NotNull
    private int numero;

    @Schema(description = "Ano da edição")
    @NotNull
    private String ano;

    @Schema(description = "Data de início da edição")
    @NotNull
    private LocalDate data_inicio;

    @Schema(description = "Data de término da edição")
    @NotNull
    private LocalDate data_fim;

    @Schema(description = "Cidade da edição")
    @NotBlank
    private String cidade;

    @Schema(description = "Evento associado à edição")
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Schema(description = "Organizador da edição")
    @OneToOne
    private Usuario organizador;

    public Usuario getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }
    
    // Construtor padrão
    public Edicao() {
    }

    // Construtor com parâmetros
    public Edicao(int numero, String ano, LocalDate data_inicio, LocalDate data_fim, String cidade, Evento evento) {
        this.numero = numero;
        this.ano = ano;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.cidade = cidade;
        this.evento = evento;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    // Método toString
    @Override
    public String toString() {
        return "Edicao{" +
                "id='" + id + '\'' +
                ", numero=" + numero +
                ", ano=" + ano +
                ", data_inicio=" + data_inicio +
                ", data_fim=" + data_fim +
                ", cidade='" + cidade + '\'' +
                ", evento=" + evento +
                '}';
    }

    public boolean isDataNaEdicao(LocalDate data) {
        return !data.isBefore(data_inicio) && !data.isAfter(data_fim);
    }
    
}
