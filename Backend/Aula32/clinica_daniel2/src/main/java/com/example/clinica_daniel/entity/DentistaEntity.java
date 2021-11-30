package com.example.clinica_daniel.entity;

import com.example.clinica_daniel.dto.DentistaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TABELA_DENTISTAS")
public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobrenome;

    @Column(name="matricula")
    private String matricula;

    public DentistaEntity() {
    }

    public DentistaEntity(DentistaDTO dentistaDTO) {
        this.id = dentistaDTO.getId();
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
        this.matricula = dentistaDTO.getMatricula();
    }
}
