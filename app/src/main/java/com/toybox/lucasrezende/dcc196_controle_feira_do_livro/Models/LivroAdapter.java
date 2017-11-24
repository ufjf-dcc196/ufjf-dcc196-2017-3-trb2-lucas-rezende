package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Banco.FeiraContract;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Banco.FeiraDbHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.R;



public class LivroAdapter extends CursorAdapter {
    private FeiraDbHelper feiraHelper;
    private static String Tag = "Livro Adapter";

    public LivroAdapter(Context context, Cursor c) {
        super(context, c, 0);
        feiraHelper = FeiraDbHelper.getInstance(context);
       // feiraHelper = new FeiraDbHelper(context);
    }

    @Override    //layout de visualizaçao do adapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.livro_layout,viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitulo = (TextView) view.findViewById(R.id.txtTituloLayout);
        TextView txtAno = (TextView) view.findViewById(R.id.txtAnoLayout);
        TextView txtEditora = (TextView) view.findViewById(R.id.txtEditoraLayout);
        String titulo = cursor.getString(cursor.getColumnIndexOrThrow(FeiraContract.Livro.COLUMN_NAME_TITULO));
        String editora = cursor.getString(cursor.getColumnIndexOrThrow(FeiraContract.Livro.COLUMN_NAME_EDITORA));
        int ano = cursor.getInt(cursor.getColumnIndexOrThrow(FeiraContract.Livro.COLUMN_NAME_ANO));
        txtTitulo.setText(titulo);
        txtEditora.setText(editora);
        txtAno.setText(String.valueOf(ano));
    }

    public void atualizar(){
        try {
            SQLiteDatabase db = feiraHelper.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Livro._ID,
                    FeiraContract.Livro.COLUMN_NAME_TITULO,
                    FeiraContract.Livro.COLUMN_NAME_EDITORA,
                    FeiraContract.Livro.COLUMN_NAME_ANO,
            };
            Cursor c = db.query(FeiraContract.Livro.TABLE_NAME, visao, null, null, null, null, null);
            this.changeCursor(c);

        } catch (Exception e) {
            Log.e(Tag , e.getLocalizedMessage());
            Log.e(Tag , e.getStackTrace().toString());
        }
    }

    public void inserirLivro(String titulo, String editora, int ano){
        try {
            SQLiteDatabase db = feiraHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(FeiraContract.Livro.COLUMN_NAME_TITULO, titulo);
            values.put(FeiraContract.Livro.COLUMN_NAME_EDITORA, editora);
            values.put(FeiraContract.Livro.COLUMN_NAME_ANO, ano);
            long id = db.insert(FeiraContract.Livro.TABLE_NAME, null, values);
            atualizar();
        } catch (Exception e) {
            Log.e("BIBLIO", e.getLocalizedMessage());
            Log.e("BIBLIO", e.getStackTrace().toString());
        }
    }

    public Livro getLivro(int id){
        try {
            SQLiteDatabase db = feiraHelper.getReadableDatabase();
            Livro l = new Livro();
            String[] visao = {
                    FeiraContract.Livro._ID,
                    FeiraContract.Livro.COLUMN_NAME_TITULO,
                    FeiraContract.Livro.COLUMN_NAME_EDITORA,
                    FeiraContract.Livro.COLUMN_NAME_ANO,
            };
            String selecao = FeiraContract.Livro._ID + " = ? ";
            String[] arg = {String.valueOf(id)};
            Cursor c = db.query(FeiraContract.Livro.TABLE_NAME, visao, selecao, arg, null, null, null);
            // verifica se o cursos retornou alguma resultado
            if(c!=null){
                c.moveToFirst();
                l.setTitulo(c.getString(1));
                l.setEditora(c.getString(2));
                l.setAno(c.getInt(3));
            }
            return l;
        } catch (Exception e) {
            Log.e(Tag, e.getLocalizedMessage());
            Log.e(Tag, e.getStackTrace().toString());
        }
        return null;
    }
}
