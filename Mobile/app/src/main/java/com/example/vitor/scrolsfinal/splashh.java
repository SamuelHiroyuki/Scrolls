package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.vitor.scrolsfinal.Classes.User;
import com.example.vitor.scrolsfinal.Database.DatabaseHelper;

import java.io.File;

public class splashh extends AppCompatActivity {
    public static String PREF_NAME = "Preferencias";
    SharedPreferences sp;
    Intent intent,i;
    SQLiteDatabase context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashh);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //this.deleteDatabase("dbScrolls");
        intent = new Intent(this, LooginActivity.class);
        i = new Intent(this, MainActivity.class);
        final Context co = this;
        carregar();
    }
    private boolean checkLoggedUser(){
        sp = getSharedPreferences(PREF_NAME,0);
        if(sp.getString("EmailLoggedUser","").length()==0){
            return false;
        }
        else {return true;}
    }
    private User getUser(){
        sp = getSharedPreferences(PREF_NAME,0);
        String emailUser = sp.getString("EmailLoggedUser","");
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT * FROM User WHERE EmailUser =" + " '"+emailUser+"'";
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        User usuario = new User();
        for(int i = 0; i < cursor.getCount(); i++){
            int id = cursor.getInt(0);

            String password = cursor.getString(2);
            String name = cursor.getString(3);

            String email = emailUser;


            usuario = new User(id,email,name,password);
        }
        return usuario;
    }
    @Override
    protected void onResume() {
        super.onResume();
        carregar();
    }

    public void carregar(){
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    boolean chk = checkLoggedUser();
                    User user;
                    if(chk){
                        user = getUser();
                        i.putExtra("LoggedUser",user);
                        i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(i);
                    }
                    else {
                        startActivity(intent);
                        finish();
                    }
                }
            }
        }; thread.start();
    }
}
