package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.dto.DentistaDTO;
import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.repository.DentistaRepository;
import com.example.clinica_odonto.repository.impl.DentistaRepositoryImpl;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {
    private final DentistaRepository dentistaRepository;

    @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository){this.dentistaRepository = dentistaRepository;}

    @Override
    public DentistaDTO salvar(DentistaDTO dentistaDTO) {
        Dentista dentista = new Dentista(dentistaDTO);
        dentistaRepository.save(dentista);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO buscarPorId(Integer id) {
        return dentistaRepository.buscarPorId(id);
    }

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        return dentistaRepository.buscarTodos();
    }

    @Override
    public void deletar(Integer id) {
        dentistaRepository.deletar(id);
    }

    @Override
    public DentistaDTO atualizar(Integer id, Dentista dentista) {
        return dentistaRepository.atualizar( dentista);
    }

}
