package com.example.listas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAnimalsActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText name;
    private EditText description;
    private Button saveanimal;
    private Button getAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_animals);

        name = (EditText) findViewById(R.id.nombre);
        description = (EditText) findViewById(R.id.descripcion);
        saveanimal= (Button) findViewById(R.id.guardar);
        getAnimals = (Button) findViewById(R.id.consultar);


        saveanimal.setOnClickListener(this);
        getAnimals.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.guardar:

                saveAnimal();

                break;
            case R.id.consultar:
                showAnimals();
                break;
        }
    }



    private void saveAnimal() {

        RealmManager realManger = new RealmManager();
        realManger.saveAnimal(name.getText().toString(),description.getText().toString());

    }


    private void showAnimals() {

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
