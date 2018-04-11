package com.example.aluno.projetomobile01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DicaActivity extends AppCompatActivity {

    private Button botaoVoltarDica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dica);

        //Botao voltar finish() encerra activity
        botaoVoltarDica = findViewById(R.id.button_voltar_dica_id);
        botaoVoltarDica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
