package com.dh.vacina.service.impl;

import com.dh.vacina.componente.Pessoa;
import com.dh.vacina.service.IRegistro;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class VacinarProxy implements IRegistro {
    private Vacinar vacinar;


    @Override
    public void vacinar(Pessoa pessoa) {

        if (!pessoa.getDataVacina().isBefore(LocalDate.now())){
            vacinar =new Vacinar();
            vacinar.vacinar(pessoa);
        } else {
            System.out.println("Seu dia de vacinação ainda não chegou.");
        }

    }
}
