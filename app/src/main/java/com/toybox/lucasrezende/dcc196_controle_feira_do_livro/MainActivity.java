package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Formularios.CadastroLivro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Formularios.CadastroParticipante;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;

public class MainActivity extends AppCompatActivity {

    private static final int NOVO_CADASTRO_PARTICIPANTE = 1;
    private static final int NOVO_CADASTRO_LIVRO = 2;
    private static final int REGISTRO = 1;
    private static final int ANULAR_REGISTRO = -1;
    private Button btnNovoPublico;
    private Button btnNovoLivro;
    private Button btnNovaReserva;
    private Button btnLivros;
    private ListView lstPublico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNovoPublico = (Button) findViewById(R.id.btnNovoConvidado);
        btnNovaReserva = (Button) findViewById(R.id.btnReservaLivro);
        btnLivros = (Button) findViewById(R.id.btnLivros);
        btnNovoLivro = (Button) findViewById(R.id.btnNovoLivro);
        lstPublico = (ListView) findViewById(R.id.lstPublico);

        ParticipantesHelper.getInstance().initAdapterParticipantes(getBaseContext());
        LivrosHelper.getInstance().initAdapterLivro(getBaseContext());
        lstPublico.setAdapter(ParticipantesHelper.getInstance().getAdapter());
        ParticipantesHelper.getInstance().getAdapter().atualizar();



        btnNovoPublico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cadastro
                Intent intent = new Intent(MainActivity.this, CadastroParticipante.class);
                startActivityForResult(intent,NOVO_CADASTRO_PARTICIPANTE);
            }
        });
/*
        btnNovaReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // nova reserva
                Intent intent = new Intent(MainActivity.this, Emprestimos.class);
                startActivity(intent);
            }
        });
*/
        btnNovoLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // cadastra livro
                Intent intent = new Intent(MainActivity.this, CadastroLivro.class);
                startActivityForResult(intent,NOVO_CADASTRO_LIVRO);
            }
        });

        btnLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListarLivros.class);
                startActivity(intent);
            }
        });


        lstPublico.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Participante p = null;
                p = ParticipantesHelper.getInstance().getAdapter().getParticipante((int)l);
                if(p.getEntrada().equals("Vazio")) {
                   ParticipantesHelper.getInstance().getAdapter().atualizaEntrada(String.valueOf(l),REGISTRO);
                } else if(p.getSaida().equals("Vazio")){
                      ParticipantesHelper.getInstance().getAdapter().atualizaSaida(String.valueOf(l),REGISTRO);
                    }else {
                         ParticipantesHelper.getInstance().getAdapter().atualizaEntrada(String.valueOf(l),ANULAR_REGISTRO);
                         ParticipantesHelper.getInstance().getAdapter().atualizaSaida(String.valueOf(l),ANULAR_REGISTRO);
                }
                return true;
            }
        });

        lstPublico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalhesParticipante.class);
                intent.putExtra("participante",String.valueOf(l));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseAdapter adpter = (BaseAdapter) lstPublico.getAdapter();
        adpter.notifyDataSetChanged();
    }
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MainActivity.RESULT_OK && requestCode == NOVO_CADASTRO_PARTICIPANTE && data != null){
            Toast.makeText(getApplicationContext(),data.getStringExtra("resultado"),Toast.LENGTH_SHORT).show();
            System.out.print("participante adcionado");
        }
        if(requestCode == MainActivity.RESULT_OK && requestCode == NOVO_CADASTRO_LIVRO && data != null){
            Toast.makeText(getApplicationContext(),data.getStringExtra("resultado"),Toast.LENGTH_SHORT).show();
            System.out.print("Livro adcionado");
        }
    }
*/


}
