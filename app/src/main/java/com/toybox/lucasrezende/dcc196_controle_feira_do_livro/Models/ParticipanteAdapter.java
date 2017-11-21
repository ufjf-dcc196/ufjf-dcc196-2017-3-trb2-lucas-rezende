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

import java.util.Random;


public class ParticipanteAdapter extends CursorAdapter {
    private FeiraDbHelper feiraHelper;
    private static String Tag = "Participante Adapter";

    public ParticipanteAdapter(Context context, Cursor c) {
        super(context, c, 0);
        feiraHelper = new FeiraDbHelper(context);
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
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }

    public void inserirParticipante(String nome, String sobrenome, String email, String entrada, String saida){
        try {
            SQLiteDatabase db = feiraHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(FeiraContract.Participante.COLUMN_NAME_NOME, nome);
            values.put(FeiraContract.Participante.COLUMN_NAME_SOBRENOME, sobrenome);
            values.put(FeiraContract.Participante.COLUMN_NAME_EMAIL, email);
            values.put(FeiraContract.Participante.COLUMN_NAME_ENTRADA, entrada);
            values.put(FeiraContract.Participante.COLUMN_NAME_SAIDA, saida);
            long id = db.insert(FeiraContract.Participante.TABLE_NAME, null, values);
            atualizar();
        } catch (Exception e) {
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }

    public void getParticipante(){
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
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
    }
}
