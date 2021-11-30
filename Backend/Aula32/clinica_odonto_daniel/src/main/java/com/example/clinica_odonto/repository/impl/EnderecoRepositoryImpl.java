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

    @Override
    public Map<Integer, Endereco> buscarTodos() {
        if (enderecoDTOMap != null) {
            Map<Integer, Endereco> enderecoMap = new HashMap<>();
            for (Map.Entry<Integer, EnderecoDTO> itemDoFor : enderecoDTOMap.entrySet()) {
                Endereco endereco = new Endereco(itemDoFor.getValue());
                enderecoMap.put(itemDoFor.getKey(), endereco);
            }
            return enderecoMap;
        }
        return null;
    }

    @Override
    public void deletar(Integer id) {
        enderecoDTOMap.remove(id);
    }

    @Override
    public Endereco atualizar(Integer id, Endereco enderecoAtualizar) {
        if (enderecoAtualizar == null)
            return null;

        Endereco enderecoBancoDeDados = buscarPorId(id);
        if (enderecoAtualizar.getRua() != null)
            enderecoBancoDeDados.setRua(enderecoAtualizar.getRua());
        if (enderecoAtualizar.getNumero() != null)
            enderecoBancoDeDados.setNumero(enderecoAtualizar.getNumero());
        if (enderecoAtualizar.getCidade() != null)
            enderecoBancoDeDados.setCidade(enderecoAtualizar.getCidade());
        if (enderecoAtualizar.getEstado() != null)
            enderecoBancoDeDados.setCidade(enderecoAtualizar.getEstado());
        EnderecoDTO enderecoNovo = new EnderecoDTO(enderecoBancoDeDados);
        enderecoDTOMap.put(id, enderecoNovo);
        return enderecoBancoDeDados;
    }

}
