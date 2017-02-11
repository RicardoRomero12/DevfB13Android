package com.example.lifecicle;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MiInterface , View.OnClickListener{

    private MainActivity miInterfaz;
    Button convert;
    Button convertD;
    EditText pesos;
    EditText dolares;
    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("tag","OnCreate");


        pesos = (EditText) findViewById(R.id.edit_pesos);
        dolares = (EditText) findViewById(R.id.edit_dolar);
        convert = (Button) findViewById(R.id.boton);
        convertD = (Button) findViewById(R.id.botonD);

        convert.setOnClickListener(this);
        convertD.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag","OnStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag","OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag","OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag","OnDestroy");
    }

    @Override
    public void miAccion() {

        Log.d("tag","miAcccion");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonD:
                if(pesos!=null){
               String peso=pesos.getText().toString();
               double p = Double.parseDouble(peso);
                resultado= p/20.67;
                Log.d("tag", resultado +"  Dolares");
                }else{
                    Toast.makeText(getApplicationContext(),"Debes Ingresar la Cantidad a Convertir", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.boton:
                if(dolares!=null) {
                    String dolar = dolares.getText().toString();
                    double d = Double.parseDouble(dolar);
                    resultado = d * 20.67;
                    Log.d("tag", resultado + "  Pesos");
                }else{
                    Toast.makeText(getApplicationContext(),"Deber Ingresar la Cantidad a Convertir", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
