package com.example.convidados.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.convidados.constants.DataBaseConstants;
import com.example.convidados.model.GuestModel;

import java.util.ArrayList;
import java.util.List;

public class GuestRepository {

    //CRUD - Create, read, update and delete;
    //Aqui vou fazer os metodos de listar, inserir, alterar e deletar.

    //Singleton - É um design patter que limita o acesso ao banco de dados um por vez.

    /*** Padrão singleton**/
    private static GuestRepository INSTANCE;
    private GuestDataBaseHelper mHelper;

    private GuestRepository(Context context) {

        this.mHelper = new GuestDataBaseHelper(context);
    }

    public static GuestRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new GuestRepository(context);
        }
        return INSTANCE;
    }

    /*** Padrão singleton**/


    /**
     * Lista todos usuários
     **/
    public List<GuestModel> getList() {

        List<GuestModel> list = new ArrayList<>();
        try {

            SQLiteDatabase db = this.mHelper.getReadableDatabase();
            String[] colums = {DataBaseConstants.GUEST.COLUNS.ID,
                    DataBaseConstants.GUEST.COLUNS.NAME,
                    DataBaseConstants.GUEST.COLUNS.PRESENCE};

            Cursor cursor = db.query(DataBaseConstants.GUEST.TABLE_NAME, colums, null, null, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()){
                    int id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUNS.ID));
                    String name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUNS.NAME));
                    int presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUNS.PRESENCE));
                    GuestModel guest = new GuestModel(id, name, presence);
                    list.add(guest);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return list;
        }catch (Exception e){
            return list;
        }
    }

    /**
     * Lista só um usuário
     **/
    public GuestModel load(int id) {

        try {
            GuestModel guest = null;
            SQLiteDatabase db = this.mHelper.getReadableDatabase();
            String[] colums = {DataBaseConstants.GUEST.COLUNS.ID,
                    DataBaseConstants.GUEST.COLUNS.NAME,
                    DataBaseConstants.GUEST.COLUNS.PRESENCE};

            String selection = DataBaseConstants.GUEST.COLUNS.ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};

            Cursor cursor = db.query(DataBaseConstants.GUEST.TABLE_NAME, colums, selection, selectionArgs, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                /**Aqui o cursor vai procurar pelo nome da coluna. O ideal é fazer assim em vez de passar o index da coluna, pq se algum dia mudar a estrutura do banco,
                 * o cursor sabera a coluna que preciso independente das mudanças que fiz na quantidade de colunas e nomes.
                 * cursor.getString(1);---jeito não indicado
                 */
                String name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUNS.NAME));
                int presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUNS.PRESENCE));

                guest = new GuestModel(id, name, presence);
            }
            if (cursor != null) {
                cursor.close();
            }
            return guest;

        } catch (Exception e) {
            return null;
        }

    }


    public boolean insert(GuestModel guest) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.GUEST.COLUNS.NAME, guest.getName());
            values.put(DataBaseConstants.GUEST.COLUNS.PRESENCE, guest.getConfrimation());

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values);
            db.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(GuestModel guest) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.GUEST.COLUNS.NAME, guest.getName());
            values.put(DataBaseConstants.GUEST.COLUNS.PRESENCE, guest.getConfrimation());

            String where = DataBaseConstants.GUEST.COLUNS.ID + " = ?";
            String[] args = {String.valueOf(guest.getId())};

            db.update(DataBaseConstants.GUEST.TABLE_NAME, values, where, args);

            db.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            String where = DataBaseConstants.GUEST.COLUNS.ID + " = ?";
            String[] args = {String.valueOf(id)};

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, where, args);

            db.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }


}
