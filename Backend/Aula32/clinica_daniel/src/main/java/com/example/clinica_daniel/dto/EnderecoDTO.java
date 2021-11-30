package com.example.clinica_daniel.dto;

import com.example.clinica_daniel.entity.EnderecoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private Integer id;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    public EnderecoDTO() {
    }

    public EnderecoDTO(EnderecoEntity endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }
}
