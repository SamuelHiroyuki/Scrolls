package com.example.vitor.scrolsfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class CadastroEnderecoActivity extends AppCompatActivity {

    EditText txtNome, txtNum, txtCep, txtBairro, txtCidade;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);

        txtBairro = (EditText) findViewById(R.id.EnderecoBairroForm);
        txtCep = (EditText) findViewById(R.id.EnderecoCepForm);
        txtCidade = (EditText) findViewById(R.id.EnderecoCidadeForm);
        txtNome = (EditText) findViewById(R.id.EnderecoNomeForm);
        txtNum = (EditText) findViewById(R.id.EnderecoNumeroForm);
        spin = (Spinner) findViewById(R.id.SpinnerUf);

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNNNN-NNN");
        MaskTextWatcher mkf = new MaskTextWatcher(txtCep, smf);
        txtCep.addTextChangedListener(mkf);
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

            //Codigo para colocar no banco
            Intent intent = new Intent(this, PerfilActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Sucesso!!", Toast.LENGTH_LONG);
        }
        else{
            Toast.makeText(this,"Algum campo esta vazio", Toast.LENGTH_LONG);
        }
    }
}
