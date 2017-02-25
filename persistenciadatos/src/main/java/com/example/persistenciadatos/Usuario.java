package com.example.persistenciadatos;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Richy on 24/02/2017.
 */

public class Usuario extends RealmObject {

    private String nombre;
    private String lastname;
    private int Age;
    private Cuenta cuenta;
    @PrimaryKey
    private int id;


    public Usuario() {
    }

    public Usuario(String nombre, String lastname, int age, int id) {
        this.nombre = nombre;
        this.lastname = lastname;
        Age = age;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", lastname='" + lastname + '\'' +
                ", Age=" + Age +
                ", cuenta=" + cuenta +
                ", id=" + id +
                '}';
    }
}