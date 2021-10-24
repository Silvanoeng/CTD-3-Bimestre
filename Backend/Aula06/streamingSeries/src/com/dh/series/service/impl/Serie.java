package com.dh.series.service.impl;

import com.dh.series.service.ISerie;

public class Serie implements ISerie {

    @Override
    public String getSerie(String nome) {
        String nomeSemEsp = nome.replaceAll("\\s+","");
        return "www." + nomeSemEsp + ".com";
    }
}
