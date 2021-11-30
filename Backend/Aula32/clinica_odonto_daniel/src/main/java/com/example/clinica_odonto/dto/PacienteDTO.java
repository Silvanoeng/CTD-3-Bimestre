package com.example.clinica_odonto.dto;

import com.example.clinica_odonto.model.Paciente;
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

    public PacienteDTO(Paciente paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome= paciente.getSobrenome();
        this.email= paciente.getEmail();
        this.cpf= paciente.getCpf();
        this.idEndereco= paciente.getEndereco().getId();
    }
}
