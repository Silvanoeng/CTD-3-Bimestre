package model;

import java.util.Date;

public class Paciente extends {
    private Integer idPac;
    private String nome;
    private String sobrenome;
    private String rg;
    private Date dataDeCadastro;
    private Endereco endereco;

    public Paciente(Integer idPac, String nome, String sobrenome, String rg, Date dataDeCadastro, Endereco endereco) {
        this.idPac = idPac;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataDeCadastro = dataDeCadastro;
        this.endereco = endereco;
    }

    public Paciente(String nome, String sobrenome, String rg, Date dataDeCadastro, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataDeCadastro = dataDeCadastro;
        this.endereco = endereco;
    }

    public Integer getIdPac() {
        return idPac;
    }

    public void setIdPac(Integer idPac) {
        this.idPac = idPac;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                ", Sobrenome: " + sobrenome +
                ", RG: " + rg +
                ", Data de cadastro: " + dataDeCadastro + endereco;
    }
}
