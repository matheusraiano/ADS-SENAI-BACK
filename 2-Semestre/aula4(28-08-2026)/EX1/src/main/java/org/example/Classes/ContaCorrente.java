package org.example.Classes;

public class ContaCorrente extends ContaBancaria {
    private double limite;

    public ContaCorrente() {}

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ContaCorrente(int numero, String titular, double saldo, double limite) {
        super(numero, titular, saldo);
        setLimite(limite);
    }

    public double getLimite() {
        return this.limite;
    }

    @Override
    public void sacar(double saque) {
        if (saque <= 0) {
            System.out.println("Valor de saque inválido!");
            return;
        }
        if (saque > getSaldo() + getLimite()) {
            System.out.println("Você não possui saldo/limite suficiente!");
            return;
        }
        setSaldo(getSaldo() - saque);
        System.out.println("Você sacou " + saque + " da sua conta!");
    }

}
