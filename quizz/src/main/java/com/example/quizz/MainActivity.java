package com.example.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText nombre;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = (EditText) findViewById(R.id.nombre);
        button = (Button) findViewById(R.id.entrar);

        button.setOnClickListener(this);

        }


    @Override
    public void onClick(View view) {

        String nombre2 = nombre.getText().toString();
        switch (view.getId()) {
            case R.id.entrar:
                if (nombre2.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Es Necesario Ingresar Usuario",Toast.LENGTH_SHORT).show();
                } else {

                }
        }
    }
}
