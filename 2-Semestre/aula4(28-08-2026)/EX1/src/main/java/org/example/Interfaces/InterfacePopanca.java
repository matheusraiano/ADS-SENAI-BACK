package org.example.Interfaces;

import org.example.Classes.ContaCorrente;
import org.example.Classes.ContaPoupanca;

import javax.swing.*;

import static org.example.Main.conta2;
import static org.example.Main.conta3;

public class InterfacePopanca {
    public static void Poupaca() {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Consultar Saldo\n" +
                "2- Depositar\n" +
                "3- Sacar\n" +
                "4- Aplicar Rendimento\n" +
                "5- Sair"));
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Saldo: "+conta3.getSaldo());
            Interface.escolha();
        } else if (n == 2){
            double deposito;
            deposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto deseja depositar?"));
            if (deposito <= 0) {
                JOptionPane.showMessageDialog(null, "O depósito deve ser maior que zero!");
                Interface.escolha();
                return;
            }
            if (deposito > conta2.getSaldo()) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para depósito!");
                Interface.escolha();
                return;
            }
            conta2.transferirPara(conta3, deposito);
            JOptionPane.showMessageDialog(null, "Depósito realizado: " + deposito);
            Interface.escolha();
        } else if (n == 3){
            double saque;
            saque = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto deseja sacar?"));
            if (saque <= 0) {
                JOptionPane.showMessageDialog(null, "Valor de saque inválido!");
                Interface.escolha();
                return;
            }
            if (saque > conta3.getSaldo()) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                Interface.escolha();
                return;
            }
            conta3.transferirPara(conta2, saque);
            JOptionPane.showMessageDialog(null, "Saque realizado: " + saque);
            Interface.escolha();
        } else if (n == 4) {
            int rend = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "1 - Sim\n2 - Não", "Deseja aplicar " + (conta3.getTaxaRendimento() * 100) + "% de rendimento?", JOptionPane.INFORMATION_MESSAGE));
            if (rend == 1) {
                double saldoAntes = conta3.getSaldo();
                conta3.aplicarRendimento();
                double rendimento = conta3.getSaldo() - saldoAntes;
                JOptionPane.showMessageDialog(null, "Seu rendimento foi de: " + rendimento + "\nNovo saldo: " + conta3.getSaldo());
            }
            Interface.escolha();
        }
        else {
            return;
        }
    }
}
