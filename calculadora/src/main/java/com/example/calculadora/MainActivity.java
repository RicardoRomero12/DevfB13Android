package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    TextView uno;
    TextView dos;
    TextView tres;
    TextView cuatro;
    TextView cinco;
    TextView seis;
    TextView siete;
    TextView ocho;
    TextView nueve;
    TextView cero;
    TextView punto;
    TextView operacion;
    String formula="";
    String numero = "";
    String numero2 = "";
    String operador="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        cero = (TextView) findViewById(R.id.cero);
        punto = (TextView) findViewById(R.id.punto);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        cero.setOnClickListener(this);
        punto.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.uno:
                operacion.setText(operacion.getText() + "1");
                numero += 1;
                Log.d("log",  numero+"");
                break;
            case R.id.dos:
                operacion.setText(operacion.getText() + "2");
                numero +=2;
                Log.d("log", numero+"");
                break;
            case R.id.tres:
                operacion.setText(operacion.getText() + "3");
                numero +=3;
                Log.d("log", numero+"");
                break;
            case R.id.cuatro:
                operacion.setText(operacion.getText() + "4");
                numero +=4;
                Log.d("log", numero+"");
                break;
            case R.id.cinco:
                operacion.setText(operacion.getText() + "5");
                numero +=5;
                Log.d("log", numero+"");
                break;
            case R.id.seis:
                operacion.setText(operacion.getText() + "6");
                numero +=6;
                Log.d("log", numero+"");
                break;
            case R.id.siete:
                operacion.setText(operacion.getText() + "7");
                numero +=7;
                Log.d("log", numero+"");
                break;
            case R.id.ocho:
                operacion.setText(operacion.getText() + "8");
                numero +=8;
                Log.d("log", numero+"");
                break;
            case R.id.nueve:
                operacion.setText(operacion.getText() + "9");
                numero +=9;
                Log.d("log", numero+"");
                break;
            case R.id.cero:
                operacion.setText(operacion.getText() + "0");
                numero +=0;
                Log.d("log", numero+"");
                break;
            case R.id.punto:
                operacion.setText(operacion.getText() +".");
                numero += ".";
                Log.d("log", numero +"");
                break;
        }


    }

}
