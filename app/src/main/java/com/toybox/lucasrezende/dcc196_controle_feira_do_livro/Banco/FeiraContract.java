package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Banco;

import android.provider.BaseColumns;

public final class FeiraContract {

    //Tags//
    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER";
    public static final String SEP = ",";

    //SQL CREATE//
    public static final String SQL_CREATE_LIVRO = "CREATE TABLE " + Livro.TABLE_NAME + " (" +
            Livro._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Livro.COLUMN_NAME_TITULO + TEXT_TYPE + SEP +
            Livro.COLUMN_NAME_EDITORA + TEXT_TYPE + SEP +
            Livro.COLUMN_NAME_ANO + INT_TYPE + ")";

    public static final String SQL_CREATE_PARTICIPANTE = "CREATE TABLE " + Participante.TABLE_NAME + " (" +
            Participante._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Participante.COLUMN_NAME_NOME + TEXT_TYPE + SEP +
            Participante.COLUMN_NAME_SOBRENOME + TEXT_TYPE + SEP +
            Participante.COLUMN_NAME_EMAIL + TEXT_TYPE + SEP +
            Participante.COLUMN_NAME_ENTRADA + TEXT_TYPE + SEP +
            Participante.COLUMN_NAME_SAIDA + TEXT_TYPE + ")";

    public static final String SQL_CREATE_EMPRESTIMOS = "CREATE TABLE " + Emprestimo.TABLE_NAME + " (" +
            Emprestimo._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Emprestimo.COLUMN_NAME_PARTICIPANTE + INT_TYPE + "" + SEP +
            Emprestimo.COLUMN_NAME_LIVRO + INT_TYPE  + ")";

    //SQL DROP//
    public static final String SQL_DROP_LIVRO = "DROP TABLE IF EXISTS " + Livro.TABLE_NAME;

    public static final String SQL_DROP_PARTICIPANTE = "DROP TABLE IF EXISTS " + Participante.TABLE_NAME;

    public static final String SQL_DROP_EMPRESTIMOS = "DROP TABLE IF EXISTS " + Emprestimo.TABLE_NAME;


    public FeiraContract() {
    }
    public static final class Livro implements BaseColumns {
        public static final String TABLE_NAME = "livro";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_EDITORA = "editora";
        public static final String COLUMN_NAME_ANO = "ano";
    }
    public static final class Participante implements BaseColumns {
        public static final String TABLE_NAME = "participante";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_SOBRENOME = "sobrenome";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_ENTRADA = "entrada";
        public static final String COLUMN_NAME_SAIDA = "saida";
    }
    public static final class Emprestimo implements BaseColumns {
        public static final String TABLE_NAME = "emprestimo";
        public static final String COLUMN_NAME_PARTICIPANTE = "participante_id";
        public static final String COLUMN_NAME_LIVRO = "livro_id";

    }
}
