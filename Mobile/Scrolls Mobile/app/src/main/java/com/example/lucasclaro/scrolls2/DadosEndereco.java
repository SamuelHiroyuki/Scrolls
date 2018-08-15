package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DadosEndereco extends AppCompatActivity {

    Button btnConcluir;
    EditText txtCidade;
    EditText txtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_endereco);

        btnConcluir = (Button)findViewById(R.id.btnConcluir);
        txtCidade = (EditText) findViewById(R.id.txtCidade);
        txtEstado = (EditText) findViewById(R.id.txtEstado);

    }

    public final static String Preferencias_Name="Preferencias";
    private String Endereco;
    public void EnderecoConcluir(View view){
        SharedPreferences settings = getSharedPreferences(Preferencias_Name,0);
        SharedPreferences.Editor editor  = settings.edit();
        editor.putString("endereco", txtCidade.getText() + " - " + txtEstado.getText());
        editor.commit();
        Intent intent = new Intent(this, Config.class);
        startActivity(intent);
    }
}
