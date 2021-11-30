package com.example.clinica_odonto.model;

import com.example.clinica_odonto.dto.PacienteDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TABELA_PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobrenome;

    @Column(name="email")
    private String email;

    @Column(name="cpf", unique = true)
    private String cpf;

    @OneToOne(fetch= FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinColumn(name="id_end")
    private Endereco endereco;

    public Paciente(){}

    public Paciente(PacienteDTO pacienteDTO, Endereco endereco) {
        this.id = pacienteDTO.getId();
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.email = pacienteDTO.getEmail();
        this.cpf = pacienteDTO.getCpf();
        this.endereco = endereco;
    }
}
