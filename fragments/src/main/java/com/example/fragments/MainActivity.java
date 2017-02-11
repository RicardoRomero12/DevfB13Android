package com.example.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientacion = getResources().getConfiguration().orientation;

        if(orientacion == 1){
          View fragmento1 = findViewById(R.id.fragment1);
            fragmento1.setVisibility(View.GONE);
        }

        changeFragment(new PrimerFragment());

    }


    public void changeFragment(Fragment fragment){

        //Agregamos Dinamicamente el Fragment

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout1, fragment)
                .commit();
    }
}
