package com.example.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyItemListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        MyAdapter myAdapter= new MyAdapter(createListAnimales(),this);

        myAdapter.setMyItemListener(this);

        recyclerView.setAdapter(myAdapter);

    }


    private List<Animales> createListAnimales(){

        List<Animales> animales = new ArrayList<>();
        animales.add(new Animales("Perro","Cafe","http://comunidad.mascotadictos.com/uploads/default/8683/e6944b2043b5dd79.jpg"));
        animales.add(new Animales("Gato","Negro","http://www.schnauzi.com/wp-content/uploads/2012/11/gatito-negro.jpg"));
        animales.add(new Animales("Perico","Australiano","https://t1.ea.ltmcdn.com/es/images/3/2/4/img_cuanto_vive_un_periquito_australiano_20423_600.jpg"));
        animales.add(new Animales("Pato","Negro","https://www.icesi.edu.co/wiki_aves_colombia/show_image.php?id=2578&scalesize=o"));
        animales.add(new Animales("Leon","Rey de la Selva","http://www.estudiantes.info/ciencias_naturales/images/leonpadre2.jpg"));
        animales.add(new Animales("Tortuga","Galapagos","http://animales-extintos.com/wp-content/uploads/2016/03/tortuga_galapagos.jpg"));

            return animales;

    }

    @Override
    public void onItemClick(int posicion, String name) {
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }
}
