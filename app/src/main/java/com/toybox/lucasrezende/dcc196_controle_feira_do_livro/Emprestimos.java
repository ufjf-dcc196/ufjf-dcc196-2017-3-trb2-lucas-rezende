package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Livro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.LivroAdapter;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.ParticipanteAdapter;

public class Emprestimos extends AppCompatActivity {

    private Spinner spnParticipantes;
    private Spinner spnLivros;
    private Button   btnConfirmar;
    private TextView txtLocatario;
    private TextView txtLivro;
    private Participante tempParticipante;
    private Livro tempLivro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimos);


            spnLivros = (Spinner) findViewById(R.id.spnLivros);
            spnParticipantes = (Spinner) findViewById(R.id.spnParticipante);
            txtLocatario = (TextView)findViewById(R.id.txtLocatario);
            txtLivro = (TextView)findViewById(R.id.txtLivroEscolhido);
            btnConfirmar = (Button)findViewById(R.id.btnConfirmaEmprestimo);


            spnParticipantes.setAdapter(ParticipantesHelper.getInstance().getParticipantesAtivosAdapter());
            ParticipantesHelper.getInstance().getParticipantesAtivosAdapter().atualizarAtivos();
            spnLivros.setAdapter(LivrosHelper.getInstance().getAdapterLivros());
            LivrosHelper.getInstance().getAdapterLivros().atualizar();

            spnParticipantes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    tempParticipante = ParticipantesHelper.getInstance().getParticipantesAtivosAdapter().getParticipante((int)l);
                    txtLocatario.setText(tempParticipante.getNome() + " " + tempParticipante.getSobrenome());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            spnLivros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    tempLivro = LivrosHelper.getInstance().getAdapterLivros().getLivro((int)l);
                    txtLivro.setText(tempLivro.getTitulo());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tempLivro != null && tempParticipante != null) {
                    LivrosHelper.getInstance().getAdapterLivros().registraLocacao(tempParticipante.getId(),tempLivro.getId());
                    zeraDados();
                    Toast.makeText(getApplicationContext(), "Emprestimo Confirmado", Toast.LENGTH_SHORT).show();
                }else{
                    zeraDados();
                    Toast.makeText(getApplicationContext(), "Dados Incompletos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void zeraDados(){
        tempLivro = null;
        tempParticipante = null;
        txtLivro.setText("");
        txtLocatario.setText("");
    }

}

