package com.dh.buscaVoos;

import com.dh.buscaVoos.model.Hotel;
import com.dh.buscaVoos.model.Voos;
import com.dh.buscaVoos.service.Ibuscador;
import com.dh.buscaVoos.service.impl.BuscaDeHoteis;
import com.dh.buscaVoos.service.impl.BuscaDeVoos;
import com.dh.buscaVoos.service.impl.Buscador;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Hotel h01 = new Hotel("Rainha do Mar", "Natal", LocalDate.of(2022,11,1));
        Hotel h02 = new Hotel("Rei do Oceano", "Salvador", LocalDate.of(2022,11,01));
        Hotel h03 = new Hotel("Mar Azul", "Natal", LocalDate.of(2022,1,1));
        Hotel h04 = new Hotel("Rainha do Mar", "Salvador", LocalDate.of(2022,1,1));
        Hotel h05 = new Hotel("Rainha do Mar", "Salvador", LocalDate.of(2022,6,1));

        Voos v01 = new Voos("Natal", LocalDate.of(2021,10,20));
        Voos v02 = new Voos("Natal", LocalDate.of(2021,12,1));
        Voos v03 = new Voos("Natal", LocalDate.of(2021,10,20));
        Voos v04 = new Voos("Salvador", LocalDate.of(2021,10,20));
        Voos v05 = new Voos("Salvador", LocalDate.of(2021,12,1));
        Voos v06 = new Voos("Salvador", LocalDate.of(2021,10,20));

        Ibuscador bc = new Buscador(new BuscaDeVoos(Arrays.asList(v01,v02,v03,v04,v05,v06)), new BuscaDeHoteis(Arrays.asList(h01,h02,h03,h04,h05)));

        System.out.println("Busca 01");
        bc.fazerBusca("Salvador", LocalDate.of(2021, 10, 20), LocalDate.of(2022, 7, 12));

        System.out.println("Busca 02");
        bc.fazerBusca("Salvador", LocalDate.of(2021, 9, 20), LocalDate.of(2022, 7, 12));

        System.out.println("Busca 03");
        bc.fazerBusca("Natal", LocalDate.of(2021, 10, 20), LocalDate.of(2022, 5, 12));

        System.out.println("Busca 04");
        bc.fazerBusca("Natal", LocalDate.of(2021, 9, 20), LocalDate.of(2022, 7, 12));

    }
}
