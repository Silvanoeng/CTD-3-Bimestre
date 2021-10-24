package com.dh.series.service.impl;

import com.dh.series.service.ISerie;

public class SerieProxy implements ISerie {
    private int qtdViewa;
    private Serie serie;

    public SerieProxy() {
        this.qtdViewa = 1;
        this.serie = new Serie();
    }

    public int getQtdViewa() {
        return qtdViewa;
    }

    public void setQtdViewa() {
        this.qtdViewa ++;
    }

    @Override
    public String getSerie(String nome) {
        if (this.getQtdViewa()<6){
            this.setQtdViewa();
            return this.serie.getSerie(nome);
        }
        throw new SerieNaoHabilitadaException("Você atingiu o seu limite de visualização essa semana.");
    }
}
