package com.dh.service.impl;
import java.util.HashMap;
import java.util.Map;

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

    public static void tamanhoFabrica(){
        System.out.println("O tamanho da fabrica é " + MODELOS_ROUPA.size() + ".");
    }

    public static void listarTamanho(String tipo){
        System.out.println(MODELOS_ROUPA.get(tipo).keySet());
        System.out.println(MODELOS_ROUPA.get(tipo).toString());
    }

}
