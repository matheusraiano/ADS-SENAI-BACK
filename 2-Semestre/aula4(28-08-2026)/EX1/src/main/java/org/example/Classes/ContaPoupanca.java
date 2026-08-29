package org.example.Classes;

public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento;

    public ContaPoupanca() {}

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(int numero, String titular, double saldo, double taxaRendimento) {
        super(numero, titular, saldo);
        setTaxaRendimento(taxaRendimento);
    }

    public double getTaxaRendimento() {
        return this.taxaRendimento;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * getTaxaRendimento();
        depositar(rendimento);
    }
}
