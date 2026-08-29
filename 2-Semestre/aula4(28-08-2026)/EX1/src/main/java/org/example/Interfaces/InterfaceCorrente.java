package org.example.Interfaces;

import org.example.Classes.ContaCorrente;

import javax.swing.*;
import java.awt.*;

public class InterfaceCorrente {
    static ContaCorrente conta2 = new ContaCorrente(5555, "Matheus", 1000, 1000);
    public static void Corrente() {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Consultar Saldo\n" +
                "2- Depositar\n" +
                "3- Sacar\n" +
                "4- Consultar Limite\n" +
                "5- Sair"));
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Saldo: "+conta2.getSaldo());
            Interface.escolha();
        } else if (n == 2){
            double deposito;
            deposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto deseja depositar?"));
            if (deposito <= 0) {
                JOptionPane.showMessageDialog(null, "O depósito deve ser maior que zero!");
            } else {
                conta2.depositar(deposito);
                JOptionPane.showMessageDialog(null, "Depósito realizado: " + deposito);
            }
            Interface.escolha();
        } else if (n == 3){
            double saque;
            saque = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto deseja sacar?"));
            if (saque <= 0) {
                JOptionPane.showMessageDialog(null, "Valor de saque inválido!");
            } else if (saque > conta2.getSaldo()) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
            } else {
                conta2.sacar(saque);
                JOptionPane.showMessageDialog(null, "Saque realizado: " + saque);
            }
            Interface.escolha();
        } else if (n == 4){
            double limitePessoal = 1000;
            conta2.setLimite(limitePessoal);
            JOptionPane.showMessageDialog(null, "Limite: "+conta2.getLimite());
            Interface.escolha();
        } else {
            return;
        }
    }
}
