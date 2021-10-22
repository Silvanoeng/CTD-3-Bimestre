package com.dh.vacina.componente;

import java.util.Date;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String RG:
    private String nomeVacina;
    private Date dataVacina;


    public Pessoa(String nome, String sobrenome, String RG, String nomeVacina, Date dataVacina) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.nomeVacina = nomeVacina;
        this.dataVacina = dataVacina;
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

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Date getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(Date dataVacina) {
        this.dataVacina = dataVacina;
    }


}
