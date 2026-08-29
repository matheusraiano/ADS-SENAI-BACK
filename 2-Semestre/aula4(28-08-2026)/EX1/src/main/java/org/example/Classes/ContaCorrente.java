package org.example.Classes;

public class ContaCorrente extends ContaBancaria {
    private double limite;
    private double limiteUsado;

    public ContaCorrente() {}

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setLimiteUsado(double limiteUsado) {
        this.limiteUsado = limiteUsado;
    }

    public ContaCorrente(int numero, String titular, double saldo, double limite, double limiteUsado) {
        super(numero, titular, saldo);
        setLimite(limite);
        setLimiteUsado(limiteUsado);
    }

    public double getLimite() {
        return this.limite;
    }

    public double getLimiteUsado() {
        return this.limiteUsado;
    }

    @Override
    public void sacar(double saque) {
        if (saque <= 0) {
            System.out.println("Valor de saque inválido!");
            return;
        }
        double limiteDisponivel = getLimite() - getLimiteUsado();
        if (saque > getSaldo() + limiteDisponivel) {
            System.out.println("Você não possui saldo/limite suficiente!");
            return;
        }
        if (saque <= getSaldo()) {
            setSaldo(getSaldo() - saque);
        } else {
            double valorDoLimite = saque - getSaldo();
            setSaldo(0);
            setLimiteUsado(getLimiteUsado() + valorDoLimite);
        }
        System.out.println("Você sacou " + saque + " da sua conta!");
    }

    @Override
    public void depositar(double deposito) {
        if (deposito <= 0) {
            System.out.println("O depósito deve ser maior que zero!");
            return;
        }
        if (getLimiteUsado() > 0) {
            if (deposito <= getLimiteUsado()) {
                setLimiteUsado(getLimiteUsado() - deposito);
            } else {
                double restante = deposito - getLimiteUsado();
                setLimiteUsado(0);
                setSaldo(getSaldo() + restante);
            }
        } else {
            setSaldo(getSaldo() + deposito);
        }
        System.out.println("Você depositou " + deposito + " na sua conta!");
    }
}
