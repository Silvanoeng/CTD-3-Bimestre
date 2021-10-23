package com.dh.streaming.service.impl;

import com.dh.streaming.componentes.Cliente;
import com.dh.streaming.componentes.Filme;
import com.dh.streaming.componentes.FilmeNaoHabilitadoException;
import com.dh.streaming.service.IGradeDeFilmes;

public class GradeDeFilmeProxy implements IGradeDeFilmes {
    private Cliente ipCliente;
    private GradeDeFilmes filmes;

    public GradeDeFilmeProxy(Cliente ipCliente, GradeDeFilmes filmes) {
        this.ipCliente = ipCliente;
        this.filmes = filmes;
    }

    @Override
    public Filme getFilme(String nome) {
        Filme filmeEscolhido=null;
            if (ipCliente.getIp01() >= 0 && ipCliente.getIp01() < 50) {
                GradeDeFilmes argentina = new GradeDeFilmes(filmes.getPais("Argentina"));
                return argentina.getFilme(nome);

            }
            if (ipCliente.getIp01() >= 50 && ipCliente.getIp01() < 100) {
                GradeDeFilmes brasil = new GradeDeFilmes(filmes.getPais("Brasil"));
                return brasil.getFilme(nome);
            }
            if (ipCliente.getIp01() >= 100 && ipCliente.getIp01() < 150) {
                GradeDeFilmes colombia = new GradeDeFilmes(filmes.getPais("Colombia"));
                return colombia.getFilme(nome);
            }
        return filmeEscolhido;
    }
}
