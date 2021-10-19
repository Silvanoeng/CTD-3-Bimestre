package com.dh.salario.model;

public abstract class Funcionario {
    private String nome;
    private String sobrenome;
    private String numeroConta;

    public Funcionario(String nome, String sobrenome, String numeroConta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroConta = numeroConta;
    }

    public void pagamentoSalario(){
        double quantia;
        System.out.printf("\nFuncionario: %s %s.\n",this.nome, this.sobrenome);
        quantia = calcularPagamento();
        imprimirRecibo(quantia);
        depositar(quantia);
    }

    public abstract double calcularPagamento();
    public abstract void imprimirRecibo(double quantia);
    public void depositar(double quantia){
        System.out.printf("A quantida de R$ %.2f, foi depositado na conta %s.", quantia, getNumeroConta());
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
