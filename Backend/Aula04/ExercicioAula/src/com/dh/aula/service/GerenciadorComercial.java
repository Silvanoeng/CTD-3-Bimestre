package com.dh.aula.service;

public class GerenciadorComercial extends Gerenciador{

    public void verificar(Mail mail) {
        if ((mail.getDestino().equalsIgnoreCase("comercial@colmeia.com")) ||
        (mail.getAssunto().equalsIgnoreCase("Comercial"))){
            System.out.println("Enviado ao departamento comercial.");
            verificaSpam=2;
            this.getGerenciadorSeguinte().verificar(mail);
        } else {
            if(this.getGerenciadorSeguinte()!=null) {
                this.getGerenciadorSeguinte().verificar(mail);
            }
        }
    }
}
