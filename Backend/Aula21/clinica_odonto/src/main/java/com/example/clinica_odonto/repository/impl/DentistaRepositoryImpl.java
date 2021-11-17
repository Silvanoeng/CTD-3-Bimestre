package com.example.clinica_odonto.repository.impl;

import com.example.clinica_odonto.dto.DentistaDTO;
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
}
