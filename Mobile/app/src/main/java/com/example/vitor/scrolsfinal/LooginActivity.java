package com.example.vitor.scrolsfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LooginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loogin);
    }
    public void LoginClique2(View v){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
    public void Continuar(View v){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}
