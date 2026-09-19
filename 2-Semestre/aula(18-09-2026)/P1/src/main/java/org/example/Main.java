package org.example;

import org.example.classes.Animal;
import org.example.classes.Cachorro;
import org.example.classes.Gato;
import org.example.classes.Vaca;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cachorro("Cachorro");
        Animal animal2 = new Gato("Gato");
        Animal animal3 = new Vaca("Mimosa");

        apresnetarAnimal(animal1);
        apresnetarAnimal(animal2);
        apresnetarAnimal(animal3);
    }

    public static void fazerAnimalEmitirSom(Animal animal) {
        animal.emitirSom();
    }

    public static void apresnetarAnimal(Animal animal) {
        System.out.println("Nome: "+animal.getNome());
        animal.emitirSom();
    }
}
