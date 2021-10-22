package com.dh.qualidade.service.impl;

import com.dh.qualidade.model.Artigo;
import com.dh.qualidade.service.PadraoQualidade;

public class Lote extends PadraoQualidade {

    public void avaliarProduto(Artigo produto) {

        if (produto.getLote()>999 && produto.getLote()<2001){
            this.getVerifica().avaliarProduto(produto);
        }else {
            System.out.println("O lote está errado.");
        }

    }
}
