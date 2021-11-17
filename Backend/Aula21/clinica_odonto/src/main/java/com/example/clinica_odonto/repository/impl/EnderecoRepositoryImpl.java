package com.example.clinica_odonto.repository.impl;

import com.example.clinica_odonto.dto.EnderecoDTO;
import com.example.clinica_odonto.model.Endereco;
import com.example.clinica_odonto.repository.IRepositoryDTO;
import java.util.HashMap;
import java.util.Map;

public class EnderecoRepositoryImpl implements IRepositoryDTO<Endereco> {
    private static Map<Integer, EnderecoDTO> enderecoDTOMap = new HashMap<>();
    private static Integer idGlobal =1;


    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal);
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
        enderecoDTOMap.put(idGlobal, enderecoDTO);
        idGlobal++;
        return endereco;
    }

    @Override
    public Endereco buscarPorId(Integer id) {
        EnderecoDTO enderecoDTO = enderecoDTOMap.get(id);
        if (enderecoDTO != null)
            return new Endereco(enderecoDTO);

        return null;
    }

}
