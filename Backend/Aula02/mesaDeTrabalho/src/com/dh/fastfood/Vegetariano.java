package com.dh.fastfood;

public class Vegetariano extends Cardapio{
    private String prato;
    private double valor;

    public Vegetariano(String prato, double valor) {
        this.prato = prato;
        this.valor = valor;
    }

    @Override
    public void montar() {
        System.out.println("Utilizar embalagem especial.");
        System.out.printf("Um prato vegetariano(%s).\n", this.prato);

    }

    @Override
    public double calcularPreco() {
        return this.valor+(this.valor*0.01);
    }
}
