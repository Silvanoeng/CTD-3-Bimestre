package com.dh.conta.service.impl;

import com.dh.conta.service.ISaque;

public class Saque implements ISaque {
    private AuthenticationService auth;
    private ContaService conta;
    private CaixaService valor;

    public Saque() {
        this.auth = new AuthenticationService();
        this.conta = new ContaService();
        this.valor = new CaixaService();
    }

    @Override
    public void saque(int id, String senha, double valor) {
        if (auth.validateUserAndPassword(id,senha)) {
            conta.getConta(id)
        }
    }
}
