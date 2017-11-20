package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Livro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LucasRezende on 26/10/2017.
 */

public class LivrosHelper {

    private static LivrosHelper instance = null;
    private List<Livro> items = new ArrayList<>();


    public static LivrosHelper getInstance() {
        if (instance == null) {
            instance = new LivrosHelper();
        }
        return instance;
    }

    public void populaLista() {
        Livro l1 = new Livro("Leviatã A missão secreta","Galera Record",2012);
        Livro l2 = new Livro("Beemote A Revolução","Galera Record",2013);
        Livro l3 = new Livro("Golias A Revelação","Galera Record",2014);

    //carrega base de dados inicial
        items.add(l1);
        items.add(l2);
        items.add(l3);

   }

    public List<Livro> getList() {
        return items;
    }

    public void adicionaLivro(Livro livro) {
        items.add(livro);
    }

    public List<Participante> getListLocatario(String livro) {
        for(Livro i: items)
            if(i.getTitulo().equals(livro))
                return i.getReservas();
        return null;
    }
}
