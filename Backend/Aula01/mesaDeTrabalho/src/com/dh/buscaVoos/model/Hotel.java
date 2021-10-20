package com.dh.buscaVoos.model;

import java.time.LocalDate;

public class Hotel {
    private String nome;
    private String destino;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public Hotel(String nome, String destino, LocalDate dataFinal) {
        this.nome = nome;
        this.destino = destino;
        this.dataInicio = LocalDate.now();
        this.dataFinal = dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }
}
