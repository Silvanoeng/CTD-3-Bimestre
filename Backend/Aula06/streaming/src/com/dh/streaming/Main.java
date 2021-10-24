package com.dh.streaming;

import com.dh.streaming.componentes.Cliente;
import com.dh.streaming.componentes.Filme;
import com.dh.streaming.componentes.FilmeNaoHabilitadoException;
import com.dh.streaming.service.IGradeDeFilmes;
import com.dh.streaming.service.impl.GradeDeFilmeProxy;
import com.dh.streaming.service.impl.GradeDeFilmes;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Filme f01 = new Filme("Amor a dois", "Argentina", "www.filmes.com/AmorADois");
        Filme f02 = new Filme("O terror", "Argentina", "www.filmes.com/OTerror");
        Filme f03 = new Filme("Fulga do planeta", "Argentina", "www.filmes.com/FulgaDoPlaneta");
        Filme f04 = new Filme("Amor a dois", "Brasil", "www.filmes.com/AmorADois");
        Filme f05 = new Filme("Um dia", "Brasil", "www.filmes.com/UmDia");
        Filme f06 = new Filme("O sonho", "Brasil", "www.filmes.com/OSonho");
        Filme f07 = new Filme("Zumbi 2", "Brasil", "www.filmes.com/Zumbi2");
        Filme f08 = new Filme("Zumbi 3", "Brasil", "www.filmes.com/Zumbi3");
        Filme f09 = new Filme("Amor a dois", "Colombia", "www.filmes.com/AmorADois");
        Filme f10 = new Filme("Outra vida", "Colombia", "www.filmes.com/OutraVida");
        Filme f11 = new Filme("Popo", "Colombia", "www.filmes.com/Popo");
        Filme f12 = new Filme("Nunca mais", "Colombia", "www.filmes.com/NuncaMais");
        Filme f13 = new Filme("Um dia nosso", "Colombia", "www.filmes.com/UmDiaNosso");
        Filme f14 = new Filme("Zumbi 2", "Colombia", "www.filmes.com/Zumbi2");
        Filme f15 = new Filme("Zumbi 3", "Colombia", "www.filmes.com/Zumbi3");
        GradeDeFilmes netFlix = new GradeDeFilmes(Arrays.asList(f01, f02, f03, f04, f05, f06, f07, f08, f09, f10, f11, f12, f13, f14, f15));

        Cliente cl01 = new Cliente(20, 100, 200, 122);
        IGradeDeFilmes buscador01 = new GradeDeFilmeProxy(cl01,netFlix);
        try {
            System.out.println("Cliente 01:\n" +buscador01.getFilme("Zumbi 2").getLinkDeReproducao());
        } catch (FilmeNaoHabilitadoException e) {
            System.out.println("Cliente 01:\n" + e.getMessage());
        }

        Cliente cl02 = new Cliente(70, 100, 200, 122);
        IGradeDeFilmes buscador02 = new GradeDeFilmeProxy(cl02,netFlix);
        try {
            System.out.println("Cliente 02:\n" +buscador02.getFilme("Zumbi 2").getLinkDeReproducao());
        } catch (FilmeNaoHabilitadoException e) {
            System.out.println("Cliente 02:\n" + e.getMessage());
        }

        Cliente cl03 = new Cliente(120, 100, 200, 122);
        IGradeDeFilmes buscador03 = new GradeDeFilmeProxy(cl03,netFlix);
        try {
            System.out.println("Cliente 03:\n" +buscador03.getFilme("Zumbi 2").getLinkDeReproducao());
        } catch (FilmeNaoHabilitadoException e) {
            System.out.println("Cliente 03:\n" + e.getMessage());
        }
    }
}
