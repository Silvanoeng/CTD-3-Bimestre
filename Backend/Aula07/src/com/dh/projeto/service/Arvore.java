package com.dh.projeto.service;

public class Arvore {
    private String tipo;
    private int altura;
    private int largura;
    private String cor;

    public Arvore(String tipo, int altura, int largura, String cor) {
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public String getCor() {
        return cor;
    }
}
