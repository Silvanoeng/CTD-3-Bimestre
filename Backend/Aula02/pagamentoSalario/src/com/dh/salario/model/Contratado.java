package com.dh.salario.model;

public class Contratado extends Funcionario {
    private double valorHora;
    private int horas;

    public Contratado(String nome, String sobrenome, String numeroConta, double valorHora, int horas) {
        super(nome, sobrenome, numeroConta);
        this.valorHora = valorHora;
        this.horas = horas;
    }

    @Override
    public double calcularPagamento() {
        return valorHora*horas;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Recibo digital");
        System.out.printf("O valor do recibo: R$ %.2f.\n", quantia);

    }
}
