package com.dh.governo.service.impl;

import com.dh.governo.service.Documentos;

public class Default extends Documentos {

    @Override
    public void conteudoDoDocumento(Integer tipoDeDocumento, String texto) {
        if (tipoDeDocumento>3) {
            System.out.println("Não foi possível classificar esse documento.");
        }
    }
}
