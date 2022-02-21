package com.example.app2multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        TextView outName = findViewById(R.id.textViewOutName);
        TextView outMedia = findViewById(R.id.textViewMedia);
        TextView outFreq = findViewById(R.id.textViewFreq);
        TextView resultado = findViewById(R.id.textViewResult);

        Intent it = getIntent();

        if (it != null) {
            Bundle params = it.getExtras();

            if (params != null) {
                String result = params.getString("name_key");
                String media = params.getString("mf_key");
                String freq = params.getString("freq_key");
                outName.setText("Bem vindo " + result);
                outMedia.setText(media);
                outFreq.setText(freq);

                int mf = Integer.parseInt(media);
                int frequence = Integer.parseInt(freq);

                if (mf >= 70 && frequence >= 75 ) {
                    resultado.setText("Parabéns, você foi aprovado!");
                } else if (mf >= 40 && mf <= 69 && frequence >= 75) {
                    resultado.setText("Você ficou para a final!");
                } else if (frequence < 75) {
                    resultado.setText("Você foi reprovado por falta!");
                } else if (mf < 40) {
                    resultado.setText("Você foi reprovado por nota!");
                }

            }


        }
    }


}