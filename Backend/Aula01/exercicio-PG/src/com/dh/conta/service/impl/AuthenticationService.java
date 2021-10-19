package com.dh.conta.service.impl;

import com.dh.conta.model.Cliente;
import com.dh.conta.model.Conta;

import java.util.List;

public class AuthenticationService {
    private List<Cliente> clientes;


    public boolean validateUserAndPassword(int id, String senha) {
        boolean validar=false;
        for (Cliente cliente : clientes){
            if (cliente.getId()==id){
                if (cliente.getSenha().compareTo(senha)==0){
                    validar=true;
                }
            }
        }
        return validar;
    }

}
