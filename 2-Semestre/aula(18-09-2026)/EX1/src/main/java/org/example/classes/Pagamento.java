package org.example.classes;

public class Pagamento {
    private double saldo;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Pagamento(double saldo) {
        setSaldo(saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void realizarPagamento() {
        System.out.println("O pagamento foi realizado!");
    }
}
