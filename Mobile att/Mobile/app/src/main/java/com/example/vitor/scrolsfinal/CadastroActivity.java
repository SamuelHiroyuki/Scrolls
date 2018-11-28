package com.example.vitor.scrolsfinal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.vitor.scrolsfinal.Database.DatabaseHelper;

import es.dmoral.toasty.Toasty;

import static android.widget.Toast.LENGTH_SHORT;

public class CadastroActivity extends Activity {

    DatabaseHelper helper;
    EditText txtName, txtEmail, txtPass, txtPassConfirm;


    int PICK_IMAGE = 100;
    Button btnChoosePic;

    Uri imageURI;
    ImageView imgvArchive;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        helper = new DatabaseHelper(this);


        txtName = (EditText) findViewById(R.id.edtName);

        txtPass = (EditText) findViewById(R.id.edtPass);
        txtEmail = (EditText) findViewById(R.id.edtEmail);
        txtPassConfirm = (EditText) findViewById(R.id.edtPassConfirm);

    }

        public void Cad (View view){
            tryCad();
        }

        public void cadUser () {


            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("PassUser", String.valueOf(txtPass.getText()));
            values.put("NameUser", String.valueOf(txtName.getText()));

            values.put("EmailUser", String.valueOf(txtEmail.getText()));

            long res = db.insert("User", null, values);
            if (res != -1) {
                Toasty.success(this, "Cadastrado com sucesso!", LENGTH_SHORT, false).show();
            } else {
                Toasty.error(this, "Um erro ocorreu!", LENGTH_SHORT, false).show();
            }
        }


        public void tryCad () {
            String name = txtName.getText().toString();
            String password = txtPass.getText().toString();
            String email = txtEmail.getText().toString();
            String password_confirm = txtPassConfirm.getText().toString();


            txtEmail.setError(null);

            txtName.setError(null);
            txtPass.setError(null);


            boolean cancel = false;
            View focusView = null;


            if (TextUtils.isEmpty(password)) {
                txtPass.setError(getString(R.string.error_field_required));
                cancel = true;
                focusView = txtPass;
            } else if (!isPasswordValid(password)) {
                txtPass.setError(getString(R.string.error_invalid_password));
                cancel = true;
                focusView = txtPass;
            }
              if(TextUtils.isEmpty(password_confirm)){
                txtPassConfirm.setError("O campo é obrigatório");
                cancel = true;
                focusView = txtPassConfirm;
              } else if(!isPassConfirmValid(password_confirm)){
                txtPassConfirm.setError("As senhas não coincidem");
                cancel = true;
                focusView=txtPassConfirm;
              }


            if (TextUtils.isEmpty(email)) {
                txtEmail.setError(getString(R.string.error_field_required));
                cancel = true;
                focusView = txtEmail;
            } else if (!isEmailValid(email)) {
                txtEmail.setError(getString(R.string.error_invalid_email));
                cancel = true;
                focusView = txtEmail;
            }

            if (TextUtils.isEmpty(name)) {
                txtName.setError(getString(R.string.error_field_required));
                cancel = true;
                focusView = txtName;
            } else if (!isNameValid(name)) {
                txtName.setError(getString(R.string.error_invalid_name));
                cancel = true;
                focusView = txtName;
            }

            if (cancel) {
                //Código caso algum campo esteja inválido
                focusView.requestFocus();
            } else {
                cadUser();
                Intent intent = new Intent(this, LooginActivity.class);
                startActivity(intent);
            }
        }


        public boolean isNameValid (String name){
            return name.length() > 0;
        }

        public boolean isEmailValid (String email){
            return email.contains("@") && email.contains(".");
        }

    public boolean isPassConfirmValid (String password_confirm){
        String password = txtPass.getText().toString();
        return password_confirm == password ;
    }



        public boolean isPasswordValid (String password){
            return password.length() > 4;
        }



}