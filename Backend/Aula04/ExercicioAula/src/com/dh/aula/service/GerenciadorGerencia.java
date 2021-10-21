package com.dh.aula.service;

public class GerenciadorGerencia extends Gerenciador{

    public void verificar(Mail mail) {
        verificaSpam=1;
        if ((mail.getDestino().equalsIgnoreCase("gerencia@colmeia.com")) ||
        (mail.getAssunto().equalsIgnoreCase("Gerencia"))){
            System.out.println("Enviado ao departamento gerencial.");
            verificaSpam=2;
            this.getGerenciadorSeguinte().verificar(mail);
        } else {
            if(this.getGerenciadorSeguinte()!=null) {
                this.getGerenciadorSeguinte().verificar(mail);
            }
        }
    }
}
