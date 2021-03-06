package com.example.clinica_odonto.model;

import com.example.clinica_odonto.dto.ConsultaDTO;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
public class Consulta {
    private Integer id;
    private Dentista dentista;
    private Paciente paciente;
    private Date dataHora;

    public Consulta() {
    }

    public Consulta(ConsultaDTO consultaDTO, Dentista dentista, Paciente paciente) {
        this.id = consultaDTO.getId();
        this.dentista = dentista;
        this.paciente = paciente;
        this.dataHora = consultaDTO.getDataHora();

    }
}
