package com.example.clinicaodonto.model;

public class Endereco {
    private Integer id;
    private String rua;
    private String numero;
    private String municipio;
    private String estado;

    public Endereco(Integer id, String rua, String numero, String municipio, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.municipio = municipio;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
