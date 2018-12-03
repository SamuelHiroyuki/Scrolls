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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vitor.scrolsfinal.Classes.DAO;
import com.example.vitor.scrolsfinal.Classes.User;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.w3c.dom.Text;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import in.goodiebag.carouselpicker.CarouselPicker;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

import static com.example.vitor.scrolsfinal.splashh.PREF_NAME;

public class PrincipalActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
        CarouselPicker carouselPicker;
        DrawerLayout drawer;
        AdapterCat adapter;
        AdapterProd prodAdapter1, prodAdapter2;
        LinearLayout HeaderLayput;
        User loggedUser;
        TextView Perfil;
        NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Toolbar mTopToolbar = findViewById(R.id.IncludeToolbarPrincipal);
        setSupportActionBar(mTopToolbar);

        NavigationView navigationView1 = (NavigationView)findViewById(R.id.nav_viewPerfil);
//        navigationView.setNavigationItemSelectedListener(this);

//        View headerView = navigationView.getHeaderView(0);


//        navigationView.setCheckedItem(R.id.itmComprar);

        loggedUser = (User) getIntent().getSerializableExtra("LoggedUser");
    //  TextView txtNomeUsu = (TextView)navigationView1.getHeaderView(0).findViewById(R.id.txtPerfil);
     //  TextView txtEmailUsu = (TextView)navigationView1.getHeaderView(0).findViewById(R.id.txtEmailPerfil);


      //  txtNomeUsu.setText(loggedUser.getNameUser());
     // txtEmailUsu.setText(loggedUser.getEmailUser());
      // navigationView.setNavigationItemSelectedListener(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,mTopToolbar,R.string.Drawer_open,R.string.Drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        HeaderLayput = (LinearLayout) findViewById(R.id.HeaderLayout);

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
/*
       DAO dao = new DAO(getApplicationContext());

      Cursor produtos = dao.ListarProd();
     produtos.moveToFirst();
        ArrayList<String> Nomes1 = new ArrayList<>();
        ArrayList<Integer> imagens1 = new ArrayList<>();
        ArrayList<Integer> precos1 = new ArrayList<>();

        for(int i =0; i<= 5;i++){
            Nomes1.add(produtos.getString(produtos.getColumnIndex("NameProd")));
            imagens1.add(produtos.getInt(produtos.getColumnIndex("ImagemProd")));
            precos1.add(produtos.getInt(produtos.getColumnIndex("PrecoProd")));
        }

       // RecyclerView rv1 = findViewById(R.id.rvNovo);
       // LinearLayoutManager VerticalLayoutManager
          //      = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
      //  rv1.setLayoutManager(VerticalLayoutManager);
        //prodAdapter1 = new AdapterProd(this,imagens1,Nomes1,precos1);

        //rv1.setAdapter(prodAdapter1);

        RecyclerView rv2 = findViewById(R.id.rvAvaliado);
        LinearLayoutManager verticalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv2.setLayoutManager(verticalLayoutManager);


        prodAdapter2 = new AdapterProd(this,imagens1,Nomes1,precos1);

        rv2.setAdapter(prodAdapter2);
*/
    }
    @Override
    public void onBackPressed(){

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        super.onBackPressed();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        Intent intent;
        switch (id){
            case R.id.itmMeusPedidos:
                 intent = new Intent(getApplicationContext()  , MeusPedidosActivity.class);
                startActivity(intent);
                break;
            case R.id.itmMapa:
               // intent = new Intent(getApplicationContext(), MapaActivity.class);
               // startActivity(intent);

                break;
            case R.id.itmQRCam:
                IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setCameraId(0);
                integrator.initiateScan();
                break;

            case R.id.itmPerfil:
              Intent i = new Intent(this,PerfilActivity.class);
              startActivity(i);
             break;

            case R.id.itmConfig:

        }
        //drawer.closeDrawer(GravityCompat.START); linha com erro
        return true;


    }

    public void PerfilActivity(View v){
        Intent intent = new Intent(this, PerfilActivity.class);
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
        editor.putString("EmailLoggedUser",loggedUser.getEmailUser());
        editor.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode, data);

        if(result!=null) {

            if (result.getContents() != null) {
                Intent intent = new Intent(getApplicationContext(), ProdutoInfoActivity.class);
                startActivity(intent);
            } else
                super.onActivityResult(requestCode, resultCode, data);
        }

    }
 public void Editar (){
     Intent i = new Intent (this, EditarPerfil.class);
     startActivity(i);
 }

}
