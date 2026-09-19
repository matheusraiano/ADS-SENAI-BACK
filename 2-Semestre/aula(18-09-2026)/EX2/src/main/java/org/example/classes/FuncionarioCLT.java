package org.example.classes;

public class FuncionarioCLT extends Funcionario {
    public FuncionarioCLT(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularSalario() {
        double inss = getSalario() * 0.075;
        return getSalario() - inss;
    }
}
