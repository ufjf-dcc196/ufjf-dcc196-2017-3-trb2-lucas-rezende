package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Livro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.ParticipanteAdapter;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.R;

public class DetalhesLivro extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtEditora;
    private TextView txtAno;
    private String[] detalhes;
    private ListView lstLocatarios;
    private Livro l = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_livro);

        txtNome = (TextView)findViewById(R.id.txtLivroTitulo);
        txtEditora = (TextView)findViewById(R.id.txtLivroEditora);
        txtAno = (TextView)findViewById(R.id.txtAnoLivro);
        lstLocatarios = (ListView)findViewById(R.id.lstLocatarios);
        ParticipantesHelper.getInstance().initAdapterLocatario(getBaseContext());


        l = LivrosHelper.getInstance().getAdapterLivros().getLivro(Integer.parseInt(getIntent().getStringExtra("livros")));
        txtNome.setText(l.getTitulo());
        txtEditora.setText(l.getEditora());
        txtAno.setText(String.valueOf(l.getAno()));
        //lstLocatarios.setAdapter();





    }
}
