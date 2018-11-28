package com.example.vitor.scrolsfinal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.security.Principal;

public class MeusPedidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_pedidos);



        NavigationView navigationView = (NavigationView) findViewById(R.id.NavViewPedidos);
        navigationView.setCheckedItem(R.id.itmMeusPedidos);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.itmConfig:
                        Intent intent = new Intent(getApplicationContext(), Principal.class);
                        startActivity(intent);
                        break;
                    case R.id.itmMapa:
                        Intent intent2 = new Intent(getApplicationContext(), Principal.class);
                        startActivity(intent2);
                        break;
                    case R.id.itmComprar:
                        Intent intent3 = new Intent(getApplicationContext(), Principal.class);
                        startActivity(intent3);
                        break;
                    case R.id.itmQRCam:
                        Intent intent4 = new Intent(getApplicationContext(), Principal.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutPedidos);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,R.string.Drawer_open,R.string.Drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
    }
}
