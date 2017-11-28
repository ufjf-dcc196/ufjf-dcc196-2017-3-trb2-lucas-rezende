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
    ParticipanteAdapter participantesAdapter = null;
    ParticipanteAdapter participantesAtivosAdapter = null;
    ParticipanteAdapter locatariosAdapter = null;


    public static ParticipantesHelper getInstance() {
        if (instance == null) {
            instance = new ParticipantesHelper();
        }
        return instance;
    }


    public void initAdapterParticipantes(Context baseContext) {
        participantesAdapter = new ParticipanteAdapter(baseContext,null);

    }

    public void initAdapterParticipantesAtivos(Context baseContext){
        participantesAtivosAdapter = new ParticipanteAdapter(baseContext, null);
    }

    public void initAdapterLocatario(Context baseContext) {
        locatariosAdapter = new ParticipanteAdapter(baseContext,null);
    }

    public ParticipanteAdapter getAdapter() {
        return participantesAdapter;
    }

    public ParticipanteAdapter getAdapterLocatario() {
        return locatariosAdapter;
    }

    public ParticipanteAdapter getParticipantesAtivosAdapter() {return participantesAtivosAdapter;}

    public void adicionaParticipante(Participante participante) {
        items.add(participante);
    }
}
