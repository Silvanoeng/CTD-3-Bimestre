package com.dh.qualidade;

import com.dh.qualidade.model.Artigo;
import com.dh.qualidade.service.CheckQuality;


public class Main {
    public static void main(String[] args) {
        Artigo prod01 = new Artigo("Carne", 1002, 1210, "saudável" );
        Artigo prod02 = new Artigo("Arroz", 1002, 1210, "normal" );
        Artigo prod03 = new Artigo("Massa", 1002, 1310, "saudável" );

        CheckQuality teste01 = new CheckQuality();
        teste01.avaliarProduto(prod01);
        teste01.avaliarProduto(prod02);
        teste01.avaliarProduto(prod03);

    }


}
