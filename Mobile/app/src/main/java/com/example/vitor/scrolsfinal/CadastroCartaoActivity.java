package com.example.vitor.scrolsfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroCartaoActivity extends AppCompatActivity {
    EditText txtNome,txtNume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cartao);

        txtNome = (EditText) findViewById(R.id.NomeCartãoForm);
        txtNume = (EditText) findViewById(R.id.NumeroCartãoForm);

    }
    public void CadastroCardClick(View v){
        if(txtNome.getTextSize() != 0 && txtNome.getTextSize() != 0) {
            String nome = txtNome.getText().toString();
            String numero = txtNume.getText().toString();

            //Codigo do banc
            Toast.makeText(this,"Tudo Mec", Toast.LENGTH_LONG);
        }
        else Toast.makeText(this, "Tem alguma coisa errada ai comedia", Toast.LENGTH_LONG);
    }
}
