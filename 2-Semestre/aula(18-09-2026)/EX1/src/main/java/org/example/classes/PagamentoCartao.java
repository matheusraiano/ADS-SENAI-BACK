package org.example.classes;

public class PagamentoCartao extends Pagamento {
    public PagamentoCartao(double saldo) {
        super(saldo);
    }

    @Override
    public void realizarPagamento() {
        System.out.println("O pagamento foi realizado via Cartão!");
    }
}
