package com.dh.buscaVoos.model;

import java.time.LocalDate;

public class Voos {
    private int idVoo;
    private String destino;
    private LocalDate partida;
    private static int cont=1;

    public Voos(String destino, LocalDate partida) {
        this.idVoo =cont++;
        this.destino = destino;
        this.partida = partida;

    }

    public int getIdVoo() {
        return idVoo;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getPartida() {
        return partida;
    }
}
