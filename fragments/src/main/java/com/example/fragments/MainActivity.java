package com.example.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CuartoFragment.OnFragment4InteractionListener {

    private CuartoFragment fragment;
    private QuintoFragment quintoFragment;
    private String contador1="0";
    private String contador2="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientacion = getResources().getConfiguration().orientation;

        if(orientacion == 1){
          View fragmento1 = findViewById(R.id.fragment1);
            fragmento1.setVisibility(View.GONE);
        }

       // changeFragment(new PrimerFragment());
        fragment = CuartoFragment.newInstance(contador1);
        quintoFragment = QuintoFragment.newInstance(contador2);

        changeFragment(fragment,"f4");

    }

    @Override
    protected void onResume() {
        super.onResume();

        QuintoFragment quintoFragment = (QuintoFragment)
                getSupportFragmentManager().findFragmentByTag("f5");
        if(quintoFragment!=null){
            quintoFragment.setDatoInicial(contador2);
        }


        CuartoFragment fragment =(CuartoFragment)
                getSupportFragmentManager().findFragmentByTag("f4");
        if(fragment != null){
            fragment.setDatoInicial(contador1);
        }
    }


    //No permite que la pantalla se pueda votear, solo permite vertical
    // android:screenOrientation="portrait"


    public void changeFragment(Fragment fragment, String tag){

        //Agregamos Dinamicamente el Fragment

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout1, fragment, tag)
                .commit();
    }

    @Override
    public void OnFragment4Interaction(String data) {
        Toast.makeText(this, data,Toast.LENGTH_SHORT).show();
        contador1=data;
    }
}
