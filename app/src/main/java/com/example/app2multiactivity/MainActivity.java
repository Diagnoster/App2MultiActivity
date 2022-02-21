package com.example.app2multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText inputName = findViewById(R.id.editTextName);
        EditText frequence = findViewById(R.id.editTextFrequence);
        EditText nota1 = findViewById(R.id.editTextNota1);
        EditText nota2 = findViewById(R.id.editTextNota2);

        if (inputName.length() == 0 || frequence.length() == 0) {
            Toast msg = Toast.makeText(this, "Insira um valor no campo", Toast.LENGTH_SHORT);
            msg.show();
        } else {
            Intent it = new Intent(this, Resultado.class);
            String name = inputName.getText().toString();
            int not1 = Integer.parseInt(nota1.getText().toString());
            int not2 = Integer.parseInt(nota2.getText().toString());
            int MediaFinal = (not1 + not2) / 2;
            String mf = Integer.toString(MediaFinal);
            String freq = frequence.getText().toString();

            Bundle params = new Bundle();
            params.putString("name_key", name);
            params.putString("mf_key", mf);
            params.putString("freq_key", freq);

            it.putExtras(params);
            startActivity(it);
        }
    }
}