package org.example;

import org.example.Classes.ContaBancaria;
import org.example.Classes.ContaCorrente;
import org.example.Classes.ContaPoupanca;
import org.example.Interfaces.Interface;

import javax.swing.*;

public class Main {
    public static ContaBancaria conta1 = new ContaBancaria(5555, "Matheus", 0);
    public static ContaCorrente conta2 = new ContaCorrente(conta1.getNumero(), conta1.getTitular(), conta1.getSaldo(), 1000, 0);
    public static ContaPoupanca conta3 = new ContaPoupanca(conta1.getNumero(), conta1.getTitular(), 0, 0.05);
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interface::escolha);
    }
}
