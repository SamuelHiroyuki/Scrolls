package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DadosCartao extends AppCompatActivity {

    Button btnConcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_cartao);

        btnConcluir = (Button)findViewById(R.id.btnConcluir);
    }

    public void DadosConcluir(View view){
        Intent intent = new Intent(this, Config.class);
        startActivity(intent);
    }
}
