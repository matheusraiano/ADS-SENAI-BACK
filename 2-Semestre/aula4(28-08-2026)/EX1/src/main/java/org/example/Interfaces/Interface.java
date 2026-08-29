package org.example.Interfaces;

import org.example.Classes.ContaBancaria;

import javax.swing.*;

public class Interface {
    public static void escolha() {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Conta Corrente\n2- Conta Poupança\n3- Sair"));
        if (n == 1) {
            InterfaceCorrente.Corrente();
        } else if (n == 2){
            InterfacePopanca.Poupaca();
        } else {
            return;
        }
    }
}
