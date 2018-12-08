package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vitor.scrolsfinal.Classes.DAO;
import com.example.vitor.scrolsfinal.Classes.User;

import java.util.ArrayList;
import java.util.List;

import static com.example.vitor.scrolsfinal.MainActivity.PREF_NAME;

public class CarrinhoActivity extends AppCompatActivity {

    DAO dao;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        id = preferences.getInt("IdLoggedUser", 1);



        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.IncludeToolbarCarrinho);
        setSupportActionBar(mTopToolbar);

        dao = new DAO(getApplicationContext());

        RecyclerView rvCarrinho = (RecyclerView) findViewById(R.id.CarrinhoList);
        LinearLayoutManager VerticalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCarrinho.setLayoutManager(VerticalLayoutManager);

        final ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> precos = new ArrayList<>();
        ArrayList<Integer> imagems = new ArrayList<>();


        List<Cursor> produtos = dao.ReturnCarrinho(id);//pegar id do user

        for(int i = 0; i<produtos.size(); i++){
            Cursor produto = produtos.get(i);
           if( produto.moveToFirst() ) {
               String nome = produto.getString(produto.getColumnIndex("NameProd"));
               int preco = produto.getInt(produto.getColumnIndex("PrecoProd"));
               int imagem = produto.getInt(produto.getColumnIndex("ImagemProd"));

               nomes.add(nome);
               precos.add(preco);
               imagems.add(imagem);
           }
        }

        AdapterProd adapterProd = new AdapterProd(getApplicationContext(), imagems, nomes, precos);

        rvCarrinho.setAdapter(adapterProd);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button btn1 = (Button) mTopToolbar.findViewById(R.id.btnPreto);
        btn1.setText("Descartar");

        Button btn2 = (Button) mTopToolbar.findViewById(R.id.btnBlue);
        btn2.setText("Finalizar Comprar");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dao.ApagarCarrinho(id)/*Pegar user id*/;
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Nao deu pra apagar", Toast.LENGTH_LONG);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FinalizarCompraActivity.class);
                intent.putExtra("TipoCompra", 2);
                intent.putExtra("NomeProd", nomes);
                startActivity(intent);
            }
        });
    }
}
