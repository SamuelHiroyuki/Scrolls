package com.example.lucasclaro.scrolls2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Login extends AppCompatActivity {

    Button btnContinuar;
    TextView txtCriarConta;
    EditText txtEmail,txtSenha;
    private BancoControler dao = new BancoControler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnContinuar = (Button)findViewById(R.id.btnContinuar);
        txtCriarConta = (TextView)findViewById(R.id.txtCriarConta);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
    }

    public void LoginContinuar(View view){
        String Email =txtEmail.getText().toString();
        String Senha =txtSenha.getText().toString();
        List<ClienteClass> cli = dao.carregaDadosCli();
        for (ClienteClass cliente :cli ){
            if(cliente.Email.equals(Email) && cliente.Senha.equals(Senha)){
                Intent intent = new Intent(this, Principal.class);
                intent.putExtra("Cliente", cliente.Id);
                startActivity(intent);
            }
        }
        String resp = "Usuario ou senha errados";
        txtSenha.setText("");



    }

    public void LoginInscrever(View view){
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }
}
