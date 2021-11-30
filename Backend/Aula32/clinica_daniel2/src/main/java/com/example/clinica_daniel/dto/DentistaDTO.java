package com.example.clinica_daniel.dto;

import com.example.clinica_daniel.entity.DentistaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;

    public DentistaDTO() {
    }

    public DentistaDTO(DentistaEntity dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.matricula = dentista.getMatricula();

    }
}
