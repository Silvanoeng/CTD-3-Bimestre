package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.repository.impl.DentistaRepositoryImpl;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {

    @Autowired
    private DentistaRepositoryImpl dentistaRepository;

    public DentistaServiceImpl(){this.dentistaRepository = new DentistaRepositoryImpl();}


    @Override
    public Dentista salvar(Dentista dentista) {
        return dentistaRepository.salvar(dentista);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        return dentistaRepository.buscarPorId(id);
    }

}
