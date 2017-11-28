package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;


public class FeiraDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Feira.db";
    public static final String Tag = "Banco";
    private static FeiraDbHelper instance = null;


    public static FeiraDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new FeiraDbHelper(context);
        }
        return instance;
    }

    public FeiraDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(FeiraContract.SQL_CREATE_LIVRO);
            sqLiteDatabase.execSQL(FeiraContract.SQL_CREATE_PARTICIPANTE);
            sqLiteDatabase.execSQL(FeiraContract.SQL_CREATE_EMPRESTIMOS);
            Log.e(Tag, "Tabelas Criadas Com Sucesso");
        }catch (Exception e){
            Log.e(Tag, "On Create");
            Log.e(Tag , e.getLocalizedMessage());
            Log.e(Tag , e.getStackTrace().toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_LIVRO);
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_PARTICIPANTE);
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_EMPRESTIMOS);
        onCreate(sqLiteDatabase);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion,newVersion);
    }

    public void onDrop(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_LIVRO);
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_PARTICIPANTE);
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_EMPRESTIMOS);
    }
}
