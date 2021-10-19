package aula18102021.service;

import aula18102021.model.Cartao;
import aula18102021.model.Produto;

public interface IFachadaDesconto {

    public int desconto(Cartao cartao, Produto produto, int quantidade);
}
