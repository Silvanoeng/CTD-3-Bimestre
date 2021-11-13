package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {
    private static Map<Integer, Paciente> pacienteMap =new HashMap<>();
    private static int idGlobal=1;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Override
    public Paciente salvar(Paciente paciente) {
        paciente.setEndereco(enderecoService.salvar(paciente.getEndereco()));
        paciente.setId(idGlobal);
        paciente.setIdEndereco(paciente.getEndereco().getId());
        pacienteMap.put(paciente.getId(), paciente);
        idGlobal++;
        return paciente;
    }

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        return pacienteMap;
    }

    @Override
    public Paciente buscar(Integer id) {
        Paciente paciente = pacienteMap.get(id);
        paciente.setEndereco(enderecoService.buscar(paciente.getIdEndereco()));

//        Integer idEndereco = paciente.getIdEndereco();
//        Endereco endereco= enderecoService.buscar(idEndereco);
//        paciente.setEndereco(endereco);
        return paciente;
    }

    @Override
    public Paciente atualizar(Integer id, String nome) {
        Paciente paciente = buscar(id);
        paciente.setNome(nome);
        return paciente;
    }

    @Override
    public void deletar(Integer id) {
        pacienteMap.remove(id);

    }
}
