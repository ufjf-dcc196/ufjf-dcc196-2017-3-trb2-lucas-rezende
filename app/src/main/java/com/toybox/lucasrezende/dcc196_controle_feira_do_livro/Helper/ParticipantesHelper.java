package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LucasRezende on 26/10/2017.
 */

public class ParticipantesHelper {

    private static ParticipantesHelper instance = null;
    private List<Participante> items = new ArrayList<>();


    public static ParticipantesHelper getInstance() {
        if (instance == null) {
            instance = new ParticipantesHelper();
        }
        return instance;
    }

    public void populaLista() {

    Participante p1 = new Participante("Lucas", "Rezende", "lucasrezendecs@hotmail.com");
    Participante p2 = new Participante("Felipe", "Neves", "felipeneves@hotmail.com");
    Participante p3 = new Participante("Andre", "Archanjo", "andreArchanjo@hotmail.com");
    Participante p4 = new Participante("Mario", "Bros", "comum@hotmail.com");
    Participante p5 = new Participante("Luigi", "Bros", "comum@hotmail.com");
    Participante p6 = new Participante("Jean", "Gray", "comum@hotmail.com");
    Participante p7 = new Participante("Bob", "Drake", "comum@hotmail.com");
    Participante p8 = new Participante("Kitty", "Pride", "comum@hotmail.com");
    Participante p9 = new Participante("Scott", "Summers", "comum@hotmail.com");

    //carrega base de dados inicial
        items.add(p1);
        items.add(p2);
        items.add(p3);
        items.add(p4);
        items.add(p5);
        items.add(p6);
        items.add(p7);
        items.add(p8);
        items.add(p9);
   }

    public List<Participante> getList() {
        return items;
    }

    public void adicionaParticipante(Participante participante) {
        items.add(participante);
    }

    public Participante getLast() {
        return items.get(items.size()-1);
    }
}
