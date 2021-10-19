package com.dh.conta.model;

public class Cliente {
    private int id;
    private String nome;
    private String senha;
    static int contasCriadas=0;

    public Cliente( String nome, String senha) {
        this.id = Cliente.contasCriadas++;
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
