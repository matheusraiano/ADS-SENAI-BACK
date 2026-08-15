package org.example;

public class Carro {
    private String modelo;
    private String cor;
    private int ano;
    private String montadora;

    // Construtor 1(default Java)
    public Carro() {}

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno(int ano) {
        if(ano >= 1900) {
            this.ano = ano;
        } else {
            this.ano = 1900;
        }
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    // Construtor 2(Criado por mim)
    public Carro(String modelo, String cor, int ano, String montadora) {
        setModelo(modelo);
        setCor(cor);
        setAno(ano);
        setMontadora(montadora);
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    public String getMontadora() {
        return montadora;
    }

    public void acelerar() {
        System.out.println("O "+getModelo()+" da cor "+getCor()+" e do ano "+getAno()+", feito pela "+getMontadora()+" está acelerando!!!");
    }
}
