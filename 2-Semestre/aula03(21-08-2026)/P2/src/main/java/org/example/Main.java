package org.example;

public class Main {
    static void main() {
        ContaBancaria conta1 = new ContaBancaria();
        conta1.setNumero(1111);
        conta1.setTitular("Ney");
        conta1.setSaldo(5000);
        conta1.depositar(200);
        conta1.sacar(3500);
        conta1.exibirDados();

        ContaBancaria conta2 = new ContaBancaria(2222, "Mar", 500);
        conta2.depositar(700);
        conta2.sacar(500);
        conta2.exibirDados();
    }
}
