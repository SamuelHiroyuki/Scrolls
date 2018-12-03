package com.example.vitor.scrolsfinal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vitor.scrolsfinal.Database.DatabaseHelper;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CadastroEnderecoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText txtNome, txtNum, txtCep, txtBairro, txtCidade, txtComp;
    Spinner spin;
     DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);

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
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNNNN-NNN");
        MaskTextWatcher mkf = new MaskTextWatcher(txtCep, smf);
        txtCep.addTextChangedListener(mkf);
        List<String> Estados= new ArrayList<>(Arrays.asList("AC - Acre", "AL - Alagoas", "AM - Amazonas", "AP - Amapá","BA - Bahia","CE - Ceará¡","DF - Distrito Federal","ES - Espírito Santos","GO - Goiás","MA - Maranhão","MT - Mato Grosso","MS - Mato Grosso do Sul","MG - Minas Gerais","PA - Pará","PB - Paraíba","PR - Paraná","PE - Pernambuco","PI - Piauí­","RJ - Rio de Janeiro","RN - Rio Grande do Norte","RO - Rondânia","RS - Rio Grande do Sul","RR - Roraima","SC - Santa Catarina","SE - Sergipe","SP - São Paulo","TO - Tocantins"));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Estados);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);
    }
    public void CadastroClick(View v) {
        if (txtCep.getTextSize() != 0 && txtNome.getTextSize() != 0 && txtCidade.getTextSize() != 0
                && txtBairro.getTextSize() != 0 && txtNum.getTextSize() != 0 && spin.getSelectedItemPosition() != 0) {
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




            long res = db.insert("Endereco", null, values);
            if (res != -1) {


                Toast.makeText(this, "Sucesso!!", Toast.LENGTH_LONG);
            } else {
                Toast.makeText(this, "Um erro ocorreu", Toast.LENGTH_LONG);
            }
            Intent intent = new Intent(this, PerfilActivity.class);
            startActivity(intent);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
