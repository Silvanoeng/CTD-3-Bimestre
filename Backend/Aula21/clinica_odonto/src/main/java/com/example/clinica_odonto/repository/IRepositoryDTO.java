package com.example.clinica_odonto.repository;

public interface IRepositoryDTO<T>{
    T salvar(T t);
    T buscarPorId(Integer id);
}
