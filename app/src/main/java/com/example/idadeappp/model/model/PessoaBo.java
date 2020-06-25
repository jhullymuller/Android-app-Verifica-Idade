package com.example.idadeappp.model.model;

/**
 * Classe Responsavel pelas Regras de negocio
 */

public class PessoaBo {

    public static boolean validadarNome(String nome){
        return nome!= null && !nome.equals("");
    }

    public static boolean validadarIdade(Integer idade){
        return idade!= null && idade >=0 && idade<200;
    }
    public  static boolean verificarMaioridade(Integer idade){
        return idade>= 18;
    }
}
