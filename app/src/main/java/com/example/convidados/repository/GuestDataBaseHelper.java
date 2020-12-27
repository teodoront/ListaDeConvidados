package com.example.convidados.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.convidados.constants.DataBaseConstants;

//Aqui está conectando no banco e criando o banco.
public class GuestDataBaseHelper extends SQLiteOpenHelper {
    private  static final String DB_NAME = "convidados.bd";
    private static  final int DB_VERSION = 1;

    private static final String CREATE_TABLE_GUEST = "create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
            + DataBaseConstants.GUEST.COLUNS.ID + " integer primary key autoincrement, "
            + DataBaseConstants.GUEST.COLUNS.NAME + " text, "
            + DataBaseConstants.GUEST.COLUNS.PRESENCE + " integer);";

    public GuestDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criar o banco
        db.execSQL(CREATE_TABLE_GUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Atualiza o banco

    }
}
