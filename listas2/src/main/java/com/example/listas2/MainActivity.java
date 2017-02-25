package com.example.listas2;

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

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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
        animales.add(new Animales("Delfin","Animal Acautico mas Inteligente","http://www.vootar.com/imgs/elementos/1252424735_Delfin.jpg"));
        animales.add(new Animales("Pingüino","Vive en lugares frios","http://www.fernandoperdices.net/wordpress/wp-content/uploads/2012/09/fernandofernandezperdices_png_89-14.jpg"));
        animales.add(new Animales("Canguro","Originario de Australia","http://www.revistaepets.com/wp-content/uploads/2015/08/Canguros-8.jpg"));
        animales.add(new Animales("Elefante","Tiene colmillos de marfil","http://www.revistaepets.com/wp-content/uploads/2015/02/Elefante-Africano-6.jpg"));
        animales.add(new Animales("Tigre","Blanco","http://st-listas.20minutos.es/images/2011-08/300793/3151150_640px.jpg?1358613291"));

        return animales;

    }

    @Override
    public void onItemClick(int posicion, String name) {
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }
}

