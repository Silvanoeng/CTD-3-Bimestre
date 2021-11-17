package com.example.clinica_odontologica_2.dto;

import com.example.clinica_odontologica_2.model.Dentista;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;


    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.matricula = dentista.getMatricula();

    }
}
