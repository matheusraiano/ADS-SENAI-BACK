package org.example.classes;

public class Animal {
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Animal(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void emitirSom() {
        System.out.println("O animal emitiu um som!");
    }
}
