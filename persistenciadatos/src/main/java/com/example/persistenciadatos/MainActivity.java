package com.example.persistenciadatos;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText texto;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  texto=(EditText) findViewById(R.id.texto);
      //  guardar = (Button) findViewById(R.id.guardar);
      //  guardar.setOnClickListener(this);


        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);


        saveUser();
        getUser();


    }


    public void printSaludo(){
        SharedPreferences preferences = getSharedPreferences("Mis_preferencias",MODE_PRIVATE);
        String saludo = preferences.getString("saludo","Saludo por primera vez");
        Log.d("log",saludo);
    }

    public void saveSaludo(){
        SharedPreferences preferences = getSharedPreferences("Mis_preferencias",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String texto2= texto.getText().toString();
        editor.putString("saludo",texto2);
        editor.commit();
    }

    @Override
    public void onClick(View view) {
        saveSaludo();
        printSaludo();
    }

    public void saveUser(){

        Realm realm = Realm.getDefaultInstance();

        int id=2;

        Usuario user = new Usuario();
        user.setNombre("Ricardo");
        user.setLastname("Romero");
        user.setAge(24);
        user.setId(id);

        Cuenta cuenta= new Cuenta();
        cuenta.setCuenta("123123123");
        cuenta.setDeuda(0);
        cuenta.setSaldo(1000000);
        cuenta.setUserKey(id);
        cuenta.setIdCuenta(100);

        user.setCuenta(cuenta);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
     //   realm.copyToRealmOrUpdate(cuenta);
        realm.commitTransaction();

    }
    public void getUser(){
        Realm realm = Realm.getDefaultInstance();
        List<Usuario> usuarios = realm.where(Usuario.class).findAll();


        for(int i = 0; i<usuarios.size();i++){

            Log.d("log",usuarios.get(i).toString());
        }

        //Agregar Tabla cuenta y buscar relacion con usuario
     /*   for(int i = 0; i<usuarios.size();i++){
            Cuenta cuenta = realm.where(Cuenta.class)
                    .equalTo("userKey",usuarios.get(i).getId())
                    .findFirst();

            if(cuenta != null){
                Log.d("log",usuarios.get(i).toString());
                Log.d("log",cuenta.toString());
            }

        }*/
    }


}
