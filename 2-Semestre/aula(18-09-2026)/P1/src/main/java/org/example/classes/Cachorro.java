package org.example.classes;

public class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("AuAu!");
    }

    public void abanarRabo() {
        System.out.println("O Cachorro está abanando o rabo!");
    }
}
