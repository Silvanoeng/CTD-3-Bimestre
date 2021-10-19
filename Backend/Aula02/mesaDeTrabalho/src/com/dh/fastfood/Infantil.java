package com.dh.fastfood;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Infantil extends Cardapio{
    private String prato;
    private double valor;
    private double valorAdicional;

    public Infantil(String prato, double valor, double valorAdicional) {
        this.prato = prato;
        this.valor = valor;
        this.valorAdicional = valorAdicional;
    }

    @Override
    public void montar() {
        System.out.printf("Um prato kid(%s).\n", this.prato);
        System.out.println("Colocar um brinde no pedido.");
    }

    @Override
    public double calcularPreco() {
        return this.valor+this.valorAdicional;

    }
}
