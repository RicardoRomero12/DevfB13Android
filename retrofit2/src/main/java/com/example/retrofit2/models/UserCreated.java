package com.example.retrofit2.models;

/**
 * Created by Richy on 28/02/2017.
 */

public class UserCreated {
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String email;
    private boolean is_active;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getEmal() {
        return email;
    }

    public void setEmal(String email) {
        this.email = email;
    }

    public boolean is_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }


    @Override
    public String toString() {
        return "UserCreated{" +
                "nombre='" + nombre + '\'' +
                ", apaterno='" + apaterno + '\'' +
                ", amaterno='" + amaterno + '\'' +
                ", email='" + email + '\'' +
                ", is_active=" + is_active +
                '}';
    }
}
