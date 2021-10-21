package com.dh.aula.service;

public class GerenciadorTecnico extends Gerenciador{

    public void verificar(Mail mail) {
        if ((mail.getDestino().equalsIgnoreCase("tecnico@colmeia.com")) ||
        (mail.getAssunto().equalsIgnoreCase("Tecnico"))){
            System.out.println("Enviado ao departamento tecnico.");
            verificaSpam=2;
            this.getGerenciadorSeguinte().verificar(mail);
        } else {
            if(this.getGerenciadorSeguinte()!=null) {
                this.getGerenciadorSeguinte().verificar(mail);
            }
        }
    }
}
