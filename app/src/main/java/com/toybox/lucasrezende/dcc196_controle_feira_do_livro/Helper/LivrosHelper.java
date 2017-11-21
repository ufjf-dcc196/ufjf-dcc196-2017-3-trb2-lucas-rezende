package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper;

import android.content.Context;
import android.widget.ListAdapter;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Livro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.LivroAdapter;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LucasRezende on 26/10/2017.
 */

public class LivrosHelper {

    private static LivrosHelper instance = null;
    private List<Livro> items = new ArrayList<>();
    LivroAdapter itensAdapter = null;


    public static LivrosHelper getInstance() {
        if (instance == null) {
            instance = new LivrosHelper();
        }
        return instance;
    }

    public void initAdapterLivro(Context baseContext) {
        itensAdapter = new LivroAdapter(baseContext, null);
    }

    public LivroAdapter getAdapterLivros() {
        return itensAdapter;
    }

    public void adicionaLivro(Livro livro) {
        items.add(livro);
    }
}
