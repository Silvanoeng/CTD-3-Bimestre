package com.example.clinica_daniel.service.impl;

import com.example.clinica_daniel.dto.EnderecoDTO;
import com.example.clinica_daniel.entity.EnderecoEntity;
import com.example.clinica_daniel.repository.EnderecoRepository;
import com.example.clinica_daniel.service.OdontoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements OdontoService<EnderecoDTO> {
    private final EnderecoRepository enderecoRepository;
    private static final Logger LOG = LoggerFactory.getLogger(EnderecoServiceImpl.class);

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository){this.enderecoRepository = enderecoRepository;}

    @Override
    public EnderecoDTO salvar(EnderecoDTO enderecoDTO) {
        EnderecoEntity endereco = new EnderecoEntity(enderecoDTO);
        enderecoRepository.save(endereco);
        EnderecoDTO enderecoDTOSaida = new EnderecoDTO(endereco);
        LOG.info("Endereço criado com sucesso.");
        return enderecoDTOSaida;
    }

    @Override
    public EnderecoDTO buscarPorId(Integer id) {
        EnderecoEntity endereco = enderecoRepository.getById(id);
        if (endereco != null) {
            EnderecoDTO enderecoDTOSaida = new EnderecoDTO(endereco);
            LOG.info("Busca endereço, realizada com sucesso.");
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
            LOG.info("Listar endereços, realizado com sucesso.");
            return listaEnderecoDTO;
        }
        return null;
    }

    @Override
    public void deletar(Integer id) {
        LOG.info("Endereço deletado com sucesso.");
        enderecoRepository.deleteById(id);
    }

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

        LOG.info("Endereço atualizado com sucesso.");
        EnderecoDTO enderecoDTOAtualizado = new EnderecoDTO (enderecoRepository.saveAndFlush(enderecoAtualizado));

        return enderecoDTOAtualizado;
    }
}
