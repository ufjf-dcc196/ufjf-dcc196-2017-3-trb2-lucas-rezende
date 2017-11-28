package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Formularios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroParticipante extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtSobrenome;
    private EditText txtEmail;
    private Button btnCadastro;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_participante);

        txtNome = (EditText)findViewById(R.id.txtNome);
        txtSobrenome = (EditText)findViewById(R.id.txtEditoraLayout);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        btnCadastro = (Button)findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Participante participante = new Participante(
                        txtNome.getText().toString(),
                        txtSobrenome.getText().toString(),
                        txtEmail.getText().toString()
                );
                ParticipantesHelper.getInstance().adicionaParticipante(participante);
                ParticipantesHelper.getInstance().getAdapter().inserirParticipante(txtNome.getText().toString(),  txtSobrenome.getText().toString(),   txtEmail.getText().toString(), (String)sdf.format(new Date()),  "Vazio");
                Intent intentResult = new Intent();
                intentResult.putExtra("resultado", "Participante incluido com sucesso!");
                setResult(RESULT_OK,intentResult);
                finish();
            }
        });


    }
}
