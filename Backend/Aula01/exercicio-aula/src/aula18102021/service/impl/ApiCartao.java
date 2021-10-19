package aula18102021.service.impl;

import aula18102021.model.Cartao;

public class ApiCartao {
    public int desconto(Cartao cartao){
        if (cartao.getBanco().compareTo("Star Bank")==0){
            return 20;
        } else {
            return 0;
        }
    }
}
