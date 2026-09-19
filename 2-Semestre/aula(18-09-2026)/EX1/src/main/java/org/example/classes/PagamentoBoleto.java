package org.example.classes;

public class PagamentoBoleto extends Pagamento {
    public PagamentoBoleto(double saldo) {
        super(saldo);
    }

    @Override
    public void realizarPagamento() {
        System.out.println("O pagamento foi realizado via Boleto!");
    }
}
