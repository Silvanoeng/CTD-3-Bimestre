package com.example.clinica_odonto.model;

import com.example.clinica_odonto.dto.DentistaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TABELA_DENTISTAS")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobrenome;

    @Column(name="matricula")
    private String matricula;

    public Dentista() {
    }

    public Dentista(DentistaDTO dentistaDTO) {
        this.id = dentistaDTO.getId();
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
        this.matricula = dentistaDTO.getMatricula();
        

    }
}
