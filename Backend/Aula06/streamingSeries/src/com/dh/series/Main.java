package com.dh.series;

import com.dh.series.service.ISerie;
import com.dh.series.service.impl.SerieNaoHabilitadaException;
import com.dh.series.service.impl.SerieProxy;

public class Main {
    public static void main(String[] args) {

        try{
            ISerie netflixSerie = new SerieProxy();
            System.out.println(netflixSerie.getSerie("Yu Yu Hakusho"));
            System.out.println(netflixSerie.getSerie("Yu Yu Hakusho"));
            System.out.println(netflixSerie.getSerie("Yu Yu Hakusho"));
            System.out.println(netflixSerie.getSerie("Yu Yu Hakusho"));
            System.out.println(netflixSerie.getSerie("Yu Yu Hakusho"));
            System.out.println(netflixSerie.getSerie("Yu Yu Hakusho"));
        } catch (SerieNaoHabilitadaException e) {
            System.out.println(e.getMessage());
        }
    }
}
