package com.example.retrofit2.models;

/**
 * Created by Richy on 28/02/2017.
 */

public class Car {
    String brand;
    int doors;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", doors='" + doors + '\'' +
                '}';
    }
}
