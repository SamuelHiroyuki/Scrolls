package com.example.vitor.scrolsfinal;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class PerfilActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_viewPerfil);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutPerfil);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,R.string.Drawer_open,R.string.Drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


    }



}
