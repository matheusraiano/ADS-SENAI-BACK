package org.example.classes;

public class FuncionarioPJ extends Funcionario {
    public FuncionarioPJ(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularSalario() {
        return getSalario();
    }
}
