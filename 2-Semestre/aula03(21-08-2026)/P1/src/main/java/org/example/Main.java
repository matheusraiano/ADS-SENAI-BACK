package org.example;

public class Main {
    public void main(String[] args) {
        Animal animal1 = new Animal("Rex", "Cachorao", 5);
        animal1.setEspecie("Cachoro");
        System.out.println("Nome: "+animal1.getNome()+"\nEspecie: "+animal1.getEspecie()+"\nIdade: "+animal1.getIdade()+"\n");
        animal1.emitirSom();

        Animal animal2 = new Animal("Mimi", "Gato", 30);
        animal2.setIdade(3);
        System.out.println("Nome: "+animal2.getNome()+"\nEspecie: "+animal2.getEspecie()+"\nIdade: "+animal2.getIdade()+"\n");
        animal2.emitirSom();
    }
}
