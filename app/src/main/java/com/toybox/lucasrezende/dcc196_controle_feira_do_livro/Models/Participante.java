package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * Created by LucasRezende on 25/10/2017.
 */

public class Participante {

    private String nome;
    private String sobrenome;
    private String email;
    private String entrada;
    private String saida;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");


    public Participante(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        setEntrada();
    }

    public Participante() {
        setEntrada();
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada() {
        this.entrada = sdf.format(new Date());
    }
    public void setEntrada(String val) {
        this.entrada = val;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida() {
        this.saida = sdf.format(new Date());
    }
    public void setSaida(String val) {
        this.saida = val;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String recuperaDetalhes(){
        return "" + nome + ";" + sobrenome + ";" + email + ";" + entrada + ";" + saida + "";
    }
}
