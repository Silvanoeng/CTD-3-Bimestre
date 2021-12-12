package com.example.produto.service;

import com.example.produto.model.entities.ProdutoEntity;

import java.util.List;

public interface ProdutoService<T> {
    T salvar(T t);
    List<T> buscarTodos();
    void deletar(Integer id);
    void subtrairQuantidade(Integer id, Integer qt);

}
