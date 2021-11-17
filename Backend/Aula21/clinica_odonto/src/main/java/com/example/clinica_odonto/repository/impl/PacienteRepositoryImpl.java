package com.example.clinica_odonto.repository.impl;

import com.example.clinica_odonto.dto.PacienteDTO;
import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.repository.IRepositoryDTO;
import java.util.HashMap;
import java.util.Map;

public class PacienteRepositoryImpl implements IRepositoryDTO<Paciente> {
    private static Map<Integer, PacienteDTO> pacienteDTOMap = new HashMap<>();
    private EnderecoRepositoryImpl enderecoRepository;
    private static Integer idGlobal=1;

    public PacienteRepositoryImpl(){
        this.enderecoRepository = new EnderecoRepositoryImpl();
    }

    @Override
    public Paciente salvar(Paciente paciente) {

        paciente.setEndereco(enderecoRepository.salvar(paciente.getEndereco()));
        paciente.setId(idGlobal);
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);
        pacienteDTOMap.put(idGlobal, pacienteDTO);
        idGlobal++;
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        PacienteDTO pacienteDTO = pacienteDTOMap.get(id);
        if(pacienteDTO != null)
            return new Paciente(pacienteDTO, enderecoRepository.buscarPorId(pacienteDTO.getIdEndereco()));

        return null;
    }
}
