package com.example.clinica_odonto.repository;

import java.util.Map;

public interface IRepositoryDTO<T>{
    T salvar(T t);
    T buscarPorId(Integer id);
    Map<Integer, T> buscarTodos();
    void deletar(Integer id);
    T atualizar(Integer id, T t);

}
