package com.example.vitor.scrolsfinal;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isServiceOk()){
            Init();
        }
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
            Log.d(TAG, "isServiceOk: deu merda mas da pra arrumar");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this,"Fodeu", Toast.LENGTH_LONG);

        }
        return  false;
    }
    public void Init(){

    }
}
