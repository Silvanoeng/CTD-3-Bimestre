package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Consulta;
import com.example.clinica_odonto.repository.impl.ConsultaRepositoryImpl;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsultaServiceImpl implements OdontoService<Consulta> {
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

    @Override
    public Map<Integer, Consulta> buscarTodos() {
        return consultaRepository.buscarTodos();
    }

    @Override
    public void deletar(Integer id) {
        consultaRepository.deletar(id);
    }

    @Override
    public Consulta atualizar(Integer id, Consulta consulta) {
        return consultaRepository.atualizar(id, consulta);
    }
}
