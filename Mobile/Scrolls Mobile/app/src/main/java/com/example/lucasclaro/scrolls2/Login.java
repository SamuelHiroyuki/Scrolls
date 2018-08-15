package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button btnContinuar;
    TextView txtCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnContinuar = (Button)findViewById(R.id.btnContinuar);
        txtCriarConta = (TextView)findViewById(R.id.txtCriarConta);
    }

    public void LoginContinuar(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void LoginInscrever(View view){
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }
}
