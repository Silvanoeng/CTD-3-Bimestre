package com.example.clinica_odonto.service;

import java.util.Map;

public interface OdontoService<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
    Map<Integer, T> buscarTodos();
    void deletar(Integer id);
    T atualizar(T t);
}
