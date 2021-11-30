package com.example.clinica_odonto.model;

import com.example.clinica_odonto.dto.EnderecoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TABELA_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="rua")
    private String rua;

    @Column(name="numero")
    private String numero;

    @Column(name="cidade")
    private String cidade;

    @Column(name="estado")
    private String estado;

    public Endereco() {
    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
    }
}
