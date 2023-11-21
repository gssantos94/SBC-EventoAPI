package com.devweb.sbceventoapi.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "Atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id da atividade")
    private Long id;

    @NotBlank
    @Schema(description = "Nome da atividade")
    private String nome;

    @NotBlank
    @Schema(description = "Tipo da atividade")
    private String tipo;

    @NotBlank
    @Schema(description = "Descrição da atividade")
    private String descricao;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Data da atividade", type = "string", format = "date")
    private LocalDate data;

    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    @Schema(description = "Hora de início da atividade", type = "string", format = "time")
    private LocalTime hora_inicio;

    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    @Schema(description = "Hora de fim da atividade", type = "string", format = "time")
    private LocalTime hora_fim;

    @ManyToOne
    @JoinColumn(name = "edicao_id")
    @Schema(description = "Edição associada à atividade")
    private Edicao edicao;

    @ManyToOne
    @JoinColumn(name = "espaco_id")
    @Schema(description = "Espaço associado à atividade")
    private Espaco espaco;

    // Construtor padrão
    public Atividade() {
    }

    // Construtor com parâmetros
    public Atividade(String nome, String tipo, String descricao, LocalDate data, LocalTime hora_inicio, LocalTime hora_fim,
            Edicao edicao, Espaco espaco) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.edicao = edicao;
        this.espaco = espaco;
    }

    // Getters e setters
    // ... (métodos gerados automaticamente)

    // Método toString
    @Override
    public String toString() {
        return "Atividade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", hora_inicio=" + hora_inicio +
                ", hora_fim=" + hora_fim +
                ", edicao=" + edicao +
                ", espaco=" + espaco +
                '}';
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(LocalTime hora_fim) {
        this.hora_fim = hora_fim;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public enum Tipo {
        PALESTRA,
        PAINEL,
        SESSAO_TECNICA,
        OUTROS;

        public static boolean isValidTipo(String tipo) {
            for (Tipo value : values()) {
                if (value.name().equalsIgnoreCase(tipo)) {
                    return true;
                }
            }
            return false;
        }
    }
}
