package edu.junit;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Pessoa {

    private String nome;
    private LocalDateTime nascimento;

    public Pessoa ( String nome, LocalDateTime nascimento){
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public int getIdade(){
        return (int) ChronoUnit.YEARS.between(nascimento, LocalDateTime.now());
    }

    public boolean ehMaiorDeIdade(){
        if (getIdade() >18) {
            return true;
        }
        return false;
    }

}
