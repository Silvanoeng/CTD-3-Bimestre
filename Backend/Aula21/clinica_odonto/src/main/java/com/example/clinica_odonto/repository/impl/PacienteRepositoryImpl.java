package com.example.clinica_odonto.repository.impl;

import com.example.clinica_odonto.dto.DentistaDTO;
import com.example.clinica_odonto.dto.PacienteDTO;
import com.example.clinica_odonto.model.Dentista;
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

    }
}
    @Override
    public Dentista atualizar(Integer id, Dentista dentistaAtualizar) {
        if (dentistaAtualizar == null)
            return null;

        Dentista dentistaBancoDeDados = buscarPorId(id);
        if (dentistaAtualizar.getMatricula() != null)
            dentistaBancoDeDados.setMatricula(dentistaAtualizar.getMatricula());
        if (dentistaAtualizar.getNome() != null)
            dentistaBancoDeDados.setNome(dentistaAtualizar.getNome());
        if (dentistaAtualizar.getSobrenome() != null)
            dentistaBancoDeDados.setSobrenome(dentistaAtualizar.getSobrenome());
        DentistaDTO dentistaNovo = new DentistaDTO(dentistaBancoDeDados);
        dentistaDTOMap.put(id, dentistaNovo);
        return dentistaBancoDeDados;
    }