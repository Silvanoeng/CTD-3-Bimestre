package com.dh.service.impl;
import java.util.*;

public class RoupaFactory {
    public static final Map<String, Map<String, Roupa>> MODELOS_ROUPA = new HashMap<>();

    public static Roupa fabricarRoupa(String tamanho, String tipo, boolean nova, boolean importada){

        Roupa roupa = new Roupa(tamanho, tipo, nova, importada);

        if (!MODELOS_ROUPA.containsKey(tipo)){
            Map<String, Roupa> modelo = new HashMap<>();
            modelo.put(tamanho, roupa);
            MODELOS_ROUPA.put(tipo, modelo );
        } else {
            if(!MODELOS_ROUPA.get(tipo).containsKey(tamanho)) {
                MODELOS_ROUPA.get(tipo).put(tamanho, roupa);
            }
        }
        return roupa;
    }

    public static  int getTamanho(){ return MODELOS_ROUPA.size();}
    public static  int getpedidos(){
        for (int i=0; i<MODELOS_ROUPA.size(); i++){
            Set<String> busca = (MODELOS_ROUPA.keySet());
            busca.
        }
        return MODELOS_ROUPA.;}

    public static void relatorioFabrica(){
        System.out.println("O tamanho da fabrica é " + getTamanho() + " e tem " + getpedidos() + "pedidos.");
    }

    public static void listarTamanho(String tipo){


            System.out.println(MODELOS_ROUPA.get(tipo).toString());

    }



}
