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

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        if (pacienteDTOMap != null) {
            Map<Integer, Paciente> pacienteMap = new HashMap<>();
            for (Map.Entry<Integer, PacienteDTO> itemdoFor : pacienteDTOMap.entrySet()) {
                Paciente paciente = new Paciente(itemdoFor.getValue(), enderecoRepository.buscarPorId(itemdoFor.getValue().getIdEndereco()));
                pacienteMap.put(itemdoFor.getKey(), paciente);
            }
            return pacienteMap;
        }
        return null;
    }

    @Override
    public void deletar(Integer id) {
        Paciente pacienteDeletar = buscarPorId(id);
        enderecoRepository.deletar(pacienteDeletar.getEndereco().getId());
        pacienteDTOMap.remove(id);
    }

    @Override
    public Paciente atualizar(Integer id, Paciente pacienteAtualizar) {
        if (pacienteAtualizar == null)
            return null;

        Paciente pacienteBancoDeDados = buscarPorId(id);
        if (pacienteAtualizar.getNome() != null)
            pacienteBancoDeDados.setNome(pacienteAtualizar.getNome());
        if (pacienteAtualizar.getSobrenome() != null)
            pacienteBancoDeDados.setSobrenome(pacienteAtualizar.getSobrenome());
        if (pacienteAtualizar.getCpf() != null)
            pacienteBancoDeDados.setCpf(pacienteAtualizar.getCpf());
        if (pacienteAtualizar.getEmail() != null)
            pacienteBancoDeDados.setEmail(pacienteAtualizar.getEmail());
        if (pacienteAtualizar.getEndereco() != null)
            enderecoRepository.atualizar(pacienteBancoDeDados.getEndereco().getId(), pacienteAtualizar.getEndereco());
        PacienteDTO pacienteNovo = new PacienteDTO(pacienteBancoDeDados);
        pacienteDTOMap.put(id, pacienteNovo);
        return pacienteBancoDeDados;
    }
}
