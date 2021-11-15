package com.example.clinicaodonto.model;

public class Dentista {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String numMatricula;

    public Dentista(Integer id, String nome, String sobrenome, String numMatricula) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numMatricula = numMatricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }
}
