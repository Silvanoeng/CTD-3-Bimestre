package com.example.clinica_odonto.repository.impl;

import com.example.clinica_odonto.dto.ConsultaDTO;
import com.example.clinica_odonto.dto.DentistaDTO;
import com.example.clinica_odonto.model.Consulta;
import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.repository.IRepositoryDTO;
import java.util.HashMap;
import java.util.Map;

public class DentistaRepositoryImpl implements IRepositoryDTO<Dentista> {
    private static Map<Integer, DentistaDTO> dentistaDTOMap = new HashMap<>();
    private static Integer idGlobal=1;


    @Override
    public Dentista salvar(Dentista dentista) {
        dentista.setId(idGlobal);
        DentistaDTO dentistaDTO = new DentistaDTO(dentista);
        dentistaDTOMap.put(idGlobal, dentistaDTO);
        idGlobal++;
        return dentista;
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        DentistaDTO dentistaDTO = dentistaDTOMap.get(id);
        if (dentistaDTO != null)
            return new Dentista(dentistaDTO);

        return null;
    }

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        if (dentistaDTOMap != null) {
            Map<Integer, Dentista> dentistaMap = new HashMap<>();
            for (Map.Entry<Integer, DentistaDTO> itemDoFor : dentistaDTOMap.entrySet()) {
                Dentista dentista = new Dentista(itemDoFor.getValue());
                dentistaMap.put(itemDoFor.getKey(), dentista);
            }
            return dentistaMap;
        }
        return null;
    }

    @Override
    public void deletar(Integer id) {
        dentistaDTOMap.remove(id);
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
}
