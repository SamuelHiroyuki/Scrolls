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
        Cursor cursor = db.rawQuery("SELECT * FROM Prod where NameProd = ? ", new String[]{nome});
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

    public void ApagarCarrinho(int idUser) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String iduser = String.valueOf(idUser);
        db.rawQuery("DELETE FROM Carrinho where _idUser = ?", new String[]{iduser});
    }

    public List<Cursor> ReturnCarrinho(int idUser) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String iduser = String.valueOf(idUser);
        List<Cursor> resp = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from Carrinho where _idUser = ?", new String[]{iduser});
        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                String prodid = cursor.getString(cursor.getColumnIndex("_idProd"));
                Cursor cursor1 = this.BuscarProdById(prodid);
                resp.add(cursor1);
                cursor.moveToNext();
            }
            return resp;
        }
        return null;
    }

    private Cursor BuscarProdById(String prodid) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Prod where _idProd = ? ", new String[]{prodid});
        if (cursor.moveToFirst()) {
            return cursor;
        }
        return null;

    }
    public Cursor BuscarUserById(int prodid) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String Prodid =String.valueOf(prodid);
        Cursor cursor = db.rawQuery("SELECT * FROM User where _IdUser = ? ", new String[]{Prodid});
        if (cursor.moveToFirst()) {
            return cursor;
        }
        return null;

    }
    public String ConcluirVenda(ArrayList<String> nomes, int cardId, int EndeId, List<Integer> quants, int iduser){
        SQLiteDatabase db = helper.getWritableDatabase();
        int precoFinal =0;
        List<Integer> idProds = new ArrayList<>();
        List<Integer> precoProds = new ArrayList<>();
        for(int x = 0; x<nomes.size(); x++){
            String nome = nomes.get(x);
            Cursor cursor = this.BuscarProd(nome);
            if(cursor.moveToFirst()) {
                int idProd = cursor.getInt(cursor.getColumnIndex("_idProd"));
                int preco = cursor.getInt(cursor.getColumnIndex("PrecoProd"));
                idProds.add(idProd);
                precoProds.add(preco);
            }
        }

        ContentValues values = new ContentValues();
        values.put("_idUser", iduser);//pegar id do user
        values.put("_idCartao", cardId);
        values.put("_idEndereco", EndeId);
        values.put("PrecoFinal", 0);

        long resp = db.insert("Venda", null, values);
         if(resp != -1){
           Cursor cursor = db.rawQuery("Select * from Venda Order By _idVenda Desc", null);
             if(cursor.moveToFirst()){
                int idVenda = cursor.getInt(cursor.getColumnIndex("_idVenda"));

                for(int i =0; i<idProds.size(); i++) {
                    int idProd = idProds.get(i);
                    values = new ContentValues();
                    values.put("_idProd", idProd);
                    values.put("_idVenda", idVenda);
                    values.put("Quant", quants.get(i));
                    precoFinal = precoFinal + precoProds.get(i) * quants.get(i);
                    long resp2 = db.insert("ProdVenda", null, values);
                    if (resp2 == -1) return "Deu Merda";
                }
                values = new ContentValues();
                String idvenda = String.valueOf(idVenda);

                db.rawQuery("Update Venda set PrecoFinal = ? where _idVenda = ?",
                        new String[]{String.valueOf(precoFinal), idvenda});

                return "Tudo Certo";


             }
             return "deu merda";

         } return "Deu merda";

    }

    public int RetornaCardId(String nome){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Cartao where NomeCard = ? ", new String[]{nome});
        if (cursor.moveToFirst()) {
            int cardId = cursor.getInt(cursor.getColumnIndex("_IdCard"));
            return cardId;
        }
        return 0;

    }
    public int RetornaEndeId(String nome){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Endereco where Logradouro = ? ", new String[]{nome});
        if (cursor.moveToFirst()) {
            int cardId = cursor.getInt(cursor.getColumnIndex("_IdEndereco"));
            return cardId;
        }
        return 0;

    }
    public List<Cursor> RetornaCartaoClientes(int idUser){
        SQLiteDatabase db = helper.getReadableDatabase();
        List<Cursor> resp = new ArrayList<>();
        String iduser = String.valueOf(idUser);

        Cursor cursor = db.rawQuery("Select * from UserCard where _IdUsuario = ? ", new String[]{iduser});
        if(cursor.moveToFirst()){
            for(int i =0; i<cursor.getCount(); i++){
                String idCard = cursor.getString(cursor.getColumnIndex("Id_Card"));
                Cursor cursor1 = db.rawQuery("Select * from Cartao where _IdCard = ? ", new String[]{idCard});
                resp.add(cursor1);
                cursor.moveToNext();
            }
            return resp;
        }
        return  null;

    }
    public Cursor RetornaEndeCliente(int idUser){
        SQLiteDatabase db = helper.getReadableDatabase();
        List<Cursor> resp = new ArrayList<>();
        String iduser = String.valueOf(idUser);

        Cursor cursor = db.rawQuery("Select * from Endereco where _IdUser = ? ", new String[]{iduser});
        if(cursor.moveToFirst()){
            return cursor;
        }
        return  null;

    }
}


