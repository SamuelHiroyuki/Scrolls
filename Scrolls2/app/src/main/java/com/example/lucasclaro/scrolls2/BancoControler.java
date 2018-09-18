package com.example.lucasclaro.scrolls2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           BancoControler implements Serializable {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoControler(Context context) {
        banco = new CriaBanco(context);
    }

    public void CriaUsuario(String nome, String sobrenome, String email, String senha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("Nome", nome);
        valores.put("Sobrenome", sobrenome);
        valores.put("Email", email);
        valores.put("Senha", senha);

        resultado = db.insert("Cliente", null, valores);
        db.close();
        String resp = "";
        if (resultado == -1)
            resp = "Erro ao inserir registro";
        else
            resp = "Registro Inserido com sucesso";
        return resp;

    }

    public List<ClienteClass> carregaDadosCli() {
        Cursor cursor;
        String[] campos = {"_IdCli", "Nome", "Sobrenome", "Email", "CPF", "Senha"};
        db = banco.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Cliente", null);
        List<ClienteClass> clientes = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                ClienteClass cli = new ClienteClass();
                cli.Id = cursor.getInt(cursor.getColumnIndex("_IdCli"));
                cli.Nome = cursor.getString(cursor.getColumnIndex("Nome"));
                cli.Sobrenome = cursor.getString(cursor.getColumnIndex("Sobrenome"));
                cli.Email = cursor.getString(cursor.getColumnIndex("Email"));
                cli.Cpf = cursor.getString(cursor.getColumnIndex("CPF"));
                cli.Senha = cursor.getString(cursor.getColumnIndex("Senha"));
                clientes.add(cli);

            }
            db.close();
            return clientes;
        }
        db.close();
        return null;
    }

    public ClienteClass PegaCliente(int id) {
        Cursor cursor;
        String Id = String.valueOf(id);
        String[] campos = {"_IdCli", "Nome", "Sobrenome", "Email", "CPF", "Senha"};
        db = banco.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Cliente WHERE _IdCli = " + Id, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                ClienteClass cli = new ClienteClass();
                cli.Id = cursor.getInt(cursor.getColumnIndex("_IdCli"));
                cli.Nome = cursor.getString(cursor.getColumnIndex("Nome"));
                cli.Sobrenome = cursor.getString(cursor.getColumnIndex("Sobrenome"));
                cli.Email = cursor.getString(cursor.getColumnIndex("Email"));
                cli.Cpf = cursor.getString(cursor.getColumnIndex("CPF"));
                cli.Senha = cursor.getString(cursor.getColumnIndex("Senha"));
                return cli;
            }

        }
        return null;

    }
    public String CriaEndereco(String Endereco, String CEP, String Pais, String Estado, int NumComp, String Bairro) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("Endereco", Endereco);
        valores.put("CEP", CEP );
        valores.put("Pais", Pais);
        valores.put("Estado", Estado);
        valores.put("Nuumero Complemento", NumComp);
        valores.put("Bairro", Bairro);

        resultado = db.insert("Endereco", null, valores);
        db.close();
        String resp = "";
        if (resultado == -1)
            resp = "Erro ao inserir registro";
        else
            resp = "Registro Inserido com sucesso";
        return resp;

    }

}

