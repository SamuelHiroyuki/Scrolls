package com.example.vitor.scrolsfinal.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    final String TABLE_USER = "User";
    private static final int DATABASE_VERSION      = 1;
    public DatabaseHelper(Context context) {
        super(context,"dbScrolls",null , DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL("CREATE TABLE User(_IdUser INTEGER PRIMARY KEY AUTOINCREMENT, PassUser TEXT, NameUser TEXT, " +
            " EmailUser TEXT UNIQUE);");









    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        //onCreate(db);

    }


}
