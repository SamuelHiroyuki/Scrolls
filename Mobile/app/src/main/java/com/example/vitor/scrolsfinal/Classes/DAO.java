package com.example.vitor.scrolsfinal.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vitor.scrolsfinal.Database.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {

    DatabaseHelper helper;
    List<Map<String, Object>> users;
    List<Map<String, Object>> prods;

    public DAO(Context context) {
        this.helper = new DatabaseHelper(context);
    }

    public List<Map<String, Object>> listarUsuarios() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select _IdUser, PassUser, NameUser, EmailUser from User", null);
        cursor.moveToFirst();
        users = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < cursor.getCount(); i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String id = cursor.getString(0);

            String pass = cursor.getString(1);
            String name = cursor.getString(2);

            String email = cursor.getString(3);


            item.put("_IdUser", id);

            item.put("PassUser", pass);
            item.put("NameUser", name);
            item.put("EmailUser", email);

            users.add(item);
            cursor.moveToNext();
        }
        return users;
    }

    public Cursor ListarProd() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Prod", null);
        if (cursor.moveToFirst()) {
            return cursor;
        }
        return null;


    }

    public Cursor BuscarProd(String nome) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Prod where NameProd = " + nome, null);
        if (cursor.moveToFirst()) {
            return cursor;
        }
        return null;
    }

    public String InserirProdNoCarrinho(int idProd, int idUser) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_idProd", idProd);
        values.put("_idUser", idUser);

        Long resp = db.insert("Carrinho", null, values);
        if (resp == -1) {
            return "Não foi possivel adicionar o produto no carrinho";
        }
        return "Adicionado ao carrinho";
    }

    public void ApagarCarrinho() {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.rawQuery("DELETE FROM Carrinho", null);
    }

    public List<Cursor> ReturnCarrinho() {
        SQLiteDatabase db = helper.getReadableDatabase();
        List<Cursor> resp = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from Carrinho", null);
        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                String prodid = cursor.getString(cursor.getColumnIndex("_idProd"));
                Cursor cursor1 = this.BuscarProd(prodid);
                resp.add(cursor1);
                cursor.moveToNext();
            }
            return resp;
        }
        return null;
    }
    public int updateUser(int id, String name, String Email, String Password) {
    SQLiteDatabase db = helper.getWritableDatabase();

    // Creating content values
    ContentValues values = new ContentValues();
    values.put("NameUser", name);
    values.put("EmailUser", Email);
    values.put("PassUser", Password);
    // update row in students table base on students.is value
    return db.update("User", values,  id + " = Id_User",
            new String[]{String.valueOf(id)});
}
}


