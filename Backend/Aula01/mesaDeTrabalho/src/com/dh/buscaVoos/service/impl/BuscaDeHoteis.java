package com.dh.buscaVoos.service.impl;

import com.dh.buscaVoos.model.Hotel;
import com.dh.buscaVoos.model.Voos;

import java.time.LocalDate;
import java.util.List;

public class BuscaDeHoteis {
    private List<Hotel> hoteis;

    public BuscaDeHoteis(List<Hotel> hoteis) {
        this.hoteis = hoteis;
    }

    public void buscaHoteis (String cidade, LocalDate dataInicio, LocalDate datafinal){
        if (dataInicio.isAfter(LocalDate.now()) && datafinal.isAfter(dataInicio)){
            int contBusca = 0;
            for (Hotel hotel:hoteis){
                if (hotel.getDestino().equals(cidade)){
                    if (dataInicio.isAfter(hotel.getDataInicio()) && datafinal.isBefore(hotel.getDataFinal())){
                        System.out.printf("O hotel %s atende sua solicitação.\n",hotel.getNome());
                        contBusca++;
                        System.out.println("------------------------//-----------------------");
                    }
                }
            }
            if (contBusca<1){
                System.out.println("Não foi encontrado nenhum hotel compativel com sua solicitação.");
                System.out.println("------------------------//-----------------------");
            }
        } else {
            System.out.println("Por favor colocar uma data futura.");
            System.out.println("------------------------//-----------------------");
        }
    };
}
