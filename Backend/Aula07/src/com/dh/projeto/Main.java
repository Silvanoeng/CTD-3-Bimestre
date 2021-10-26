package com.dh.projeto;

import com.dh.projeto.service.Arvore;
import com.dh.projeto.service.ArvoreFactory;
import com.dh.projeto.service.Floresta;

public class Main {
    public static void main(String[] args) {
        ArvoreFactory verificaEAdiciona = new ArvoreFactory();
        Arvore vermelho = new  Arvore("frutífera", 500, 300, "vermelho");
        Arvore verde = new Arvore("ornamentais", 200, 400, "verde");

        Floresta nossaFloresta = new Floresta();
        for (int i=0; i<500000; i++ ){

            nossaFloresta.addArvore(vermelho);
            nossaFloresta.addArvore(verde);

//            nossaFloresta.addArvore(verificaEAdiciona.getArvore("frutífera", 500, 300, "vermelho"));
//            nossaFloresta.addArvore(verificaEAdiciona.getArvore("ornamentais", 200, 400, "verde"));
        }
        nossaFloresta.relatorioFloresta("verde");
        nossaFloresta.relatorioFloresta("vermelho");
        nossaFloresta.getNumeroDeArvores();

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }
}
