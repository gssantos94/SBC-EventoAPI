package com.devweb.sbceventoapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id do usuário")
    private Long id;

    @Schema(description = "login do usuário")
    @NotBlank
    private String login;

    @Schema(description = "Email do usuário")
    @NotBlank
    @Email
    private String email;

    @Schema(description = "Nome do usuário")
    @NotBlank
    private String nome;

    @Schema(description = "Afiliação do usuário")
    @NotBlank
    private String afiliacao;

    @Schema(description = "Perfil do usuário")
    private boolean admin;

    // Construtores

    public Usuario() {
    }

    public Usuario(String login, String email, String nome, String afiliacao, boolean admin) {
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.afiliacao = afiliacao;
        this.admin = admin;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    // Método toString
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", afiliacao='" + afiliacao + '\'' +
                ", admin=" + admin +
                '}';
    }
}
