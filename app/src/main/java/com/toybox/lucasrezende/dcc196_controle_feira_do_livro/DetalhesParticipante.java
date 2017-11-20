package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.R;

public class DetalhesParticipante extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtHoraEntrada;
    private TextView txtHoraSaida;
    private TextView txtEmailParticipante;
    private String[] detalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_participante);

        txtNome = (TextView)findViewById(R.id.txtNome);
        txtHoraEntrada = (TextView)findViewById(R.id.txtEditora);
        txtHoraSaida = (TextView)findViewById(R.id.txtSaida);
        txtEmailParticipante = (TextView)findViewById(R.id.txtEmailParticipante);

        detalhes = getIntent().getStringExtra("participante").split(";");
        //(0)nome (1)sobrenome (2)email (3)entrada (4)saida
        txtNome.setText(detalhes[0] + " " + detalhes[1]);
        txtHoraEntrada.setText(detalhes[3]);
        txtHoraSaida.setText(detalhes[4]);
        txtEmailParticipante.setText(detalhes[2]);

    }
}
