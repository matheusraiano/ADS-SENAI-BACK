package org.example;

public class Animal {
    private String nome;
    private String especie;
    private int idade;

    public Animal() {}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            this.idade = 0;
        } else {
            this.idade = idade;
        }
    }

    public Animal(String nome, String especie, int idade) {
        setNome(nome);
        setEspecie(especie);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public int getIdade() {
        return idade;
    }

    public void emitirSom() {
        System.out.println("O Animal "+this.nome+" está emitindo um som!");
    }
}
