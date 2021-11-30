package com.example.clinica_daniel.entity;

import com.example.clinica_daniel.dto.PacienteDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TABELA_PACIENTE")
public class PacienteEntity {

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
    private EnderecoEntity endereco;

    public PacienteEntity(){}

    public PacienteEntity(PacienteDTO pacienteDTO, EnderecoEntity endereco) {
        this.id = pacienteDTO.getId();
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.email = pacienteDTO.getEmail();
        this.cpf = pacienteDTO.getCpf();
        this.endereco = endereco;
    }
}
