package com.dh.streaming.service.impl;

import com.dh.streaming.componentes.Filme;
import com.dh.streaming.service.IGradeDeFilmes;

import java.util.ArrayList;
import java.util.List;

public class GradeDeFilmes implements IGradeDeFilmes {
    private List<Filme> filmes;

    public GradeDeFilmes() {
        this.filmes = new ArrayList<>();
    }

    public GradeDeFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void addFilme(Filme filme){
        this.filmes.add(filme);
    }
    public List<Filme> getPais(String pais) {
        List<Filme> filmesPais = new ArrayList<>();
        for (Filme filme: filmes) {
            if (filme.getPais().equalsIgnoreCase(pais)){
                filmesPais.add(filme);
            }
        }
        return filmesPais;
    }

    @Override
    public Filme getFilme(String nome) {
        Filme filmeEscolhido=null;
        for (Filme filme: filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)){
                return filme;
            }
        }
        return filmeEscolhido;
    }

}
