package com.dh.fastfood;

public class Adulto extends Cardapio{
    private String prato;
    private double valor;

    public Adulto(String prato, double valor) {
        this.prato = prato;
        this.valor = valor;
    }

    @Override
    public void montar() {
        System.out.printf("Pedido (%s).\n", this.prato);

    }

    @Override
    public double calcularPreco() {
        return this.valor;
    }
}
