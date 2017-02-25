package com.example.listas;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Richy on 21/02/2017.
 */

public class RealmManager {

    private Realm realm;

    public RealmManager(){
        realm = Realm.getDefaultInstance();
    }

    public void saveAnimal(String name, String descripcion){
        Animales animales = new Animales(name,descripcion,"https://www.icesi.edu.co/wiki_aves_colombia/show_image.php?id=2578&scalesize=o");

        realm.beginTransaction();
        realm.copyToRealm(animales);
        realm.commitTransaction();
    }


    public List<Animales> getAnimals(){
        RealmResults<Animales> animalesRealmResults  = realm.where(Animales.class).findAll();

        List<Animales> animalesList = new ArrayList<>();

        for(Animales animales : animalesRealmResults){
            animalesList.add(animales);
        }

        return animalesList;
    }

}
