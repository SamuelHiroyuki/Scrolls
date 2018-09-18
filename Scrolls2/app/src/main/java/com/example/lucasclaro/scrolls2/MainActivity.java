package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtSemLogin;
    Button btnInscrever;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSemLogin = (TextView)findViewById(R.id.txtSemLogin);
        btnInscrever = (Button) findViewById(R.id.btnInscrever);
        btnEntrar = (Button)findViewById(R.id.btnEntrar);
    }

    public void MainEntrarSemLogin(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void MainInscrever(View view){
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }

    public void MainEntrar(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
