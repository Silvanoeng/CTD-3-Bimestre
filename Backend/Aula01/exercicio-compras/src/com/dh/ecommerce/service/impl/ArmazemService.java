package com.dh.ecommerce.service.impl;

import com.dh.ecommerce.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ArmazemService {
    private List<Produto> produtos;

    public ArmazemService() {
        this.produtos =new ArrayList<>();
    }

    public ArmazemService(List<Produto> prod) {
        this.produtos =new ArrayList<>();
        for (Produto produto: prod) {
          addProduto(produto);
        }
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }
    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public Produto buscarProduto(String produtoId, Integer quantidade) {
        Produto produto = null;
        for (Produto p : this.produtos) {
            if (p.getProdutoId().equals(produtoId) && p.getQuantidade() >= quantidade) {
                produto = p;
                p.setQuantidade(p.getQuantidade() - quantidade); // atualizamos a quantidade
            }

        }

        return produto;

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : this.produtos) {
            sb.append(produto +"\n");
        }
        return  sb.toString();
    }
}
