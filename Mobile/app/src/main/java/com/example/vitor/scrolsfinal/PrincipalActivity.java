package com.example.vitor.scrolsfinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vitor.scrolsfinal.Classes.AppState;
import com.example.vitor.scrolsfinal.Classes.DAO;
import com.example.vitor.scrolsfinal.Classes.User;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.w3c.dom.Text;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import in.goodiebag.carouselpicker.CarouselPicker;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

import static com.example.vitor.scrolsfinal.MainActivity.PREF_NAME;

public class PrincipalActivity extends AppCompatActivity {
    CarouselPicker carouselPicker;
    DrawerLayout drawer;
    AdapterCat adapter;
    AdapterProd prodAdapter1, prodAdapter2;
    LinearLayout HeaderLayput;
    User loggedUser;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Toolbar mTopToolbar = findViewById(R.id.IncludeToolbarPrincipal);
        setSupportActionBar(mTopToolbar);
        loggedUser = (User) getIntent().getSerializableExtra("LoggedUser");

        ImageView carrinho = mTopToolbar.findViewById(R.id.imgCarrinho);
        carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
                startActivity(intent);

            }
        });


        //Perfil.setText(loggedUser.getNameUser());
        //navigationView.setNavigationItemSelectedListener(this);



        // txtEmailUsu.setText(loggedUser.        txtUser.setText(loggedUser.getNameUser()); getEmailUser());
        // navigationView.setNavigationItemSelectedListener(this);




        FlipperLayout fliper = (FlipperLayout) findViewById(R.id.FliperLyt);

        FlipperView fv = new FlipperView(getBaseContext());
        fv.setImageDrawable(R.drawable.cyber_banner);
        fliper.addFlipperView(fv);

        fv = new FlipperView(getBaseContext());
        fv.setImageDrawable(R.drawable.dragon_banner);
        fliper.addFlipperView(fv);

        fv = new FlipperView(getBaseContext());
        fv.setImageDrawable(R.drawable.lovecraft_banner);
        fliper.addFlipperView(fv);

        fv = new FlipperView(getBaseContext());
        fv.setImageDrawable(R.drawable.program_banner);
        fliper.addFlipperView(fv);



        ArrayList<Integer> imagens = new ArrayList<>();
        imagens.add(R.drawable.magic_wand);
        imagens.add(R.drawable.pumpkin);
        imagens.add(R.drawable.solar_system);
        imagens.add(R.drawable.feather);
        imagens.add(R.drawable.brazil);
        imagens.add(R.drawable.joystick);
        imagens.add(R.drawable.rainbow);


        Resources res = getResources();
        String[] myBooks = res.getStringArray(R.array.my_books);

        ArrayList<String> nomes = new ArrayList<>(Arrays.asList((myBooks)));



        RecyclerView recyclerView = findViewById(R.id.rvCategorias);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        adapter = new AdapterCat(this, imagens,nomes);

        recyclerView.setAdapter(adapter);

       DAO dao = new DAO(getApplicationContext());

      Cursor produtos = dao.ListarProd();
     produtos.moveToFirst();
        ArrayList<String> Nomes1 = new ArrayList<>();
        ArrayList<Integer> imagens1 = new ArrayList<>();
        ArrayList<Integer> precos1 = new ArrayList<>();

        for(int i =0; i<= 3;i++){
            Nomes1.add(produtos.getString(produtos.getColumnIndex("NameProd")));
            imagens1.add(produtos.getInt(produtos.getColumnIndex("ImagemProd")));
            precos1.add(produtos.getInt(produtos.getColumnIndex("PrecoProd")));
            produtos.moveToNext();
        }

        RecyclerView rv1 = findViewById(R.id.rvNovo);
       LinearLayoutManager VerticalLayoutManager
              = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
       rv1.setLayoutManager(VerticalLayoutManager);
         prodAdapter1 = new AdapterProd(this,imagens1,Nomes1,precos1);

        rv1.setAdapter(prodAdapter1);

        RecyclerView rv2 = findViewById(R.id.rvAvaliado);
        LinearLayoutManager verticalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv2.setLayoutManager(verticalLayoutManager);


        prodAdapter2 = new AdapterProd(this,imagens1,Nomes1,precos1);

        rv2.setAdapter(prodAdapter2);

        setLoggedUser();
    }




    public void PerfilActivity(View v){
        Intent intent = new Intent(getApplicationContext(), PerfilActivity.class);
        startActivity(intent);
    }
    public void MapaCLick(View v){
        Intent intent = new Intent(this, MapaActivity.class);
        startActivity(intent);
    }
    public void CameraClick(View v){

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setCameraId(0);
        integrator.initiateScan();
    }
    private void setLoggedUser(){
        SharedPreferences sp = getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = sp.edit();
        try {
            editor.putInt("IdLoggedUser", loggedUser.get_IdUser());
            editor.commit();

        }catch (Exception e){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode, data);

        if(result!=null) {

            if (result.getContents() != null) {
                Intent intent = new Intent(getApplicationContext(), ProdutoInfoActivity.class);
                intent.putExtra("NomeProd", result.getContents());
                startActivity(intent);
            } else
                super.onActivityResult(requestCode, resultCode, data);
        }

    }

}