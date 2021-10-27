package com.dh.vacina;

import com.dh.vacina.componente.Pessoa;
import com.dh.vacina.service.IRegistro;
import com.dh.vacina.service.impl.VacinarProxy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa01 = new Pessoa("Silvano", "Araujo", "123456789", "Pfizer", LocalDate.of(2021, 10, 26));
        IRegistro validar = new VacinarProxy();
        validar.vacinar(pessoa01);

    }
}
