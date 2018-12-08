package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.vitor.scrolsfinal.Classes.DAO;
import com.example.vitor.scrolsfinal.Classes.User;

import java.util.ArrayList;
import java.util.List;

import static com.example.vitor.scrolsfinal.MainActivity.PREF_NAME;

public class FinalizarCompraActivity extends AppCompatActivity {

    DAO dao;
    ArrayList<String> nomes;
    ArrayList<Integer> precos;
    ArrayList<Integer> imagems;
    int id;
    RecyclerView rvFinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_compra);

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        id = preferences.getInt("IdLoggedUser", 1);

        dao = new DAO(getApplicationContext());


        android.support.v7.widget.Toolbar mTopToolbar = findViewById(R.id.IncludeToolbarFinalizar);
        setSupportActionBar(mTopToolbar);

        Button btnComprar = mTopToolbar.findViewById(R.id.btnPreto);

        Button btnCancelar = mTopToolbar.findViewById(R.id.btnBlue);

        btnComprar.setText("Comprar");

        btnCancelar.setText("Cancelar");

        Spinner spinnerCartao = findViewById(R.id.SpinnerCartao);
        Spinner spinnerEnde = findViewById(R.id.SpinnerEnde);

        nomes = new ArrayList<>();
        precos = new ArrayList<>();
        imagems = new ArrayList<>();


         rvFinalizar = findViewById(R.id.FinalizarList);

        Intent intent = getIntent();
        int tipo = intent.getIntExtra("TipoCompra", 0);

        if(tipo == 1){
            String prodnome = intent.getStringExtra("NomeProd");
            Cursor cursor = dao.BuscarProd(prodnome);
            if (cursor.moveToFirst()){
                for(int i = 0; i < 1; i++){
                    String nome = cursor.getString(cursor.getColumnIndex("NameProd"));
                    int preco = cursor.getInt(cursor.getColumnIndex("PrecoProd"));
                    int imagem = cursor.getInt(cursor.getColumnIndex("ImagemProd"));
                    nomes.add(nome);
                    precos.add(preco);
                    imagems.add(imagem);

                }

            }
            LinearLayoutManager VerticalLayoutManager
                    = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rvFinalizar.setLayoutManager(VerticalLayoutManager);
            AdapterFinalizar adapter = new AdapterFinalizar(getApplicationContext(), imagems, nomes, precos);
            rvFinalizar.setAdapter(adapter);
        }
        if(tipo == 2) {
           nomes = intent.getStringArrayListExtra("NomeProd");
           List<Cursor> cursores = new ArrayList<>();
            for(int i =0; i<nomes.size(); i++){
                String nome = nomes.get(i);
                Cursor cursor;
                cursor = dao.BuscarProd(nome);
                if(cursor.moveToFirst()) {
                    cursores.add(cursor);
                }
                Toast.makeText(getApplicationContext(),"deu merda", Toast.LENGTH_SHORT);
            }
            for (int x = 0; x < cursores.size(); x++) {
                Cursor cursor = cursores.get(x);
                int preco = cursor.getInt(cursor.getColumnIndex("PrecoProd"));
                int imagem = cursor.getInt(cursor.getColumnIndex("ImagemProd"));;
                precos.add(preco);
                imagems.add(imagem);
            }
            LinearLayoutManager VerticalLayoutManager
                    = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rvFinalizar.setLayoutManager(VerticalLayoutManager);
            AdapterFinalizar adapter = new AdapterFinalizar(getApplicationContext(), imagems, nomes, precos);
            rvFinalizar.setAdapter(adapter);
        }

        String nomeCard = String.valueOf(spinnerCartao.getSelectedItem());
        String NomeEnde = String.valueOf(spinnerEnde.getSelectedItem());

      final int idCard = dao.RetornaCardId(nomeCard);
      final int idEnde = dao.RetornaEndeId(NomeEnde);

       List<String> nomescard = new ArrayList<>();

    //   List<Cursor> cartoes = dao.RetornaCartaoClientes(id); //user id

      /*  if(cartoes != null){
            for(int i =0; i<cartoes.size(); i++){
                Cursor cursor = cartoes.get(i);
                if(cursor.moveToFirst()){
                    nomescard.add("Cartão de "+cursor.getString(cursor.getColumnIndex("NomeCard")));
                }
            }
        }
        List<String> nomesende = new ArrayList<>();*/

        /*Cursor cursor = dao.RetornaEndeCliente(1); //user id
                if(cursor.moveToFirst()){
                    nomesende.add(cursor.getString(cursor.getColumnIndex("Logradouro")));
                }*/


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, new String[]{"Cartão de Vitor Fonseca"});
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCartao.setAdapter(dataAdapter);

         dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, new String[]{"Rua das laranjeiras"});
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEnde.setAdapter(dataAdapter);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* List<Integer> quants = new ArrayList<>();
                quants.add(1);
                quants.add(2);
                quants.add(3);
                quants.add(4);

               String resp = dao.ConcluirVenda(nomes, 1,1, quants, 1); //pegar quants digitadas


                if(resp == "Compra feita com sucesso"){
                    dao.ApagarCarrinho(id);*/
                    Toast.makeText(getApplicationContext(), "Compra feita com sucesso", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                    startActivity(intent);
                }

        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // dao.ApagarCarrinho(id);
                Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                Toast.makeText(getApplicationContext(), "Compra não realizada", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }
}
