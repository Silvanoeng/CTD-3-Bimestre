package model;



public class Paciente {
    private Integer idPac;
    private String nome;
    private String sobrenome;
    private String RG;
    private String dataDeCadastro;
    private Endereco endereco;

    public Paciente( String nome, String sobrenome, String RG, String dataDeCadastro, Endereco endereco) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.dataDeCadastro = dataDeCadastro;
        this.endereco = endereco;
    }

    public Paciente(Integer idPac, String nome, String sobrenome, String RG, String dataDeCadastro, Endereco endereco) {
        this.idPac = idPac;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.dataDeCadastro = dataDeCadastro;
        this.endereco = endereco;
    }

    public Paciente() { }

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

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


}
