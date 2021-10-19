package com.dh.conta.service.impl;

import com.dh.conta.model.Cliente;
import com.dh.conta.model.Conta;

import java.util.List;

public class ContaService {
    private List<Conta> contas;

    public double getConta(int id) {
        double saldo=0.0;
        for (Conta conta : contas){
            if (conta.getIdCliente()==id){
                saldo = conta.getSaldo();
            }
        }
        return saldo;
    }
}
