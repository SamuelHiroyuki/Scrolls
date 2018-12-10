package com.example.vitor.scrolsfinal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vitor.scrolsfinal.Classes.User;
import com.example.vitor.scrolsfinal.Database.DatabaseHelper;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.vitor.scrolsfinal.MainActivity.PREF_NAME;

public class CadastroEnderecoActivity extends AppCompatActivity  {

    EditText txtNome, txtNum, txtCep, txtBairro, txtCidade, txtComp;
    Spinner spin;
    DatabaseHelper helper;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        id = preferences.getInt("IdLoggedUser", 1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        helper = new DatabaseHelper(this);


        txtBairro = (EditText) findViewById(R.id.EnderecoBairroForm);
        txtCep = (EditText) findViewById(R.id.EnderecoCepForm);
        txtCidade = (EditText) findViewById(R.id.EnderecoCidadeForm);
        txtNome = (EditText) findViewById(R.id.EnderecoNomeForm);
        txtNum = (EditText) findViewById(R.id.EnderecoNumeroForm);
        txtComp = (EditText) findViewById(R.id.EnderecoComp);
        spin = (Spinner) findViewById(R.id.SpinnerUf);



        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNNNN-NNN");
        MaskTextWatcher mkf = new MaskTextWatcher(txtCep, smf);
        txtCep.addTextChangedListener(mkf);
        List<String> Estados = new ArrayList<>(Arrays.asList("AC - Acre", "AL - Alagoas", "AM - Amazonas", "AP - Amapá", "BA - Bahia", "CE - Ceará", "DF - Distrito Federal", "ES - Espírito Santos", "GO - Goiás", "MA - Maranhão", "MT - Mato Grosso", "MS - Mato Grosso do Sul", "MG - Minas Gerais", "PA - Pará", "PB - Paraíba", "PR - Paraná", "PE - Pernambuco", "PI - Piauí­", "RJ - Rio de Janeiro", "RN - Rio Grande do Norte", "RO - Rondânia", "RS - Rio Grande do Sul", "RR - Roraima", "SC - Santa Catarina", "SE - Sergipe", "SP - São Paulo", "TO - Tocantins"));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Estados);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);

    }
    public void CadastroClick(View v){
        tryCadEnd();
    }
    public void tryCadEnd() {
        String Nome = txtNome.getText().toString();
        String Cidade = txtCidade.getText().toString();
        String Uf1 = spin.getSelectedItem().toString();
        String Numero = txtNum.getText().toString();
        String cep = txtCep.getText().toString();
        String Comp = txtComp.getText().toString();
        String bairro = txtBairro.getText().toString();



        txtNome.setError(null);
        txtNum.setError(null);
        txtComp.setError(null);
        txtBairro.setError(null);
        txtCidade.setError(null);
        txtCep.setError(null);




        boolean cancel = false;
        View focusView = null;


        if (TextUtils.isEmpty(Nome)) {
            txtNome.setError("Você não preencheu o endereço!");
            cancel = true;
            focusView = txtNome;
        }
        if (TextUtils.isEmpty(Numero)) {
            txtNum.setError("O campo é obrigatório");
            cancel = true;
            focusView = txtNum;
        }
        if (TextUtils.isEmpty(Comp)) {
            txtComp.setError("O campo é obrigatório");
            cancel = true;
            focusView = txtComp;
        }
        if (TextUtils.isEmpty(Cidade)) {
            txtCidade.setError("O campo é obrigatório");
            cancel = true;
            focusView = txtCidade;
        }
        if (TextUtils.isEmpty(bairro)) {
            txtBairro.setError("O campo é obrigatório");
            cancel = true;
            focusView = txtBairro;
        }
        if (TextUtils.isEmpty(cep)) {
            txtCep.setError("O campo é obrigatório");
            cancel = true;
            focusView = txtCep;
        }

        if (cancel) {
            //Código caso algum campo esteja inválido
            focusView.requestFocus();
        } else {
            tryCad();
            Intent i = new Intent(this, PerfilActivity.class);
            startActivity(i);
        }
    }


    public void tryCad() {

        String Bairro = txtBairro.getText().toString();
        String Endereco = txtNome.getText().toString();
        String Cep = txtCep.getText().toString();
        String Cidade = txtCidade.getText().toString();
        String Num = txtNum.getText().toString();
        String Uf = spin.getSelectedItem().toString();
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("CEP", String.valueOf(txtCep.getText()));
        values.put("Estado", Uf);
        values.put("Cidade", String.valueOf(txtCidade.getText()));
        values.put("Bairro", String.valueOf(txtBairro.getText()));
        values.put("Logradouro", String.valueOf(txtNome.getText()));
        values.put("NumeroEnd", String.valueOf(txtNum.getText()));
        values.put("Complemento", String.valueOf(txtComp));
        values.put("_IdUser", id);

        long res = db.insert("Endereco", null, values);
        if (res != -1) {


            Toast.makeText(this, "Sucesso!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Um erro ocorreu", Toast.LENGTH_LONG).show();
        }

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