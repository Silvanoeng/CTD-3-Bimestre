package com.dh.empresa;

//validação que usa propriedades de subclasse apenas!!
//Classe abstrata Vendedor - aqui vai o Template Method
public abstract class Vendedor {
    protected String nome;
    protected int vendas = 0;
    protected int PONTOS_POR_VENDA;

    public void vender(int qtdVendas){
        this.vendas += qtdVendas;
        System.out.println(this.nome +" realizou "+qtdVendas + " vendas.");
    }

    /*Método que calcula os pontos do Vendedor de acordo com seus aspectos a serem considerados*/
    public abstract int calcularPontos();

    /*TEMPLATE METHOD - recebe o total de pontos calculados a partir da subclasse e valida cada item para retornar a categoria*/
    public void mostrarCategoria(){
        String categoria = "";
        int num = calcularPontos();
        if (num<20) {categoria = "novato";}
        if (num>19 && num<31) {categoria = "aprendiz";}
        if (num>30 && num<41) {categoria = "bom";}
        if (num>40) {categoria = "mestre";}
        System.out.println(this.nome + " fez " + num + " pontos, esta categorizado como "+ categoria);
    }
}
