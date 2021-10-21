package com.dh.aula.service;

public abstract class Gerenciador {

    protected Gerenciador gerenciadorSeguinte;
    static int verificaSpam=1;

    public Gerenciador getGerenciadorSeguinte() {
        return gerenciadorSeguinte;
    }


    public void setGerenciadorSeguinte(Gerenciador gerenciadorSeguinte) {
        this.gerenciadorSeguinte = gerenciadorSeguinte;
    }
    public abstract void verificar(Mail mail);

    public void setVerificaSpamVerificaSpam(int num) {
        this.verificaSpam = num;
    }

}
