package com.dh.buscaVoos.service;

import java.time.LocalDate;

public interface Ibuscador {

    public void fazerBusca (String cidade, LocalDate ida, LocalDate volta);
}
