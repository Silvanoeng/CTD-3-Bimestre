package com.dh.qualidade.service;

import com.dh.qualidade.model.Artigo;
import com.dh.qualidade.service.impl.Embalogem;
import com.dh.qualidade.service.impl.Lote;
import com.dh.qualidade.service.impl.Peso;

public class CheckQuality {
    PadraoQualidade analisa;

    public CheckQuality () {
        this.analisa = new Lote();
        PadraoQualidade peso = new Peso();
        PadraoQualidade emvalagem = new Embalogem();

        analisa.setVerifica(peso);
        peso.setVerifica(emvalagem);
    }
    public void verificarQualidade (Artigo produto) {
        this.analisa.avaliarProduto(produto);}
}
