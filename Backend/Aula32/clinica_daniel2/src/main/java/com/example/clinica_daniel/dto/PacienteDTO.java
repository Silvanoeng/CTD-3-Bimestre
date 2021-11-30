package com.example.clinica_daniel.dto;

import com.example.clinica_daniel.entity.PacienteEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private Integer idEndereco;

    public PacienteDTO() {
    }

    public PacienteDTO(PacienteEntity paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome= paciente.getSobrenome();
        this.email= paciente.getEmail();
        this.cpf= paciente.getCpf();
        this.idEndereco= paciente.getEndereco().getId();
    }

    public PacienteDTO(PacEndDTO paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome= paciente.getSobrenome();
        this.email= paciente.getEmail();
        this.cpf= paciente.getCpf();
        this.idEndereco= paciente.getEnderecoDTO().getId();
    }
}
