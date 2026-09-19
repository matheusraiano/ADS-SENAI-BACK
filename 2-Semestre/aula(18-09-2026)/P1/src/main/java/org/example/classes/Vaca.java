package org.example.classes;

public class Vaca extends Animal {
    public Vaca(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Muu!");
    }

    public void comendoGrama() {
        System.out.println("A vaca está comendo grama!");
    }
}
