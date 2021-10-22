package com.dh.qualidade.service.impl;

import com.dh.qualidade.model.Artigo;
import com.dh.qualidade.service.PadraoQualidade;

public class Embalogem extends PadraoQualidade {

    public void avaliarProduto(Artigo produto) {
        if (produto.getEmbalagem().equalsIgnoreCase("saudável") ||
                produto.getEmbalagem().equalsIgnoreCase("quase saudável")){
            System.out.println("O produto foi aceito.");
        }else {
            System.out.println("A embalagem está errada.");
        }
    }
}
