package org.example;

import org.example.Classes.ContaBancaria;
import org.example.Interfaces.Interface;

import javax.swing.*;

public class Main {
    public static ContaBancaria conta1 = new ContaBancaria(5555, "Matheus", 1000);
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interface::escolha);
    }
}
