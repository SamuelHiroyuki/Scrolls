package com.example.lucasclaro.scrolls2;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           BancoControler implements Serializable {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoControler(Context context) {
        banco = new CriaBanco(context);
    }

    public String CadastraUsuario(String nome, String sobrenome, String email, String senha) {
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



    public String RegistraCartao(String nome, String Numero, String validade, String senha, int IdCli) {
        ContentValues valores;
        String resp = "";
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("Nome", nome);
        valores.put("Numero", Numero);
        valores.put("Validade", validade);
        valores.put("Senha", senha);

        resultado = db.insert("Cartao", null, valores);
        if (resultado != -1) {
            db.close();
            valores.clear();
            valores.put("IdCliente", IdCli);
            Cursor cursor;
            db = banco.getReadableDatabase();
            cursor = db.rawQuery("SELECT TOP 1 _IdCart FROM Cartao WHERE Numero=" + Numero, null);
            if (cursor != null) {
                cursor.moveToFirst();
                while (cursor.moveToNext()) {
                    int id_Cart = cursor.getInt(cursor.getColumnIndex("_IdCart"));
                    valores.put("IdCart", id_Cart);
                    resultado = db.insert("CartaoCli", null, valores);
                    if (resultado != -1) {
                        resp = "Registro Inserido com sucesso";
                    } else
                        resp = "Erro ao inserir registro";

                }
            } else resp = "Erro ao inserir registro";
        }
        else resp = "Erro ao inserir registro" ;

        return resp;

    }


    public String CadastraEndereco(String CEP, String Pais, String Estado, String Cidade, String Bairro, String Logradouro, int Numero, String Complemento, int IdCli) {
        String resp = "";
    ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("CEP", CEP);
        valores.put("Pais", Pais);
        valores.put("Estado", Estado);
        valores.put("Cidade",Cidade);
        valores.put("Bairro", Bairro);
        valores.put("Logradouro", Logradouro);
        valores.put("Numero", Numero);
        valores.put("Complemento",Complemento);



        resultado = db.insert("Endereco", null, valores);

        if (resultado != -1) {
            db.close();
            valores.clear();
            valores.put("_IdCli", IdCli);
            Cursor cursor;
            db = banco.getReadableDatabase();
            cursor = db.rawQuery("SELECT TOP 1 _IdEnd FROM Endereco WHERE CEP=" + CEP, null);
            if (cursor != null) {
                cursor.moveToFirst();
                while (cursor.moveToNext()) {
                    int id_End = cursor.getInt(cursor.getColumnIndex("_IdEnd"));
                    valores.put("IdEndereco", id_End);
                    resultado = db.insert("EnderecoCli", null, valores);
                    if (resultado != -1) {
                        resp = "Registro Inserido com sucesso";
                    } else
                        resp = "Erro ao inserir registro";

                }
            } else resp = "Erro ao inserir registro";
        }
        else resp = "Erro ao inserir registro" ;

        return resp;

    }




}

