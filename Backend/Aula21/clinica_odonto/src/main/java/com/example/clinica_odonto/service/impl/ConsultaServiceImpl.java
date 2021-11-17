package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Consulta;
import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.repository.impl.ConsultaRepositoryImpl;
import com.example.clinica_odonto.repository.impl.PacienteRepositoryImpl;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl implements OdontoService<Consulta> {

    @Autowired
    private ConsultaRepositoryImpl consultaRepository;

    public ConsultaServiceImpl(){this.consultaRepository = new ConsultaRepositoryImpl();}


    @Override
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.salvar(consulta);
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        return consultaRepository.buscarPorId(id);
    }
}
