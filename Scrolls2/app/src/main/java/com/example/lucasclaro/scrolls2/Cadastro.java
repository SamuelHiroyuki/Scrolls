package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Cadastro extends AppCompatActivity {

    Button btnCriarConta;
    TextView txtNome;
    TextView txtSobrenome;
    TextView txtEmail;
    TextView txtSenha;
    public BancoControler dao = new BancoControler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCriarConta = (Button)findViewById(R.id.btnCriarConta);
        txtNome = (TextView)findViewById(R.id.txtNome);
        txtSobrenome = (EditText) findViewById(R.id.txtSobrenome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
    }

    public void CadastroContinuar(View view){
        String Email =txtEmail.getText().toString();
        String Senha =txtSenha.getText().toString();
        String Nome =txtNome.getText().toString();
        String Sobrenome =txtSobrenome.getText().toString();
       dao.CriaUsuario(Nome, Sobrenome, Email, Senha);
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void CadastroLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
