package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.repository.impl.PacienteRepositoryIMPL;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {

    @Autowired
    private PacienteRepositoryIMPL pacienteRepository;


    @Override
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.salvar(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteRepository.buscarPorId(id);
    }
}
