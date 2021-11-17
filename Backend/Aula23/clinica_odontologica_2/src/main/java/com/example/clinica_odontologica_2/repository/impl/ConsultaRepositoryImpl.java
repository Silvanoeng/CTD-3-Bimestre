package com.example.clinica_odontologica_2.repository.impl;


import com.example.clinica_odontologica_2.dto.ConsultaDTO;
import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public class ConsultaRepositoryImpl implements IRepository<Consulta> {
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
            return new Consulta(consultaDTO, dentistaRepository.buscarPorId(consultaDTO.getIdDen()),
                    pacienteRepository.buscarPorId(consultaDTO.getIdPac()));
        return null;
    }
}
