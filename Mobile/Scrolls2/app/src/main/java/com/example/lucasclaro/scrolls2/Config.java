package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Config extends AppCompatActivity {

    Button btnAlterarEndereco;
    Button btnAlterarCartao;
    TextView lblEndereco;
    String endereco;
    private BancoControler dao = new BancoControler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        btnAlterarCartao = (Button)findViewById(R.id.btnAlterarCartao);
        btnAlterarEndereco = (Button)findViewById(R.id.btnAlterarEndereco);
        lblEndereco = (TextView)findViewById(R.id.lblEndereco);

        RecuperarEndereco();
    }

    public void ConfigAlterarCartao(View view){
        Intent intent = new Intent(this, DadosCartao.class);
        startActivity(intent);
    }

    public void ConfigAlterarEndereco(View view){

        Intent intent = new Intent(this, DadosEndereco.class);
        startActivity(intent);
    }

    public final static String Preferencias_Name="Preferencias";
    public void RecuperarEndereco(){
        SharedPreferences settings = getSharedPreferences(Preferencias_Name, 0);
        endereco = settings.getString("endereco", "Não informado");
        lblEndereco.setText(endereco);
    }
}
