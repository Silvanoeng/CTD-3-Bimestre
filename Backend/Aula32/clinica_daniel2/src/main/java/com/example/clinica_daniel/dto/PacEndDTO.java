package com.example.clinica_daniel.dto;

import com.example.clinica_daniel.entity.PacienteEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacEndDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private EnderecoDTO enderecoDTO;

    public PacEndDTO() {
    }

    public PacEndDTO(PacienteEntity paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome= paciente.getSobrenome();
        this.email= paciente.getEmail();
        this.cpf= paciente.getCpf();
        this.enderecoDTO= new EnderecoDTO(paciente.getEndereco());
    }
}
