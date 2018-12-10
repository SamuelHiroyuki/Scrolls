package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vitor.scrolsfinal.Classes.DAO;
import com.example.vitor.scrolsfinal.Classes.User;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

import static com.example.vitor.scrolsfinal.MainActivity.PREF_NAME;

public class ProdutoInfoActivity extends AppCompatActivity {
    Button btnCarrinho,btnAgora;
   int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_info);

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        id = preferences.getInt("IdLoggedUser", 1);
        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.IncludeToolbarProduto);
        setSupportActionBar(mTopToolbar);

        TextView txtnome = (TextView) findViewById(R.id.txtNomeInfo);
        TextView txtPreco = (TextView) findViewById(R.id.txtPrecoInfo);
        TextView txtPromo = (TextView) findViewById(R.id.txtPromocaoInfo);
        TextView txtAutor = (TextView) findViewById(R.id.txtAutorInfo);
        TextView txtCategoria = (TextView) findViewById(R.id.txtCategoriaInfo);

        Intent intent = getIntent();
        final String nomeProd = intent.getStringExtra("NomeProd");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FlipperLayout flipper = (FlipperLayout) findViewById(R.id.FliperProd);

        btnCarrinho= (Button) mTopToolbar.findViewById(R.id.btnPreto);
        btnCarrinho.setText("Carrinho");

        btnAgora= (Button) mTopToolbar.findViewById(R.id.btnBlue);
        btnAgora.setText("Comprar Agora");

        final DAO dao = new DAO(getApplicationContext());
        Cursor cursor =dao.BuscarProd(nomeProd);

        cursor.moveToFirst();
        final int idprod = cursor.getInt(cursor.getColumnIndex("_idProd"));
        String preco = cursor.getString(cursor.getColumnIndex("PrecoProd"));
        String promocao = cursor.getString(cursor.getColumnIndex("PromocaoProd"));
        String Categoria = cursor.getString(cursor.getColumnIndex("CategoriaProd"));
        String Autor = cursor.getString(cursor.getColumnIndex("AutorProd"));
        int imagem = cursor.getInt(cursor.getColumnIndex("ImagemProd"));


        FlipperView fv = new FlipperView(this);
        fv.setImageDrawable(imagem);
        flipper.addFlipperView(fv);

        txtAutor.setText(Autor);
        txtCategoria.setText(Categoria);
        txtnome.setText(nomeProd);
        txtPreco.setText("R$ "+preco+",00");
        txtPromo.setText(promocao +"% OFF");

        btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resp = dao.InserirProdNoCarrinho(idprod,id)/*pegariddouserno lugar disso*/;
                Toast.makeText(getApplicationContext(), resp, Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(), CarrinhoActivity.class);
                startActivity(intent1);
            }
        });
        btnAgora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), FinalizarCompraActivity.class);
                intent2.putExtra("TipoCompra", 1);
                intent2.putExtra("NomeProd", nomeProd);
                startActivity(intent2);
            }
        });
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