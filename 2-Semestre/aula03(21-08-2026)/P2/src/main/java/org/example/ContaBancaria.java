package org.example;

public class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;

    public ContaBancaria() {}

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        if (saldo < 1) {
            System.out.println("Saldo Inválido!");
        } else {
            this.saldo = saldo;
        }
    }

    public ContaBancaria(int numero, String titular, double saldo) {
        setNumero(numero);
        setTitular(titular);
        setSaldo(saldo);
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void exibirDados() {
        System.out.println("Número: "+getNumero()+" \n" +
                "Titular: "+getTitular()+" \n" +
                "Saldo: "+ getSaldo()+" \n");
    }

    public void depositar(double deposito) {
        if (deposito < 1) {
            System.out.println("Não pode ter depósitos menores que 1 real!");
        } else {
            setSaldo(deposito);
            System.out.println("Você depositou "+deposito+" na sua conta!");
        }
    }

    public void sacar(double saque) {
        if (saque < getSaldo()) {
            System.out.println("Você não possuí o valor para sacar!");
        } else {
            setSaldo(saque - getSaldo());
            System.out.println("Você sacou "+saque+" da sua conta!");
        }
    }
}
