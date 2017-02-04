package com.example.richy.devfb13;

import android.util.Log;

/**
 * Created by Richy on 02/02/2017.
 */

public class Padre extends Familiar {



    public Padre(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    public void saludo(){
        Log.d("Saludo:","Hola");
    }
}
