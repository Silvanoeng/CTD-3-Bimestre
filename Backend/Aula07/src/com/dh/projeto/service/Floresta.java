package com.dh.projeto.service;

import java.util.ArrayList;
import java.util.List;


public class Floresta {
    private List<Arvore> floresta;
    private List<String> cores;
    private int numeroDeArvores;


    public Floresta() {
        this.floresta = new ArrayList<>();
        this.cores = new ArrayList<>();
        this.numeroDeArvores=0;
    }

    public void addArvore(Arvore arvore){
        this.numeroDeArvores++;
        this.floresta.add(arvore);
        this.cores.add(arvore.getCor());
    }

    public void relatorioFloresta(String procuraCor){
        int contador=0;
        for (String cor: this.cores){
            if (cor.equalsIgnoreCase(procuraCor)){
                contador++;
            }
        }
        if (contador>0){
            System.out.println("Existem " + contador + " arvores na cor " + procuraCor + ", nesta floresta.");
        } else {
            System.out.println("Não existe arvores na cor " + procuraCor + ", nesta floresta.");
        }

    }

    public void getNumeroDeArvores() {
        System.out.println("Esta floresta tem " + this.numeroDeArvores + " de arvores.");
    }
}
