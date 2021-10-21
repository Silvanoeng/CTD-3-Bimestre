package com.dh.aula.service;

public class GerenciadorSpam extends Gerenciador {

    @Override
    public void verificar(Mail mail) {
        if (verificaSpam==1){
            System.out.println("Marcado como spam.");
        }
    }
}
