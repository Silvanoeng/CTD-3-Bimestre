package com.example.clinica_daniel.service;

import java.util.List;
import java.util.Map;

public interface OdontoService<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
    List<T> buscarTodos();
    void deletar(Integer id);
    T atualizar(Integer id, T t);

}
