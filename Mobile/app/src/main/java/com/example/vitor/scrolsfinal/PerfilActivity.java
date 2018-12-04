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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.vitor.scrolsfinal.Classes.User;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class PerfilActivity extends AppCompatActivity {
    User loggedUser, testeUser;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        loggedUser = (User) getIntent().getSerializableExtra("ProfileUser");
        testeUser = (User) getIntent().getSerializableExtra("EmailLoggedUser");
     navigationView = (NavigationView) findViewById(R.id.nav_viewPerfil);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutPerfil);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,R.string.Drawer_open,R.string.Drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


        TextView txtNome = (TextView)findViewById(R.id.txtNomeUser);
        txtNome.setText(loggedUser.getNameUser());



    }
    public void CadCartClik(View v) {
        Intent intent = new Intent(this, CadastroCartaoActivity.class);
        startActivity(intent);
    }
    public void CadEndeClik(View v) {
        Intent intent = new Intent(this, CadastroEnderecoActivity.class);
        startActivity(intent);
    }
public void CadEditUser(View v){
        Intent intent = new Intent(this, EditUser.class);
        startActivity(intent);
}

}
