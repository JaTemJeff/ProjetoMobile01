package com.example.aluno.projetomobile01;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    private Button botaoDica;
    private Button botaoLimpar;
    private EditText texto;
    private RadioGroup opcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Chama activity dica
        botaoDica = findViewById(R.id.button_dica_id);

        botaoDica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, DicaActivity.class));
            }
        });

        //Limpar
        botaoLimpar = findViewById(R.id.button_limpar_id);
        texto = findViewById(R.id.editText_nome_id);
        opcoes = findViewById(R.id.radioGroup_opcoes_id);
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
