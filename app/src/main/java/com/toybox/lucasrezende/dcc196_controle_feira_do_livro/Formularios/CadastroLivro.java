package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Formularios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Livro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.R;

public class CadastroLivro extends AppCompatActivity {

    private EditText txtTitulo;
    private EditText txtEditora;
    private EditText txtAno;
    private Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livros);


        txtTitulo = (EditText)findViewById(R.id.txtNome);
        txtEditora = (EditText)findViewById(R.id.txtEditora);
        txtAno = (EditText)findViewById(R.id.txtEmail);
        btnCadastro = (Button)findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Livro livro = new Livro(
                        txtTitulo.getText().toString(),
                        txtEditora.getText().toString(),
                        Integer.parseInt(txtAno.getText().toString())
                );
                LivrosHelper.getInstance().adicionaLivro(livro);
                Intent intentResult = new Intent();
                intentResult.putExtra("resultado", "Livro incluido com sucesso!");
                setResult(RESULT_OK,intentResult);
                finish();
            }
        });

    }
}
