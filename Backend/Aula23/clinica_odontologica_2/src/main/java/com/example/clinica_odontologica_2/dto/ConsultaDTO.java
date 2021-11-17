package com.example.clinica_odontologica_2.dto;

import com.example.clinica_odontologica_2.model.Consulta;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ConsultaDTO {
    private Integer id;
    private Integer idDen;
    private Integer idPac;
    private LocalDate data;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.idDen = consulta.getDentista().getId();
        this.idPac = consulta.getPaciente().getId();
        this.data = consulta.getData();

    }
}
