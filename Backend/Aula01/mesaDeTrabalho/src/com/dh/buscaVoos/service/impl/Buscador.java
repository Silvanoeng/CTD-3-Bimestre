package com.dh.buscaVoos.service.impl;

import com.dh.buscaVoos.service.Ibuscador;

import java.time.LocalDate;

public class Buscador implements Ibuscador {
    private BuscaDeVoos voos;
    private BuscaDeHoteis hoteis;

    public Buscador(BuscaDeVoos voos, BuscaDeHoteis hoteis) {
        this.voos = voos;
        this.hoteis = hoteis;
    }

    public void fazerBusca (String cidade, LocalDate ida, LocalDate volta){
        this.voos.buscaVoos(cidade,ida);
        this.hoteis.buscaHoteis(cidade, ida, volta);
    };
}
