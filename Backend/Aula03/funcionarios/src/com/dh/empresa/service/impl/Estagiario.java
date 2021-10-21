package com.dh.empresa.service.impl;

import com.dh.empresa.service.Vendedor;

public class Estagiario extends Vendedor {


    public Estagiario(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 5;
    }

    @Override
    public void mostrarCategoria(){
        String categoria = "";
        int num = calcularPontos();
        if (num<50) {categoria = "estagíario novato.";}
        if (num>49) {categoria = "estagíario experiente.";}
        System.out.println(this.nome + " fez " + num + " pontos, esta categorizado como "+ categoria);
    }



    /*implementação do método abstrato*/
    /*Cada venda vale 5 pontos.*/
    @Override
    public int calcularPontos() {
        return this.vendas * PONTOS_POR_VENDA;
    }
}
