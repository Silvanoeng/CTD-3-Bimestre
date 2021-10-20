package com.dh.pagamento.service.impl;

import com.dh.pagamento.service.TipoDeCartao;

import java.time.LocalDate;

public class CartaoCredito extends TipoDeCartao {
    private double limite;
    private double saldoUtilizado;

    public CartaoCredito(LocalDate dataVencimento, double limite) {
        super(dataVencimento);
        this.limite = limite;
        this.saldoUtilizado = 0;
    }

    @Override
    public void processadorCredito(double valor) {
        if (saldoDisponivel()>valor) {
            this.saldoUtilizado +=valor;
            System.out.println("Pagamento efetuado.");
        } else {
            System.out.println("Limite insuficiente.");
        }
    }

    @Override
    public void processadorDebito(double valor) {
        System.out.println("Esse cartão não tem esse serviço, aceita pagamentos apenas no crédito.");
    }
    public double saldoDisponivel() {
        return this.limite-this.saldoUtilizado;
    }
}
