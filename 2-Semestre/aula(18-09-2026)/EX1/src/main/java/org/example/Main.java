package org.example;

import org.example.classes.Pagamento;
import org.example.classes.PagamentoBoleto;
import org.example.classes.PagamentoCartao;
import org.example.classes.PagamentoPix;

public class Main {
    static void main() {
        Pagamento pag1 = new PagamentoPix(100);
        Pagamento pag2 = new PagamentoCartao(100);
        Pagamento pag3 = new PagamentoBoleto(100);

        processarPagamento(pag1);
        processarPagamento(pag2);
        processarPagamento(pag3);
    }

    public static void processarPagamento(Pagamento pagamento) {
        pagamento.realizarPagamento();
    }
}
