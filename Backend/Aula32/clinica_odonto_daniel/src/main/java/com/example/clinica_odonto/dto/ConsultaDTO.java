package com.example.clinica_odonto.dto;

import com.example.clinica_odonto.model.Consulta;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ConsultaDTO {
    private Integer id;
    private Integer idDen;
    private Integer idPac;
    private Date dataHora;


    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.idDen = consulta.getDentista().getId();
        this.idPac = consulta.getPaciente().getId();
        this.dataHora = consulta.getDataHora();
    }
}
