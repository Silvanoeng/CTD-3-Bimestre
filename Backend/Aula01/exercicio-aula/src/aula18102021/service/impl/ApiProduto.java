package aula18102021.service.impl;

import aula18102021.model.Produto;

public class ApiProduto {
    public int desconto(Produto produto) {
        if (produto.getTipo().compareTo("Lata")==0){
            return 10;
        }
        return 0;
    }
}
