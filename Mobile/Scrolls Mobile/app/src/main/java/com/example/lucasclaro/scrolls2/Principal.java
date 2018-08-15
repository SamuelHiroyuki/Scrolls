package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    Button btnCarrinho;
    ImageView imgLivro1;
    ImageView imgLivro2;
    Button btnMapa;
    Button btnQR;
    Button btnConfig;
    Button btnAvaliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnCarrinho = (Button)findViewById(R.id.btnCarrinho);
        imgLivro1 = (ImageView) findViewById(R.id.imgLivro1);
        imgLivro2 = (ImageView) findViewById(R.id.imgLivro2);
        btnMapa = (Button) findViewById(R.id.btnQR);
        btnQR = (Button)findViewById(R.id.btnQR);
        btnConfig = (Button) findViewById(R.id.btnConfig);
        btnAvaliar = (Button)findViewById(R.id.btnAvaliar);
    }

    public void PrincipalCarrinho(View view){
        Intent intent = new Intent(this, Carrinho.class);
        startActivity(intent);
    }

    public void PrincipalProduto(View view){
        Intent intent = new Intent(this, Produto.class);
        startActivity(intent);
    }

    public void PrincipalMapa(View view){
        Uri uri = Uri.parse("google.streetview:cbll=R. Guaipá, 678 - Vila Leopoldina, São Paulo - SP, 05089-000");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void PrincipalQR(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 123);
    }

    public void PrincipalConfig(View view){
        Intent intent = new Intent(this, Config.class);
        startActivity(intent);
    }

    public void PrincipalAvaliar(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=")));
    }

}
