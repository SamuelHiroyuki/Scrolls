package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Carrinho extends AppCompatActivity {

    Button btnVoltarCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        btnVoltarCompras = (Button)findViewById(R.id.btnVoltarCompras);
    }

    public void CarrinhoVoltarCompras(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}
