package com.dh.salario.model;

public class Efetivo extends Funcionario{
    private double salarioBase;
    private double descontos;
    private double bonificacoes;

    public Efetivo(String nome, String sobrenome, String numeroConta, double salarioBase, double descontos,
                   double bonificacoes) {
        super(nome, sobrenome, numeroConta);
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.bonificacoes = bonificacoes;
    }

    @Override
    public double calcularPagamento() {
        return this.salarioBase+this.bonificacoes-this.descontos;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Recibo impresso");
        System.out.printf("O valor do recibo: R$ %.2f.\n", quantia);
    }
}
