package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LucasRezende on 25/10/2017.
 */

public class Livro {

    private String titulo;
    private String editora;
    private int ano;
    private int id;
    private List<Participante> reservas = new ArrayList<>();

    public Livro(String titulo, String editora, int ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
    }

    public Livro() {}

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public List<Participante> getReservas() {
        return reservas;
    }

    public void setReservas(Participante participante) {
        this.reservas.add(participante);
    }

    public String getTitulo() {return titulo;}

    public String recuperaDetalhes(){
        Log.e("Livro", "Recupera Detalhes");
        return titulo + ";" + editora + ";" + ano;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
