package com.example.clinica_daniel.entity;

import com.example.clinica_daniel.dto.EnderecoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TABELA_ENDERECO")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="rua")
    private String rua;

    @Column(name="numero")
    private String numero;

    @Column(name="cidade")
    private String cidade;

    @Column(name="estado")
    private String estado;

    public EnderecoEntity() {
    }

    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
    }
}
