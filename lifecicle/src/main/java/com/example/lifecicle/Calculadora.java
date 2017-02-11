package com.example.lifecicle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Richy on 08/02/2017.
 */

public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    TextView uno;
    TextView dos;
    TextView tres;
    TextView cuatro;
    TextView cinco;
    TextView seis;
    TextView siete;
    TextView ocho;
    TextView nueve;
    TextView operacion;
    TextView resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        operacion = (TextView) findViewById(R.id.numeros);
        uno = (TextView) findViewById(R.id.uno);
        dos = (TextView) findViewById(R.id.dos);
        tres = (TextView) findViewById(R.id.tres);
        cuatro = (TextView) findViewById(R.id.cuatro);
        cinco = (TextView) findViewById(R.id.cinco);
        seis = (TextView) findViewById(R.id.seis);
        siete = (TextView) findViewById(R.id.siete);
        ocho = (TextView) findViewById(R.id.ocho);
        nueve = (TextView) findViewById(R.id.nueve);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.uno:

        }
    }
}

