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
    EditText txtCEP;
    EditText txtComp;
    EditText txtBairro;
    EditText NumComp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_endereco);

        btnConcluir = (Button)findViewById(R.id.btnConcluir);
        txtCidade = (EditText) findViewById( R.id.txtCidade);
        txtEstado = (EditText) findViewById(R.id.txtEstado);
        txtCEP = (EditText) findViewById(R.id.txtCEP);
        txtComp = (EditText) findViewById(R.id.txtCidade);
        txtBairro = (EditText) findViewById(R.id.txtEstado);
        NumComp = (EditText) findViewById(R.id.txtNum);


        String cidade = txtCidade.getText().toString();
        String estado = txtEstado.getText().toString();
        String cep = txtCEP.getText().toString();
        String comp = txtComp.getText().toString();
        String bairro= txtBairro.getText().toString();
        String NumeroComp = NumComp.getText().toString();


    }

    public final static String Preferencias_Name="Preferencias";
    private String Endereco;
    public void EnderecoConcluir(View view){


        Intent intent = new Intent(this, Config.class);
        startActivity(intent);
    }
}
