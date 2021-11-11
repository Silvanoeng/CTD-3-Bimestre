package com.example.clinica_odonto.service;

import com.example.clinica_odonto.model.Paciente;

import java.util.Map;

public interface PacienteService {
    Paciente criarPaciente();
    Map<Integer, Paciente> buscarPacientes();
    Paciente buscarPaciente(Integer id);
    Paciente atualizarPaciente(Integer id, String nome);
    void deletar(Integer id);

}
