package com.example.clinica_odonto.repository.impl;

import com.example.clinica_odonto.dto.ConsultaDTO;
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
    private static Integer idGlobal=1;

    public ConsultaRepositoryImpl(){
        this.dentistaRepository = new DentistaRepositoryImpl();
        this.pacienteRepository = new PacienteRepositoryImpl();
    }


    @Override
    public Consulta salvar(Consulta consulta) {
        Paciente paciente = pacienteRepository.buscarPorId(consulta.getPaciente().getId());
        if(paciente == null)
            return null;

        Dentista dentista = dentistaRepository.buscarPorId(consulta.getDentista().getId());
        if(dentista == null)
            return null;

        consulta.setId(idGlobal);
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);
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

    @Override
    public Map<Integer, Consulta> buscarTodos() {
        if (consultaDTOMap != null) {
            Map<Integer, Consulta> consultaMap = new HashMap<>();
            for (Map.Entry<Integer, ConsultaDTO> itemDoFor : consultaDTOMap.entrySet()) {
                Consulta consulta = new Consulta(itemDoFor.getValue(), dentistaRepository.buscarPorId(itemDoFor.getValue().getIdDen()),
                        pacienteRepository.buscarPorId(itemDoFor.getValue().getIdPac()));
                consultaMap.put(itemDoFor.getKey(), consulta);
            }
            return consultaMap;
        }
        return null;
    }

    @Override
    public void deletar(Integer id) {
        consultaDTOMap.remove(id);
    }

    @Override
    public Consulta atualizar(Integer id, Consulta consultaAtualizar) {
        if(consultaAtualizar == null)
            return null;

        Consulta consultaBancoDeDados = buscarPorId(id);
        if (consultaAtualizar.getDentista() != null)
            consultaBancoDeDados.setDentista(consultaAtualizar.getDentista());
        if (consultaAtualizar.getPaciente() != null)
            consultaBancoDeDados.setPaciente(consultaAtualizar.getPaciente());
        if (consultaAtualizar.getDataHora() != null)
            consultaBancoDeDados.setDataHora(consultaAtualizar.getDataHora());
        ConsultaDTO consultaNova = new ConsultaDTO(consultaBancoDeDados);
        consultaDTOMap.put(id,consultaNova);
        return consultaBancoDeDados;
    }
}
