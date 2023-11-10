package com.devweb.sbceventoapi.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Edicao")
public class Edicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int numero;

    @NotNull
    private int ano;

    @NotNull
    private Date data_inicio;

    @NotNull
    private Date data_fim;

    @NotBlank
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Construtor padrão
    public Edicao() {
    }

    // Construtor com parâmetros
    public Edicao( int numero, int ano, Date data_inicio, Date data_fim, String cidade, Evento evento) {
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
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
}

