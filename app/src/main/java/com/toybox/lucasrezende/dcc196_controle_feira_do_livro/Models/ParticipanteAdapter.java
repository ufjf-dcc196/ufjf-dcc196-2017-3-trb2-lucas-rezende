package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Banco.FeiraContract;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Banco.FeiraDbHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class ParticipanteAdapter extends CursorAdapter {
    private FeiraDbHelper feiraHelper;
    private static String Tag = "Participante Adapter";
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

    public ParticipanteAdapter(Context context, Cursor c) {
        super(context, c, 0);
        feiraHelper = FeiraDbHelper.getInstance(context);
    }

    @Override    //layout de visualizaçao do adapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.participante_layout,viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtParticipante = (TextView) view.findViewById(R.id.txtParticipanteLayout);
        String nome = cursor.getString(cursor.getColumnIndexOrThrow(FeiraContract.Participante.COLUMN_NAME_NOME)) + "  " + cursor.getString(cursor.getColumnIndexOrThrow(FeiraContract.Participante.COLUMN_NAME_SOBRENOME));
        txtParticipante.setText(nome);
    }

    public void atualizar(){
        try {
            SQLiteDatabase db = feiraHelper.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Participante._ID,
                    FeiraContract.Participante.COLUMN_NAME_NOME,
                    FeiraContract.Participante.COLUMN_NAME_SOBRENOME,
                    FeiraContract.Participante.COLUMN_NAME_EMAIL,
                    FeiraContract.Participante.COLUMN_NAME_ENTRADA,
                    FeiraContract.Participante.COLUMN_NAME_SAIDA,
            };
            Cursor c = db.query(FeiraContract.Participante.TABLE_NAME, visao, null, null, null, null, null);
            this.changeCursor(c);
        } catch (Exception e) {
            Log.e(Tag, "M-Atualizar");
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }

    public void atualizarAtivos(){
        try {
            SQLiteDatabase db = feiraHelper.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Participante._ID,
                    FeiraContract.Participante.COLUMN_NAME_NOME,
                    FeiraContract.Participante.COLUMN_NAME_SOBRENOME,
                    FeiraContract.Participante.COLUMN_NAME_EMAIL,
                    FeiraContract.Participante.COLUMN_NAME_ENTRADA,
                    FeiraContract.Participante.COLUMN_NAME_SAIDA,
            };
            String selecao = FeiraContract.Participante.COLUMN_NAME_ENTRADA + " <> ? AND " + FeiraContract.Participante.COLUMN_NAME_SAIDA + " = ? ";
            String[] arg = {"Vazio", "Vazio"};
            Cursor c = db.query(FeiraContract.Participante.TABLE_NAME, visao, selecao, arg, null, null, null);
            this.changeCursor(c);
        } catch (Exception e) {
            Log.e(Tag, "M-AtualizarAtivos");
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }

    public void inserirParticipante(String nome, String sobrenome, String email, String entrada, String saida){
        try {
            SQLiteDatabase db = feiraHelper.getWritableDatabase();
            ContentValues dataToInsert = new ContentValues();
            dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_NOME, nome);
            dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_SOBRENOME, sobrenome);
            dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_EMAIL, email);
            dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_ENTRADA, entrada);
            dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_SAIDA, saida);
            long id = db.insert(FeiraContract.Participante.TABLE_NAME, null, dataToInsert);
            atualizar();
        } catch (Exception e) {
            Log.e(Tag, "M-Inserir Participante");
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }

    public void atualizaEntrada(String id, int i){
        try {
            SQLiteDatabase db = feiraHelper.getWritableDatabase();
            ContentValues dataToInsert = new ContentValues();
            if(i == -1)
                dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_ENTRADA,"Vazio");
            else
                dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_ENTRADA,sdf.format(new Date()));
            String selecao = FeiraContract.Participante._ID + " = ? ";
            String[] arg = {String.valueOf(id)};
            db.update(FeiraContract.Participante.TABLE_NAME, dataToInsert, selecao, arg);
            atualizar();
        } catch (Exception e) {
            Log.e(Tag, "M-Inserir Entrada");
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }

    public void atualizaSaida(String id, int i){
        try {
            SQLiteDatabase db = feiraHelper.getWritableDatabase();
            ContentValues dataToInsert = new ContentValues();
            if(i == -1)
                dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_SAIDA,"Vazio");
            else
                dataToInsert.put(FeiraContract.Participante.COLUMN_NAME_SAIDA,sdf.format(new Date()));
            String selecao = FeiraContract.Participante._ID + " = ? ";
            String[] arg = {String.valueOf(id)};
            db.update(FeiraContract.Participante.TABLE_NAME, dataToInsert, selecao, arg);
            atualizar();
        } catch (Exception e) {
            Log.e(Tag, "M-Inserir Saida");
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }

    public Participante getParticipante(int id){
        try {
            SQLiteDatabase db = feiraHelper.getReadableDatabase();
            Participante p = new Participante();
            String[] visao = {
                    FeiraContract.Participante._ID,
                    FeiraContract.Participante.COLUMN_NAME_NOME,
                    FeiraContract.Participante.COLUMN_NAME_SOBRENOME,
                    FeiraContract.Participante.COLUMN_NAME_EMAIL,
                    FeiraContract.Participante.COLUMN_NAME_ENTRADA,
                    FeiraContract.Participante.COLUMN_NAME_SAIDA,
            };
            String selecao = FeiraContract.Participante._ID + " = ? ";
            String[] arg = {String.valueOf(id)};
            Cursor c = db.query(FeiraContract.Participante.TABLE_NAME, visao, selecao, arg, null, null, null);
            // verifica se o cursos retornou alguma resultado
            if(c!=null){
                c.moveToFirst();
                p.setId(c.getInt(0));
                p.setNome(c.getString(1));       // definição do NOME retornado do cursor
                p.setSobrenome(c.getString(2));      // definição da SOBRENOME retornado do cursor
                p.setEmail(c.getString(3));      // definição do EMAIL retornado do cursor
                p.setEntrada(c.getString(4));    // definição da hora de ENTRADA do cursos
                p.setSaida(c.getString(5));    // definição da hora de SAIDA do cursos
            }
            return p;
        } catch (Exception e) {
            Log.e(Tag, "M-Get Participante");
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
        return null;
    }
    public void getLocatarios(int id_livro){
        String rawQuery = "";
        String test;
        try {
            SQLiteDatabase db = feiraHelper.getReadableDatabase();
            rawQuery = "SELECT * FROM " + FeiraContract.Participante.TABLE_NAME + " AS a "
                    + " INNER JOIN " + FeiraContract.Emprestimo.TABLE_NAME + " AS b "
                    + " ON a." + FeiraContract.Participante._ID + " = b." + FeiraContract.Emprestimo.COLUMN_NAME_PARTICIPANTE
                    + " WHERE b." + FeiraContract.Emprestimo.COLUMN_NAME_LIVRO + " = " + id_livro;
            String[] arg = {String.valueOf(id_livro)};
            Cursor c = db.rawQuery(rawQuery,null);
            this.changeCursor(c);

        } catch (Exception e) {
            Log.e(Tag, rawQuery);
            Log.e(Tag, "M-Get Locatarios");
            Log.e(Tag , e.getLocalizedMessage());
            Log.e(Tag , e.getStackTrace().toString());
        }
    }

    public void atualizarLocatarios(int id) {
        try {
            SQLiteDatabase db = feiraHelper.getReadableDatabase();
            String rawQuery = "SELECT * FROM " + FeiraContract.Participante.TABLE_NAME + " INNER JOIN " + FeiraContract.Emprestimo.TABLE_NAME
                    + " ON " + FeiraContract.Participante._ID + " = " + FeiraContract.Emprestimo.COLUMN_NAME_PARTICIPANTE
                    + " WHERE " + FeiraContract.Emprestimo.COLUMN_NAME_LIVRO + " = ? ";
            String[] arg = {String.valueOf(id)};
            Cursor c = db.rawQuery(rawQuery,arg);
            this.changeCursor(c);
        } catch (Exception e) {
            Log.e(Tag, "M-AtualizarAtivos");
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }
}
