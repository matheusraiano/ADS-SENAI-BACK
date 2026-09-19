package org.example;

import org.example.classes.Funcionario;
import org.example.classes.FuncionarioCLT;
import org.example.classes.FuncionarioPJ;

public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new FuncionarioCLT("Manin", 1621);
        Funcionario f2 = new FuncionarioPJ("Fulano", 3000);

        mostrarSalario(f1);
        mostrarSalario(f2);
    }

    public static void mostrarSalario(Funcionario funcionario) {
        System.out.println(funcionario.getNome()+" Recebe R$"+funcionario.calcularSalario());
    }
}
