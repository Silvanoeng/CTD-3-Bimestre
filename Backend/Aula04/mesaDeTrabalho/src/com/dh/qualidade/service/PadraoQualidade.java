package com.dh.qualidade.service;

import com.dh.qualidade.model.Artigo;

public abstract class PadraoQualidade {
    protected PadraoQualidade verifica;

    public PadraoQualidade getVerifica() {
        return verifica;
    }

    public abstract void avaliarProduto(Artigo produto);

    public PadraoQualidade setVerifica (PadraoQualidade verifica) {
        this.verifica = verifica;
        return this;
    }
}


