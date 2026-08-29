package org.example.Interfaces;

import org.example.Classes.ContaCorrente;

import javax.swing.*;
import java.awt.*;

import static org.example.Main.conta2;
import static org.example.Main.conta3;

public class InterfaceCorrente {
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
                Interface.escolha();
                return;
            }
            conta2.depositar(deposito);
            JOptionPane.showMessageDialog(null, "Depósito realizado: " + deposito);
            Interface.escolha();
        } else if (n == 3) {
            int tipoSaque = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Sacar normalmente\n" +
                    "2 - Depositar na poupança\n" +
                    "3 - Cancelar"));
            if (tipoSaque == 1) {
                double saque = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto deseja sacar?"));
                if (saque <= 0) {
                    JOptionPane.showMessageDialog(null, "Valor de saque inválido!");
                    InterfaceCorrente.Corrente();
                    return;
                }
                if (saque > conta2.getSaldo() + conta2.getLimite()) {
                    JOptionPane.showMessageDialog(null, "Saldo + limite insuficiente!");
                    InterfaceCorrente.Corrente();
                    return;
                }
                conta2.sacar(saque);
                JOptionPane.showMessageDialog(null, "Saque realizado: R$ " + saque);
                Interface.escolha();
            } else if (tipoSaque == 2) {
                double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto deseja depositar na poupança?"));
                if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "Valor inválido!");
                    InterfaceCorrente.Corrente();
                    return;
                }
                if (valor > conta2.getSaldo()) {
                    JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente para transferir para a poupança!");
                    InterfaceCorrente.Corrente();
                    return;
                }
                conta2.transferirPara(conta3, valor);
                JOptionPane.showMessageDialog(null, "Valor transferido para a poupança!\n" + "R$ " + valor);
                Interface.escolha();
            } else {
                return;
            }
            Interface.escolha();
        } else if (n == 4){
            JOptionPane.showMessageDialog(null, "Limite: " + conta2.getLimite());
            Interface.escolha();
        } else {
            return;
        }
    }
}
