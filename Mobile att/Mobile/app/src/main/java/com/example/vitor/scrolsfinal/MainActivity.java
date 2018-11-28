package com.example.vitor.scrolsfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnCad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openActivity();
            }
        });
    }
 public void openActivity(){
                Intent intent = new Intent(this, CadastroActivity.class);
                  startActivity(intent);
}

    public void LoginClique(View v){
        Intent intent = new Intent(this, LooginActivity.class);
        startActivity(intent);
    }
}