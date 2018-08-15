package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Produto extends AppCompatActivity {

    Button btnCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        btnCarrinho = (Button)findViewById(R.id.btnCarrinho);

    }

    public void ProdutoCarrinho(View view){
        Intent intent = new Intent(this, Carrinho.class);
        startActivity(intent);
    }
}
