package com.dh.pagamento.service.impl;

import com.dh.pagamento.service.TipoDeCartao;

import java.time.LocalDate;

public class CartaoDebito extends TipoDeCartao {
    private LocalDate dataVencimento;
    private double saldoDisponivel;

    public CartaoDebito(LocalDate dataVencimento, double saldoDisponivel) {
        this.dataVencimento = dataVencimento;
        this.saldoDisponivel = saldoDisponivel;
    }

    @Override
    public void processadorCredito(double valor) {
        System.out.println("Esse cartão não tem esse serviço, aceita pagamentos apenas no débito.");
    }

    @Override
    public void processadorDebito(double valor) {
        if (this.saldoDisponivel>valor){
            System.out.println("Pagamento efetuado.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
