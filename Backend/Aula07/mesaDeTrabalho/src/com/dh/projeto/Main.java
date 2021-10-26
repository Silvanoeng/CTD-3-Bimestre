package com.dh.projeto;

import com.dh.projeto.service.ArvoreFactory;
import com.dh.projeto.service.Floresta;

public class Main {
    public static void main(String[] args) {
        ArvoreFactory verificaEAdiciona = new ArvoreFactory();

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

        Floresta nossaFloresta = new Floresta();
        for (int i=0; i<500000; i++ ){
            //Vermelho
            nossaFloresta.addArvore(verificaEAdiciona.getArvore("frutífera", 500, 300, "vermelho"));
            //Verde
            nossaFloresta.addArvore(verificaEAdiciona.getArvore("ornamentais", 200, 400, "verde"));
        }

        nossaFloresta.getNumeroDeArvores();

        runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }
}
