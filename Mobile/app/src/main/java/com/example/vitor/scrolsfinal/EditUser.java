package com.example.vitor.scrolsfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import com.example.vitor.scrolsfinal.Classes.DAO;
import com.example.vitor.scrolsfinal.Classes.User;
import com.example.vitor.scrolsfinal.Database.DatabaseHelper;

import static com.example.vitor.scrolsfinal.CadastroActivity.PREF_USER_ID;



public class EditUser extends Activity {
    private EditText txtNome, txtEmail, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        txtNome = (EditText) findViewById(R.id.Nome);
        txtPass = (EditText) findViewById(R.id.Pass);
        txtEmail = (EditText) findViewById(R.id.Email);

     //   txtEmail.setText(PREF_UNAME);
      //  txtPass.setText(PREF_PASSWORD);


    }


    public void Update(View v){
           tryUpdate();

    }

    public void tryUpdate(){

        User usuario = new User();
        DatabaseHelper helper;
     DAO dao = new DAO(getApplicationContext());
        ContentValues values = new ContentValues();
   int idUser;
     String senha =txtPass.getText().toString();
     String nome = txtNome.getText().toString();
     String email = txtEmail.getText().toString();
     idUser = Integer.parseInt(PREF_USER_ID);
     dao.updateUser(idUser, nome, senha, email);


        values.put("EmailUser", String.valueOf(txtEmail.getText()));
    }
}
