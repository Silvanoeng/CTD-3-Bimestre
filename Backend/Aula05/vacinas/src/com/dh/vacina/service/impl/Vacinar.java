package com.dh.vacina.service.impl;

import com.dh.vacina.componente.Pessoa;
import com.dh.vacina.service.IRegistro;

import java.time.LocalDate;


public class Vacinar implements IRegistro {


    public void vacinar(Pessoa pessoa){
        System.out.println(pessoa.getNome() + " fez a vacina " + pessoa.getNomeVacina() + " em " + LocalDate.now());
    }
}
