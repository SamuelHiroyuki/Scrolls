package com.example.vitor.scrolsfinal;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.vitor.scrolsfinal.Classes.User;
import com.example.vitor.scrolsfinal.Database.DatabaseHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    public static String PREF_NAME = "Preferencias";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";
    SharedPreferences sp;
    Intent intent,i;
    SQLiteDatabase context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues values = new ContentValues();

        values.put("NameProd", "Box Harry Poter");
        values.put("PrecoProd", 120);
        values.put("CategoriaProd", "Fantasia");
        values.put("AutorProd", "JK");
        values.put("PromocaoProd", 25);
        values.put("ImagemProd", R.drawable.box_hp);

        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        db.insert("Prod", null, values);

        values = new ContentValues();

        values.put("NameProd", "Harry Poter PF");
        values.put("PrecoProd", 80);
        values.put("CategoriaProd", "Nacionais");
        values.put("AutorProd", "JK");
        values.put("PromocaoProd", 10);
        values.put("ImagemProd", R.drawable.hp_pedra);

      helper = new DatabaseHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        db.insert("Prod", null, values);

        values = new ContentValues();

        values.put("NameProd", "Harry Poter CS");
        values.put("PrecoProd", 50);
        values.put("CategoriaProd", "Jogos");
        values.put("AutorProd", "JK");
        values.put("PromocaoProd", 30);
        values.put("ImagemProd", R.drawable.hp_camara);

        helper = new DatabaseHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        db.insert("Prod", null, values);

        values = new ContentValues();

        values.put("NameProd", "Harry Poter EP");
        values.put("PrecoProd", 90);
        values.put("CategoriaProd", "Ficção");
        values.put("AutorProd", "JK");
        values.put("PromocaoProd", 0);
        values.put("ImagemProd", R.drawable.hp_enigma);



        helper = new DatabaseHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        db.insert("Prod", null, values);

        values.put("NameProd", "Eldest");
        values.put("PrecoProd", 44);
        values.put("CategoriaProd", "Horror");
        values.put("AutorProd", "H.P Lovecraft");
        values.put("PromocaoProd", 70);
        values.put("ImagemProd", R.drawable.eldest_img);

        helper = new DatabaseHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        db.insert("Prod", null, values);


        if(isServiceOk()){
            Init();
        }

        intent = new Intent(this, LooginActivity.class);
        i = new Intent(this, PrincipalActivity.class);
        final Context co = this;

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
    public void CadastroClique(View v){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
    public void LoginClique(View v){
        Intent intent = new Intent(this, LooginActivity.class);
        startActivity(intent);
    }
    public boolean isServiceOk(){
        Log.d(TAG, "isServiceOk: Vendo se ta tudo certo");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServiceOk: Tudo certo");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServiceOk: Algo errado mas da para arrumar");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this,"Erro", Toast.LENGTH_LONG);

        }
        return  false;
    }
    public void Init(){

    }
}
