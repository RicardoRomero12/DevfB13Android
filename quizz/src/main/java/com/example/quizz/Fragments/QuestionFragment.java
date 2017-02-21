package com.example.quizz.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizz.R;


public class QuestionFragment extends Fragment implements View.OnClickListener {

    private final String title;
    private TextView tvTrue;
    private TextView tvFalse;
    public int respuesta=-1;

    public QuestionFragment(){
        title="";
    }

    @SuppressLint("ValidFragment")
    public QuestionFragment(String title){
        this.title=title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question,container,false);


        TextView tvTitle = (TextView) view.findViewById(R.id.titulo);

        tvTitle.setText(title);

        tvTrue = (TextView) view.findViewById(R.id.quiz_tv_true);
        tvFalse = (TextView) view.findViewById(R.id.quiz_tv_false);
        tvTrue.setOnClickListener(this);
        tvFalse.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.quiz_tv_true:
                respuesta = 1;
                   tvTrue.setBackgroundResource(R.color.btn_selected);
                   tvFalse.setBackgroundResource(R.color.btn_unselected);
                break;
            case R.id.quiz_tv_false:
                respuesta=0;
                    tvFalse.setBackgroundResource(R.color.btn_selected);
                    tvTrue.setBackgroundResource(R.color.btn_unselected);
                break;
        }

    }
}
