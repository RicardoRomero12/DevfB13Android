package com.example.quizz.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.RemoteInput;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizz.R;

import org.w3c.dom.Text;

public class PuntajeFragment extends Fragment {

    TextView nombre;
    TextView puntaje;
    private String nombreU;
    private int puntajeU;


    public PuntajeFragment(){
        this.nombreU="";
        this.puntajeU=0;
    }

    @SuppressLint("ValidFragment")
    public PuntajeFragment(String texto, int corretAnswer) {
        this.nombreU=texto;
        this.puntajeU=corretAnswer;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_puntaje, container, false);


        nombre= (TextView) view.findViewById(R.id.nombre_user);
        puntaje= (TextView) view.findViewById(R.id.quiz_tv_puntaje);

        String puntajeFinal = Integer.toString(puntajeU);

        nombre.setText(nombreU);
        puntaje.setText(puntajeFinal);

        return view;




    }


}
