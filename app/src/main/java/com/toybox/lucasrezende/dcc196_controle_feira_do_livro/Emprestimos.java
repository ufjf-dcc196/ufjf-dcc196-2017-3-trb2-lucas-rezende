package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Livro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;

public class Emprestimos extends AppCompatActivity {

    private ListView lstParticipantes;
    private ListView lstLivros;
    private Button   btnConfirmar;
    private Button   btnCancela;
    private TextView txtLocatario;
    private TextView txtLivro;
    private Participante tempParticipante;
    private Livro tempLivro;
    private ArrayAdapter<Participante> participanteAdapter = null;
    private ArrayAdapter<Livro> livroAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimos);


            lstLivros = (ListView) findViewById(R.id.lstExemplares);
            lstParticipantes = (ListView) findViewById(R.id.lstParticipantes);
            txtLocatario = (TextView)findViewById(R.id.txtLocatario);
            txtLivro = (TextView)findViewById(R.id.txtLivroEscolhido);
            btnConfirmar = (Button)findViewById(R.id.btnConfirmaEmprestimo);
            btnCancela = (Button)findViewById(R.id.btnCancelaEmprestimo);

            participanteAdapter = new ArrayAdapter<Participante>(this, android.R.layout.simple_list_item_1, ParticipantesHelper.getInstance().getList());
            livroAdapter = new ArrayAdapter<Livro>(this, android.R.layout.simple_list_item_1, LivrosHelper.getInstance().getList());

            lstParticipantes.setAdapter(participanteAdapter);
            lstLivros.setAdapter(livroAdapter);

        lstParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Participante escolha = participanteAdapter.getItem(i);
                 tempParticipante = escolha;
                 txtLocatario.setText(escolha.toString());
            }
        });

        lstLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Livro escolha = livroAdapter.getItem(i);
                txtLivro.setText(escolha.toString());
                tempLivro = escolha;
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tempLivro != null && tempParticipante != null) {
                    tempLivro.setReservas(tempParticipante);
                    tempLivro = null;
                    tempParticipante = null;
                    txtLivro.setText("");
                    txtLocatario.setText("");
                    Toast.makeText(getApplicationContext(), "Emprestimo Confirmado", Toast.LENGTH_SHORT).show();
                }else{
                    tempLivro = null;
                    tempParticipante = null;
                    txtLivro.setText("");
                    txtLocatario.setText("");
                    Toast.makeText(getApplicationContext(), "Dados Incompletos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempLivro = null;
                tempParticipante = null;
                txtLivro.setText("");
                txtLocatario.setText("");
            }
        });
    }

}

