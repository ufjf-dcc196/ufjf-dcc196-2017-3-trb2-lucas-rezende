package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Livro;


public class ListarLivros extends AppCompatActivity {

    private ListView listaLivros;
    private ArrayAdapter<Livro> livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_livros);

        listaLivros = (ListView) findViewById(R.id.lstListarLivros);


        listaLivros.setAdapter(LivrosHelper.getInstance().getAdapterLivros());
        LivrosHelper.getInstance().getAdapterLivros().atualizar();


        listaLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListarLivros.this, DetalhesLivro.class);
                intent.putExtra("livros",String.valueOf(l));
                startActivity(intent);
            }
        });
    }
}
