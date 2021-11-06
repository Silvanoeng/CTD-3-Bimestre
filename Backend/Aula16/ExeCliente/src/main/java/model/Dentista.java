package model;

public class Dentista {
    private Integer id;
    private Integer numeroMatricula;
    private String nome;
    private String sobrenome;

    public Dentista(Integer numeroMatricula, String nome, String sobrenome) {

        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Dentista(Integer id, Integer numeroMatricula, String nome, String sobrenome) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Dentista() { }

    public Integer getId() {
        return id;
    }

    public void setIdDen(Integer id) {
        this.id = id;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
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

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Sobrenome: " + sobrenome +
                ", NumeroMatricula: " + numeroMatricula + ".";
    }
}
