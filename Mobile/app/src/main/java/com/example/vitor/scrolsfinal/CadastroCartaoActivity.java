package com.example.vitor.scrolsfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroCartaoActivity extends AppCompatActivity {
    EditText txtNome,txtNume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cartao);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
