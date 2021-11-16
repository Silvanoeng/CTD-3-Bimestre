package com.example.clinica_odonto.service;

public interface OdontoService<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
}
