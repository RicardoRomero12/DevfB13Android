package com.example.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuintoFragment extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private String text;
    public String datoInicial;
    private OnFragment4InteractionListener mlistener;
    private TextView textView;
    private int contador;

    public static QuintoFragment newInstance(String texto){
        //Creo una instancia de QuintoFragment
        QuintoFragment fragment = new QuintoFragment();

        //Creo Bundle que guardara los datos de mi fragmento
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,texto);
        //Asocio mi bundle a mi fragmento
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            Bundle bundle = getArguments();
            text = bundle.getString(ARG_PARAM1);
        }
    }

    public QuintoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quinto, container, false);
        textView = (TextView) view.findViewById(R.id.contador5);

        datoInicial = text +" wuju!!";

        textView.setText(datoInicial);


        //Referencio mi Layout principal
        View rootLayout = view.findViewById(R.id.fragment4);
        //Le agrego un escuchador de click al layout principal
        rootLayout.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }


    //Metodo que se lanza cuando la actividad esta vinculada con el fragmento

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            mlistener = (OnFragment4InteractionListener) context;
        }
    }

    //Mostrar los datos en el Fragment
    public void setDatoInicial(String s){
        textView.setText(s);
    }
    //Mostrar los datos en la activity
    public int getDatoInicial(){
        contador++;
        return contador;
    }

    @Override
    public void onClick(View view) {

        contador++;
        mlistener.OnFragment4Interaction(String.valueOf(contador));

    }

    public interface OnFragment4InteractionListener{

        public void OnFragment4Interaction(String data);

    }


}
