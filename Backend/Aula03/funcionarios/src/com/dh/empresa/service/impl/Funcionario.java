package com.dh.empresa.service.impl;

import com.dh.empresa.service.Vendedor;

import java.util.ArrayList;

public class Funcionario extends Vendedor {
    private int anosAntiguidade;
    private ArrayList<Vendedor> afiliados = new ArrayList<>();

    public Funcionario(String nome, int anosAntiguidade){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 5;
        this.anosAntiguidade = anosAntiguidade;
    }

    /*Agrega um afiliado ao ArrayList do funcionario, e soma os pontos*/
    public void addAfiliado(Vendedor afiliado){
        this.afiliados.add(afiliado);
        System.out.println(afiliado.getNome() + " agora é afiliado de " + super.nome);
    }

    /*implementação do método abstrato*/
    /*Cada ano de antiguidade vale 5 pontos, cada afiliado agregado vale 10 e*/
    /*Cada venda vale 5 pontos.*/
    @Override
    public int calcularPontos() {
        return (this.afiliados.size()*10) + (this.anosAntiguidade*5) + (this.vendas*super.PONTOS_POR_VENDA);
    }
}
