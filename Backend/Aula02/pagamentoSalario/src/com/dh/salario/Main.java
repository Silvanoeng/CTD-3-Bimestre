package com.dh.salario;

import com.dh.salario.model.Contratado;
import com.dh.salario.model.Efetivo;
import com.dh.salario.model.Funcionario;

public class Main {

    public static void main(String[] args) {
        Funcionario funcionario = new Efetivo("Silvano", "Araujo", "123456", 2500.00, 125.00, 500.00);
        funcionario.pagamentoSalario();
        System.out.println("\n");
        funcionario = new Contratado("Maria", "Araujo", "123456", 110.00, 168);
        funcionario.pagamentoSalario();
    }
}
