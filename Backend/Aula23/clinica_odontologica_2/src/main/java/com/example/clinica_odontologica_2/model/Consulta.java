package com.example.clinica_odontologica_2.model;

import com.example.clinica_odontologica_2.dto.ConsultaDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Consulta {
    private Integer id;
    private Dentista dentista;
    private Paciente paciente;
    private LocalDate data;

    public Consulta() {
    }

    public Consulta(ConsultaDTO consultaDTO, Dentista dentista, Paciente paciente) {
        this.id = consultaDTO.getId();
        this.dentista = dentista;
        this.paciente = paciente;
        this.data = consultaDTO.getData();

    }
}
