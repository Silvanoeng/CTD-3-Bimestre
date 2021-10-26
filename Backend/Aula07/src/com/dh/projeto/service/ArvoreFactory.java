package com.dh.projeto.service;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {
    private static Map<String, Arvore> ARVORE;

    public ArvoreFactory() {
        ARVORE=new HashMap<>();
    }

    public Arvore getArvore(String tipo, int altura, int largura, String cor){
        String key="arvore do tipo " + tipo + ", com uma altura de " + altura + ", largura de " + largura + " e cor " + cor;
        if (!ARVORE.containsKey(key)){
            ARVORE.put(key, new Arvore(tipo,altura,largura,cor));
            System.out.println("A " + key + ", foi criada e adicionada.");
            return ARVORE.get(key);
        }
        return ARVORE.get(key);

    }
}
