package com.dh.aula.service;

public class CheckMail {
    Gerenciador inicial;

    public CheckMail () {
        this.inicial = new GerenciadorGerencia();
        Gerenciador tecnico = new GerenciadorTecnico();
        Gerenciador comercial = new GerenciadorComercial();
        Gerenciador spam = new GerenciadorSpam();

        inicial.setGerenciadorSeguinte(tecnico);
        tecnico.setGerenciadorSeguinte(comercial);
        comercial.setGerenciadorSeguinte(spam);

    }

    public void verificar (Mail mail) {
        inicial.verificar(mail);
    }
}
