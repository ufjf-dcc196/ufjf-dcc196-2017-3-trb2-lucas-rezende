package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Banco.FeiraContract;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.ParticipanteAdapter;

public class DetalhesParticipante extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtHoraEntrada;
    private TextView txtHoraSaida;
    private TextView txtEmailParticipante;
    private String[] detalhes;
    private Participante p = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_participante);

        txtNome = (TextView)findViewById(R.id.txtNome);
        txtHoraEntrada = (TextView)findViewById(R.id.txtEditoraLayout);
        txtHoraSaida = (TextView)findViewById(R.id.txtSaida);
        txtEmailParticipante = (TextView)findViewById(R.id.txtEmailParticipante);


        p = ParticipantesHelper.getInstance().getAdapter().getParticipante(Integer.parseInt(getIntent().getStringExtra("participante")));
        txtNome.setText(p.getNome() + " " + p.getSobrenome());
        txtHoraEntrada.setText(p.getEntrada());
        txtHoraSaida.setText(p.getSaida());
        txtEmailParticipante.setText(p.getEmail());

    }
}
