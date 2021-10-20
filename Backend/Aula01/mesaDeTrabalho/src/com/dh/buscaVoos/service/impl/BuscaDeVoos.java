package com.dh.buscaVoos.service.impl;

import com.dh.buscaVoos.model.Voos;

import java.time.LocalDate;
import java.util.List;

public class BuscaDeVoos {
    private List<Voos> voos;

    public BuscaDeVoos(List<Voos> voos) {
        this.voos = voos;
    }

    public void buscaVoos (String cidade, LocalDate ida){
        if (ida.isAfter(LocalDate.now())){
            int contBusca = 0;
            for (Voos voo:voos){
                if (voo.getDestino().equals(cidade)){
                    if (voo.getPartida().equals(ida)){
                        System.out.printf("O voo n° %04d atende sua solicitação.\n",voo.getIdVoo());
                        contBusca++;
                        System.out.println("------------------------//-----------------------");
                    }
                }

            }
            if (contBusca<1){
                System.out.println("Não foi encontrado nenhum voo compativel com sua solicitação.");
                System.out.println("------------------------//-----------------------");
            }
        } else {
            System.out.println("Por favor colocar uma data futura.");
            System.out.println("------------------------//-----------------------");
        }
    };

}
