package com.dh.projeto;

import com.dh.projeto.service.Arvore;
import com.dh.projeto.service.ArvoreFactory;
import com.dh.projeto.service.Floresta;

public class MainSem {
    public static void main(String[] args) {
        ArvoreFactory verificaEAdiciona = new ArvoreFactory();

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

        Floresta nossaFloresta = new Floresta();
        for (int i=0; i<500000; i++ ){
            //Vermelho
            Arvore a1 = new Arvore("frutífera", 500, 300, "vermelho");
            nossaFloresta.addArvore(a1);
            //Verde
            Arvore a2 = new Arvore("ornamentais", 200, 400, "verde");
            nossaFloresta.addArvore(a2);
        }

        nossaFloresta.getNumeroDeArvores();

        runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }
}
