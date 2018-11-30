package com.example.vitor.scrolsfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class CarrinhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.IncludeToolbarCarrinho);
        setSupportActionBar(mTopToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button btn1 = (Button) mTopToolbar.findViewById(R.id.btnPreto);
        btn1.setText("Descartar");

        Button btn2 = (Button) mTopToolbar.findViewById(R.id.btnBlue);
        btn2.setText("Finalizar Comprar");
    }
}
