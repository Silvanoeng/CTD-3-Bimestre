package com.example.clinica_daniel.service.impl;

import com.example.clinica_daniel.dto.PacienteDTO;
import com.example.clinica_daniel.entity.EnderecoEntity;
import com.example.clinica_daniel.entity.PacienteEntity;
import com.example.clinica_daniel.repository.EnderecoRepository;
import com.example.clinica_daniel.repository.PacienteRepository;
import com.example.clinica_daniel.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements OdontoService<PacienteDTO> {
    private final PacienteRepository pacienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, EnderecoRepository enderecoRepository){
        this.pacienteRepository = pacienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public PacienteDTO salvar(PacienteDTO pacienteDTO) {
        EnderecoEntity endereco = enderecoRepository.getById(pacienteDTO.getIdEndereco());
        PacienteEntity paciente = new PacienteEntity(pacienteDTO, endereco);
        pacienteRepository.save(paciente);
        PacienteDTO pacienteDTOSaida = new PacienteDTO(paciente);
        return pacienteDTOSaida;
    }

    @Override
    public PacienteDTO buscarPorId(Integer id) {
        PacienteEntity paciente = pacienteRepository.getById(id);
        if (paciente != null) {
            PacienteDTO pacienteDTOSaida = new PacienteDTO(paciente);
            return pacienteDTOSaida;
        }
        return null;
    }

    @Override
    public List<PacienteDTO> buscarTodos() {
        List<PacienteEntity> listaPaciente = pacienteRepository.findAll();
        List<PacienteDTO> listaPacienteDTO = new ArrayList<>();
        if (listaPaciente != null){
            for (PacienteEntity pacienteEntity : listaPaciente){
                PacienteDTO pacienteDTO = new PacienteDTO(pacienteEntity);
                listaPacienteDTO.add(pacienteDTO);
            }
            return listaPacienteDTO;
        }
        return null;
    }

    @Override
    public void deletar(Integer id) { pacienteRepository.deleteById(id); }

    @Override
    public PacienteDTO atualizar(Integer id, PacienteDTO pacienteDTO) {

        PacienteDTO pacienteDTOBanco = buscarPorId(id);
        if (pacienteDTOBanco == null)
            return null;

        EnderecoEntity endereco = enderecoRepository.getById(pacienteDTOBanco.getIdEndereco());

        PacienteEntity pacienteMudancas = new PacienteEntity(pacienteDTO, endereco);
        PacienteEntity pacienteAtualizado = new PacienteEntity(pacienteDTOBanco, endereco);
        if (pacienteMudancas.getNome() != null)
            pacienteAtualizado.setNome(pacienteMudancas.getNome());
        if (pacienteMudancas.getSobrenome() != null)
            pacienteAtualizado.setSobrenome(pacienteMudancas.getSobrenome());
        if (pacienteMudancas.getCpf() != null)
            pacienteAtualizado.setCpf(pacienteMudancas.getCpf());
        if (pacienteMudancas.getEmail() != null)
            pacienteAtualizado.setEmail(pacienteMudancas.getEmail());

        PacienteDTO pacienteDTOAtualizado = new PacienteDTO(pacienteRepository.saveAndFlush(pacienteAtualizado));

        return pacienteDTOAtualizado;
    }
}
