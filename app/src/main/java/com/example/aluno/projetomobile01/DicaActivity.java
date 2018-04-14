package com.example.aluno.projetomobile01;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DicaActivity extends AppCompatActivity {

    private RadioButton escolha;
    private TextView mensagem;
    private Button botaoVoltarDica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dica);

        mensagem = findViewById(R.id.textView_mensagem_id);

        Bundle extra = getIntent().getExtras();

        int idRadioButton = extra.getInt("opcao");
        String nome = extra.getString("nomePassado");
        String txt = "";

        switch (idRadioButton) {

            case R.id.radioButton_empregado_id:
                txt = getText(R.string.texto_empregado).toString();
                mensagem.setText(txt+ " " +nome + "!");
                break;

            case R.id.radioButton_desempregado_id:
                txt = getText(R.string.texto_desempregado).toString();
                mensagem.setText(txt + " " + nome + "!");
                break;

            case R.id.radioButton_naoprocuraocupacao_id:
                txt = getText(R.string.texto_naoprocura).toString();
                mensagem.setText(txt + " " + nome + "!");
                break;

            default:
                txt = getText(R.string.texto_naoescolheu).toString();
                mensagem.setText(txt);
        }

        //Botao voltar finish() encerra activity
        botaoVoltarDica = findViewById(R.id.button_voltar_dica_id);
        botaoVoltarDica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
