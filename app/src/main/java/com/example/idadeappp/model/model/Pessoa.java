package com.example.idadeappp.model.model;

public class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public void setIdade(String idade) {
        try {
            this.idade = Integer.parseInt(idade);
        }catch (Exception e){
            this.idade = null;
        }
    }
}
