package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DadosCartao extends AppCompatActivity {

    Button btnConcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_cartao);

        btnConcluir = (Button)findViewById(R.id.btnConcluir);
        EditText txtCidade;
        EditText txtEstado;
        EditText txtCEP;
        EditText txtComp;
        EditText txtBairro;
        EditText NumComp;
    }

    public void DadosConcluir(View view){
        Intent intent = new Intent(this, Config.class);
        startActivity(intent);
    }
}
