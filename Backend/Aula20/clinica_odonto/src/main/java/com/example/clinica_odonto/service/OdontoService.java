package com.example.clinica_odonto.service;

import java.util.Map;

public interface OdontoService<T> {
    T salvar(T t);
    Map<Integer, T> buscarTodos();
    T buscar(Integer id);
    T atualizar(Integer id, String nome);
    void deletar(Integer id);
}
