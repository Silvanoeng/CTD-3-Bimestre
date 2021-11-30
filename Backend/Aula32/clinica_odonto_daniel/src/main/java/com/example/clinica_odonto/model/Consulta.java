package com.example.clinica_odonto.model;

import com.example.clinica_odonto.dto.ConsultaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="TABELA_CONSULTAS")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch= FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinColumn(name="id_den")
    private Dentista dentista;

    @ManyToOne(fetch= FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinColumn(name="id_pac")
    private Paciente paciente;

    @Column(name="data_hora")
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
