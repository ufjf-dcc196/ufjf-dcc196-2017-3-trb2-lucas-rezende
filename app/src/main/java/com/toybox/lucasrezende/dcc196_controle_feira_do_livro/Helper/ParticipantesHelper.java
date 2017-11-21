package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper;

import android.content.Context;
import android.widget.ListAdapter;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.ParticipanteAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LucasRezende on 26/10/2017.
 */

public class ParticipantesHelper {

    private static ParticipantesHelper instance = null;
    private List<Participante> items = new ArrayList<>();
    ParticipanteAdapter ParticipanteAdapter = null;
    ParticipanteAdapter locatarioAdapter = null;


    public static ParticipantesHelper getInstance() {
        if (instance == null) {
            instance = new ParticipantesHelper();
        }
        return instance;
    }


    public void initAdapterParticipantes(Context baseContext) {
        ParticipanteAdapter = new ParticipanteAdapter(baseContext,null);
    }

    public void initAdapterLocatario(Context baseContext) {
        locatarioAdapter = new ParticipanteAdapter(baseContext,null);
    }

    public ParticipanteAdapter getAdapter() {
        return ParticipanteAdapter;
    }

    public ParticipanteAdapter getAdapterLocatario() {
        return locatarioAdapter;
    }

    public void adicionaParticipante(Participante participante) {
        items.add(participante);
    }
}
