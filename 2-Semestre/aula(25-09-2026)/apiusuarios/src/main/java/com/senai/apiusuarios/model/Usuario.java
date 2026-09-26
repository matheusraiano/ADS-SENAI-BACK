package com.senai.apiusuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id // é a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // é um auto_increment
    private Long id;
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario() {}

    public Usuario(Long id, String nome) {
        setId(id);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
