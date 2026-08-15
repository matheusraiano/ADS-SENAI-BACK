package br.com.raiano;

public class Pessoa {
    String nome;
    int idade;
    double peso;

    // função sem retorno
    void falarNome() {
        System.out.println("Olá, eu sou o(a): "+this.nome);
    }

    // função com retorno em int
    int getIdade() {
        return this.idade;
    }
}
