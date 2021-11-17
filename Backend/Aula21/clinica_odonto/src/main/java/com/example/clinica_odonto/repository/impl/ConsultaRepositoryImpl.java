package com.example.clinica_odonto.repository.impl;

import com.example.clinica_odonto.dto.ConsultaDTO;
import com.example.clinica_odonto.dto.PacienteDTO;
import com.example.clinica_odonto.model.Consulta;
import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.repository.IRepositoryDTO;

import java.util.HashMap;
import java.util.Map;

public class ConsultaRepositoryImpl implements IRepositoryDTO<Consulta> {
    private static Map<Integer, ConsultaDTO> consultaDTOMap = new HashMap<>();
    private DentistaRepositoryImpl dentistaRepository;
    private PacienteRepositoryImpl pacienteRepository;
    private EnderecoRepositoryImpl enderecoRepository;
    private static Integer idGlobal=1;


    @Override
    public Consulta salvar(Consulta consulta) {
        consulta.setId(idGlobal);
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
        consultaDTOMap.put(idGlobal, consultaDTO);
        idGlobal++;
        return consulta;
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        ConsultaDTO consultaDTO = consultaDTOMap.get(id);
        if(consultaDTO != null)
            return new Consulta(consultaDTO, new Dentista(dentistaRepository.buscarPorId(consultaDTO.getIdDen())),
                    new Paciente(pacienteRepository.buscarPorId(consultaDTO.getIdPac()), enderecoRepository.buscarPorId(pacienteRepository.buscarPorId(consultaDTO.getIdPac()))));
        return null;
    }
}
