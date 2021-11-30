package com.example.clinica_daniel.service.impl;


import com.example.clinica_daniel.dto.DentistaDTO;
import com.example.clinica_daniel.entity.DentistaEntity;
import com.example.clinica_daniel.repository.DentistaRepository;
import com.example.clinica_daniel.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DentistaServiceImpl implements OdontoService<DentistaDTO> {
    private final DentistaRepository dentistaRepository;

    @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository){this.dentistaRepository = dentistaRepository;}

    @Override
    public DentistaDTO salvar(DentistaDTO dentistaDTO) {
        DentistaEntity dentista = new DentistaEntity(dentistaDTO);
        dentistaRepository.save(dentista);
        DentistaDTO dentistaDTOSaida = new DentistaDTO(dentista);

        return dentistaDTOSaida;
    }

    @Override
    public DentistaDTO buscarPorId(Integer id) {
        DentistaEntity dentista = dentistaRepository.getById(id);
        if (dentista !=null) {
            DentistaDTO dentistaDTOSaida = new DentistaDTO(dentista);
            return dentistaDTOSaida;
        }
        return null;
    }

    @Override
    public List<DentistaDTO> buscarTodos() {
        List<DentistaEntity> listaDentista = dentistaRepository.findAll();
        List<DentistaDTO> listaDentistaDTO = new ArrayList<>();
        if (listaDentista != null){
            for (DentistaEntity dentistaEntity : listaDentista){
                DentistaDTO dentistaDTO = new DentistaDTO(dentistaEntity);
                listaDentistaDTO.add(dentistaDTO);
            }
            return listaDentistaDTO;
        }
        return null;
    }

    @Override
    public void deletar(Integer id) {
        dentistaRepository.deleteById(id);
    }

    @Override
    public DentistaDTO atualizar(Integer id, DentistaDTO dentistaDTO) {
        if (dentistaDTO == null)
            return null;

        DentistaDTO dentistaDTOBanco = buscarPorId(id);
        if (dentistaDTOBanco == null)
            return null;

        DentistaEntity dentistaMudancas = new DentistaEntity(dentistaDTO);
        DentistaEntity dentistaAtualizado = new DentistaEntity(dentistaDTOBanco);
        if (dentistaMudancas.getMatricula() != null)
            dentistaAtualizado.setMatricula(dentistaMudancas.getMatricula());
        if (dentistaMudancas.getNome() != null)
            dentistaAtualizado.setNome(dentistaMudancas.getNome());
        if (dentistaMudancas.getSobrenome() != null)
            dentistaAtualizado.setSobrenome(dentistaMudancas.getSobrenome());

        DentistaDTO dentistaDTOAtualizado = new DentistaDTO (dentistaRepository.saveAndFlush(dentistaAtualizado));

        return dentistaDTOAtualizado;
    }


}
