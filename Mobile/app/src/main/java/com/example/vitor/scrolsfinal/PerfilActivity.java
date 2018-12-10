package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.vitor.scrolsfinal.Classes.DAO;
import com.example.vitor.scrolsfinal.Classes.User;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;
import java.util.List;

import static com.example.vitor.scrolsfinal.MainActivity.PREF_NAME;

public class PerfilActivity extends AppCompatActivity {

    User loggedUser;
    String testeUser;
    int id;
    String nome, email;
    DAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        id = preferences.getInt("IdLoggedUser", 1);
/*
        Cursor cursor3 = dao.BuscarUserById(id);
        if(cursor3.moveToFirst()){
            nome = cursor3.getString(cursor3.getColumnIndex("NameUser"));
            email = cursor3.getString(cursor3.getColumnIndex("EmailUser"));
        }

        loggedUser = (User) getIntent().getSerializableExtra("ProfileUser");
        testeUser = (String) getIntent().getSerializableExtra("EmailLoggedUser");
        */

        dao = new DAO(getApplicationContext());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
/*
        TextView txtNome = findViewById(R.id.txtNomePerfil);
        txtNome.setText(nome);


        TextView txtEmail = findViewById(R.id.txtEmailPerfil);
        txtEmail.setText(email);*/

      /*  RecyclerView rvCard = findViewById(R.id.rvCartões);
        LinearLayoutManager verticalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCard.setLayoutManager(verticalLayoutManager);

        List<Cursor> cartoes = dao.RetornaCartaoClientes(id);//pegar cliente id
        ArrayList<String> nomes =  new ArrayList<>();
        ArrayList<String> numeros =  new ArrayList<>();

        if(cartoes != null) {
            for (int i = 0; i < cartoes.size(); i++) {
                Cursor cursor = cartoes.get(i);
                cursor.moveToFirst();
                String nome = cursor.getString(cursor.getColumnIndex("NomeCard"));
                String numero = cursor.getString(cursor.getColumnIndex("NumeroCard"));

                nomes.add(nome);
                numeros.add(numero);
            }


        }
        AdapterCartao adapterCartao = new AdapterCartao(getApplicationContext(), nomes, numeros);
        rvCard.setAdapter(adapterCartao);


        RecyclerView rvEnde = findViewById(R.id.rvEnderecos);
        verticalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvEnde.setLayoutManager(verticalLayoutManager);

        ArrayList<String> logradouros = new ArrayList<>();
        ArrayList<String> ceps = new ArrayList<>();
        ArrayList<String> numerosende = new ArrayList<>();
        ArrayList<String> cidades = new ArrayList<>();
        ArrayList<String> bairros = new ArrayList<>();
        ArrayList<String> ufs = new ArrayList<>();

        Cursor cursor = dao.RetornaEndeCliente(id);//pegar id do user

                if( cursor != null && cursor.moveToFirst() ){
                String logradouro = cursor.getString(cursor.getColumnIndex("Logradouro"));
                String cep = cursor.getString(cursor.getColumnIndex("CEP"));
                String numeroende = cursor.getString(cursor.getColumnIndex("NumeroEnd"));
                String cidade = cursor.getString(cursor.getColumnIndex("Cidade"));
                String bairro = cursor.getString(cursor.getColumnIndex("Bairro"));
                String uf = cursor.getString(cursor.getColumnIndex("Estado"));

                logradouros.add(logradouro);
                ceps.add(cep);
                numerosende.add(numeroende);
                cidades.add(cidade);
                bairros.add(bairro);
                ufs.add(uf);

                cursor.moveToNext();
                }

            AdapterEnde adapterEnde = new AdapterEnde(getApplicationContext(), logradouros, numerosende, ceps, cidades, bairros, ufs);
            rvEnde.setAdapter(adapterEnde);
            */
        }




    public void CadCartClik(View v) {
        Intent intent = new Intent(this, CadastroCartaoActivity.class);
        startActivity(intent);
    }
    public void CadEndeClik(View v) {
        Intent intent = new Intent(this, CadastroEnderecoActivity.class);
        startActivity(intent);
    }
    public void MeusPedidosCLick(View v) {
        Intent intent = new Intent(this, MeusPedidosActivity.class);
        startActivity(intent);
    }
    public void Exit(View v) {
        Intent intent = new Intent(this, LooginActivity.class);
        startActivity(intent);
    }




}
