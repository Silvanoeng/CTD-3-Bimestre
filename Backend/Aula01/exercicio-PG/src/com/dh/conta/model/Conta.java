package com.dh.conta.model;

import com.dh.conta.service.impl.AuthenticationService;

public class Conta {
    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return this.cliente.getId();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
