package br.com.raiano;

public class pessoas {
    public static void pessoa1() {
        // criar um obj
        // NomeClasse objeto = new NomeClasse();
        Pessoa pessoa01 = new Pessoa();

        // atribuir as caracteristicas
        pessoa01.idade = 32;
        pessoa01.nome = "Neymar";
        pessoa01.peso = 60;

        // exibir objeto
        System.out.println("Nome: "+pessoa01.nome+
                "\nIdade: "+pessoa01.idade+
                "\nPeso: "+pessoa01.peso);

        // funcionalidade
        pessoa01.falarNome();
    }
    public static void pessoa2() {
        Pessoa pessoa02 = new Pessoa();
        pessoa02.nome = "TESTE";
        pessoa02.idade = 20;
        pessoa02.peso = 70;
        System.out.println("Nome: "+pessoa02.nome+
                "\nIdade: "+pessoa02.idade+
                "\nPeso: "+pessoa02.peso);
        pessoa02.falarNome();
    }
}
