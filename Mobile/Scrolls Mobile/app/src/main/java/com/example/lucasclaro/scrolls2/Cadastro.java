package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cadastro extends AppCompatActivity {

    Button btnCriarConta;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCriarConta = (Button)findViewById(R.id.btnCriarConta);
        txtLogin = (TextView)findViewById(R.id.txtLogin);
    }

    public void CadastroContinuar(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void CadastroLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
