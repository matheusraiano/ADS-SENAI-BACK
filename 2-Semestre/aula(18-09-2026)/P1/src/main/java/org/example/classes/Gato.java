package org.example.classes;

public class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }

    public void ronronar() {
        System.out.println("O gato está ronronando!");
    }
}
