package org.example.classes;

public class PagamentoPix extends Pagamento {
    public PagamentoPix(double saldo) {
        super(saldo);
    }

    @Override
    public void realizarPagamento() {
        System.out.println("O pagamento foi realizado via PIX!");
    }
}
