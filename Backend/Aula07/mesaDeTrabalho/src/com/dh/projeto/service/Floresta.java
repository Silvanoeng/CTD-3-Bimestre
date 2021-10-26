package com.dh.projeto.service;

import java.util.ArrayList;
import java.util.List;

public class Floresta {
    private List<Arvore> floresta;
    private int numeroDeArvores;

    public Floresta() {
        this.floresta = new ArrayList<>();
        this.numeroDeArvores=0;
    }

    public void addArvore(Arvore arvore){
        this.numeroDeArvores++;
        this.floresta.add(arvore);

    }

    public void getNumeroDeArvores() {
        System.out.println("Esta floresta tem " + this.numeroDeArvores + " de arvores.");
    }
}
