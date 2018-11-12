package com.example.vitor.scrolsfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void CadastroClique(View v){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
    public void LoginClique(View v){
        Intent intent = new Intent(this, LooginActivity.class);
        startActivity(intent);
    }
}
