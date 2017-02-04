package com.example.richy.devfb13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*    Padre padre = new Padre("Ricardo", 24);
        Madre madre = new Madre("Alejandra", 26);
        Hijo hijo = new Hijo("Victoria",4);
        Bebe bebe = new Bebe("Alo", 2);

        saludos(padre);
        saludos(madre);
        saludos(hijo);
        saludos(bebe);*/


        palindromo("anita lava la tina");
    }

    private void palindromo(String ana) {
        String palindromo2 = ana;
        String palindromo = palindromo2.replace(" ","");
        int inc = 0;
        int des = palindromo.length()-1;
        boolean bError = false;
        while ((inc<des) && (!bError)){

            if (palindromo.charAt(inc)==palindromo.charAt(des)){
                inc++;
                des--;
            } else {
                bError = true;
            }
        }

        if (!bError)
            Log.d("log", palindromo2 + " es un PALINDROMO");
        else
            Log.d("log", palindromo2 + " NO es un palindromo");

    }



   /* public void saludos(Familiar familiar){
        if(familiar instanceof Padre){
            Padre padre = (Padre) familiar;
            padre.saludo();
        }else if(familiar instanceof Madre){
            Madre madre = (Madre) familiar;
            madre.saludo();
        }else if(familiar instanceof Hijo){
            Hijo hijo = (Hijo) familiar;
            hijo.saludo();
        }else if (familiar instanceof Bebe){
            Bebe bebe = (Bebe) familiar;
            bebe.saludo();
        }

    }*/


}
