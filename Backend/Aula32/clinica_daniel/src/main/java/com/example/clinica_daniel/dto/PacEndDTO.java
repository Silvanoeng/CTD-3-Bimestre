package com.example.clinica_daniel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacEndDTO {
    private PacienteDTO pacienteDTO;
    private EnderecoDTO enderecoDTO;

    public PacEndDTO() {
    }

    public PacEndDTO(PacienteDTO pacienteDTO, EnderecoDTO enderecoDTO) {
        this.pacienteDTO = pacienteDTO;
        this.enderecoDTO = enderecoDTO;
    }
}
