package com.dh.empresa;

public class Afiliado extends Vendedor{

    public Afiliado(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 15;
    }

    /*implementação do método abstrato*/
    /*Cada venda vale 15 pontos.*/
    @Override
    public int calcularPontos() {
        return this.vendas * PONTOS_POR_VENDA;
    }

}
