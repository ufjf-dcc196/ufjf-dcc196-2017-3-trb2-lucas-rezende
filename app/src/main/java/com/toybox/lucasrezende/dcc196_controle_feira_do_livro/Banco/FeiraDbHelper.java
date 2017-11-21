package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class FeiraDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Feira.db";

    public FeiraDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(FeiraContract.SQL_CREATE_LIVRO);
        sqLiteDatabase.execSQL(FeiraContract.SQL_CREATE_PARTICIPANTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_LIVRO);
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_PARTICIPANTE);
        onCreate(sqLiteDatabase);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion,newVersion);
    }
}
