package org.example;

public class Main {
    public void main(String[] args) {
        // primeira forma
        Carro carro1 = new Carro();
        carro1.setModelo("Fusion");
        carro1.setCor("Branco");
        carro1.setAno(2015);
        carro1.setMontadora("Ford");
        carro1.acelerar();
        System.out.println("Modelo: "+carro1.getModelo()+"\nCor: "+carro1.getCor()+"\nAno: "+carro1.getAno()+"\nMontadora: "+carro1.getMontadora()+"\n");

        // segunda forma
        Carro carro2 = new Carro("Galant", "Cinza", 2002, "Mitsubishi");
        carro2.acelerar();
        System.out.println("Modelo: "+carro2.getModelo()+"\nCor: "+carro2.getCor()+"\nAno: "+carro2.getAno()+"\nMontadora: "+carro2.getMontadora()+"\n");
    }
}
