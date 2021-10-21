package com.dh.fastfood;

public class Main {
    public static void main(String[] args) {
        Cardapio pedido01 = new Adulto("Lasanha", 26.50);
        pedido01.novoPedido();

        Cardapio pedido02 = new Adulto("Lasanha", 26.50);
        pedido02.novoPedido();

        Cardapio pedido03 = new Infantil("Sopinha", 26.50, 1.20);
        pedido03.novoPedido();

        Cardapio pedido04 = new Vegetariano("Cogumelos", 26.50);
        pedido04.novoPedido();

        double total = pedido01.calcularPreco()+pedido02.calcularPreco()+pedido03.calcularPreco()+pedido04.calcularPreco();
        System.out.printf("\nO total dos pedidos deu R$ %.2f.",total);
    }
}
