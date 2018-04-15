package com.example.aluno.projetomobile01;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botaoDica;
    private Button botaoLimpar;
    private EditText texto;
    private RadioGroup opcoes;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoDica = findViewById(R.id.button_dica_id);
        botaoLimpar = findViewById(R.id.button_limpar_id);
        texto = findViewById(R.id.editText_nome_id);
        opcoes = findViewById(R.id.radioGroup_opcoes_id);


        //Chama activity dica
        botaoDica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, DicaActivity.class);

                intent.putExtra("nomePassado", texto.getText().toString());
                intent.putExtra("opcao", opcoes.getCheckedRadioButtonId());

                startActivity(intent);


                if(opcoes.getCheckedRadioButtonId() > 0){
                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nomeDigitado", texto.getText().toString());
                    editor.putInt("situacaoSelecionada", opcoes.getCheckedRadioButtonId());
                    editor.commit();

                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if(sharedPreferences.contains("nomeDigitado")){
            texto.setText(sharedPreferences.getString("nomeDigitado", texto.getText().toString()));
        }
        if(sharedPreferences.contains("situacaoSelecionada")){
            opcoes.check((sharedPreferences.getInt("situacaoSelecionada", opcoes.getCheckedRadioButtonId())));
        }

        //Limpar
        botaoLimpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                texto.setText("");
                opcoes.clearCheck();
            }
        });
    }

    //Infla Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //Chama activity ajuda do menu de opções
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_ajuda:
                startActivity(new Intent(MainActivity.this, AjudaActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
