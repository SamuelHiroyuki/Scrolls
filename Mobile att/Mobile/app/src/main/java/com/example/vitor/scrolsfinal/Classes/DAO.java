package com.example.vitor.scrolsfinal.Classes;

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

    public DAO(Context context) {
        this.helper = new DatabaseHelper(context);
    }

    public List<Map<String, Object>> listarUsuarios(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select _IdUser, PassUser, NameUser, EmailUser from User", null);
        cursor.moveToFirst();
        users = new ArrayList<Map<String, Object>>();
        for(int i =0; i<cursor.getCount(); i++){
            Map<String,Object> item = new HashMap<String, Object>();
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

}
