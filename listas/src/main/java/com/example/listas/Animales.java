package com.example.listas;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Richy on 20/02/2017.
 */

public class Animales extends RealmObject {

    private String nombre;
    private String descripcion;
    private String url;


    public Animales() {

    }

    public Animales(String nombre, String descripcion, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }





}
