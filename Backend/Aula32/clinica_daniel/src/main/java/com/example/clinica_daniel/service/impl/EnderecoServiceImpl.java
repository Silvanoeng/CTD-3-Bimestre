package com.example.clinica_daniel.service.impl;

import com.example.clinica_daniel.dto.EnderecoDTO;
import com.example.clinica_daniel.entity.EnderecoEntity;
import com.example.clinica_daniel.repository.EnderecoRepository;
import com.example.clinica_daniel.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements OdontoService<EnderecoDTO> {
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository){this.enderecoRepository = enderecoRepository;}

    @Override
    public EnderecoDTO salvar(EnderecoDTO enderecoDTO) {
        EnderecoEntity endereco = new EnderecoEntity(enderecoDTO);
        enderecoRepository.save(endereco);
        EnderecoDTO enderecoDTOSaida = new EnderecoDTO(endereco);

        return enderecoDTOSaida;
    }

    @Override
    public EnderecoDTO buscarPorId(Integer id) {
        EnderecoEntity endereco = enderecoRepository.getById(id);
        if (endereco != null) {
            EnderecoDTO enderecoDTOSaida = new EnderecoDTO(endereco);
            return enderecoDTOSaida;
        }
        return null;
    }

    @Override
    public List<EnderecoDTO> buscarTodos() {
        List<EnderecoEntity> listaEndereco = enderecoRepository.findAll();
        List<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();
        if (listaEndereco != null){
            for (EnderecoEntity enderecoEntity : listaEndereco){
                EnderecoDTO enderecoDTO = new EnderecoDTO(enderecoEntity);
                listaEnderecoDTO.add(enderecoDTO);
            }
            return listaEnderecoDTO;
        }
        return null;
    }

    @Override
    public void deletar(Integer id) { enderecoRepository.deleteById(id); }

    @Override
    public EnderecoDTO atualizar(Integer id, EnderecoDTO enderecoDTO) {
        if (enderecoDTO == null)
            return null;

        EnderecoDTO enderecoDTOBanco = buscarPorId(id);
        if (enderecoDTOBanco == null)
            return null;

        EnderecoEntity enderecoMudancas = new EnderecoEntity(enderecoDTO);
        EnderecoEntity enderecoAtualizado = new EnderecoEntity(enderecoDTOBanco);
        if (enderecoMudancas.getRua() != null)
            enderecoAtualizado.setRua(enderecoMudancas.getRua());
        if (enderecoMudancas.getNumero() != null)
            enderecoAtualizado.setNumero(enderecoMudancas.getNumero());
        if (enderecoMudancas.getCidade() != null)
            enderecoAtualizado.setCidade(enderecoMudancas.getCidade());
        if (enderecoMudancas.getEstado() != null)
            enderecoAtualizado.setEstado(enderecoMudancas.getEstado());

        EnderecoDTO enderecoDTOAtualizado = new EnderecoDTO (enderecoRepository.saveAndFlush(enderecoAtualizado));

        return enderecoDTOAtualizado;
    }
}
