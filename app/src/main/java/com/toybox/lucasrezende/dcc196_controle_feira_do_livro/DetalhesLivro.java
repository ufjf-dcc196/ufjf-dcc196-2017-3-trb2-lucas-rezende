package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.R;

public class DetalhesLivro extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtEditora;
    private TextView txtAno;
    private String[] detalhes;
    private ListView lstLocatarios;
    private ArrayAdapter<Participante> locatarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_livro);

        txtNome = (TextView)findViewById(R.id.txtLivroTitulo);
        txtEditora = (TextView)findViewById(R.id.txtLivroEditora);
        txtAno = (TextView)findViewById(R.id.txtAnoLivro);
        lstLocatarios = (ListView)findViewById(R.id.lstLocatarios);

        detalhes = getIntent().getStringExtra("livros").split(";");
        //(0)titulo (1)editora (2)Ano
        txtNome.setText(detalhes[0]);
        txtEditora.setText(detalhes[1]);
        txtAno.setText(detalhes[2].toString());

        locatarioAdapter = new ArrayAdapter<Participante>(this, android.R.layout.simple_list_item_1, LivrosHelper.getInstance().getListLocatario(detalhes[0]));
        lstLocatarios.setAdapter(locatarioAdapter);


    }
}
