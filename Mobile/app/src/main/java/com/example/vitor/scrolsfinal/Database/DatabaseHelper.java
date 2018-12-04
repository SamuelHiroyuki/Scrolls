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
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE User(_IdUser INTEGER PRIMARY KEY AUTOINCREMENT, PassUser TEXT, NameUser TEXT," +
            " EmailUser TEXT UNIQUE)");

        db.execSQL("CREATE TABLE Prod(_idProd  INTEGER PRIMARY KEY AUTOINCREMENT, NameProd TEXT, PrecoProd INTEGER, CategoriaProd Text," +
                " AutorProd TEXT, PromocaoProd INTEGER, ImagemProd INTEGER)");
        db.execSQL("CREATE TABLE Carrinho(_idProd INTEGER, _idUser INTEGER, FOREIGN KEY(_IdProd) REFERENCES Prod(_idProd), FOREIGN KEY(_IdUser) REFERENCES User(_IdUser))");
        db.execSQL("CREATE TABLE Cartao(_IdCard INTEGER PRIMARY KEY AUTOINCREMENT, NomeCard TEXT, NumeroCard TEXT, ValidadeCard TEXT)");

        db.execSQL("CREATE TABLE UserCard(_IdUsuario INTEGER REFERENCES User(_IdUser), Id_Card INTEGER REFERENCES Cartao(_IdCard))");

       db.execSQL("CREATE TABLE Endereco(_IdEndereco INTEGER PRIMARY KEY AUTOINCREMENT, CEP TEXT, Estado TEXT, Cidade TEXT, Bairro TEXT, Logradouro TEXT, NumeroEnd TEXT, Complemento TEXT, _IdUser INTEGER, FOREIGN KEY(_IdUser) REFERENCES UseR(_IdUser))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
       // onCreate(db);

    }


}
