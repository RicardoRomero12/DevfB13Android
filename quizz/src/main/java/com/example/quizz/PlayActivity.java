package com.example.quizz;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.media.TransportPerformer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizz.Fragments.PuntajeFragment;
import com.example.quizz.Fragments.QuestionFragment;
import com.example.quizz.models.Questions;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {


    private List<Questions> questions = new ArrayList<>();
    private QuestionFragment questionFragment;
    private PuntajeFragment puntajeFragment;

    private int questionPosition;
    private int corretAnswer;
    private String texto;
    private int respuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Inicializa las Vistas


        Bundle extras = getIntent().getExtras();

        texto = extras.getString("name");

        initViews();

        initQuestions();


//Creamos el Fragmento con el que inciara mi Activity
        questionFragment = new QuestionFragment(questions.get(questionPosition).getTitle());




        //Ponemos nuestro Fragmento en el FrameLayout
        changerFragment(questionFragment);

    }

    private void initQuestions() {

        questions.add(new Questions(getString(R.string.burns),1));
        questions.add(new Questions(getString(R.string.nombre_homero),0));
        questions.add(new Questions(getString(R.string.disfraz_lisa),0));
        questions.add(new Questions(getString(R.string.mascota_juegos),1));
        questions.add(new Questions(getString(R.string.matricula),1));
    }


    //Metodo utilizado para configurar todas las vistas de mi layout
    private void initViews() {

        View view2 = findViewById(R.id.left);

        View view = findViewById(R.id.right);
        view.setOnClickListener(this);
        view2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.right:

         respuesta = questionFragment.respuesta;
        if (respuesta != -1) {
            if (respuesta == questions.get(questionPosition).getAnswer()) {
                corretAnswer++;
            }

            if (questionPosition == questions.size() - 1) {
                puntajeFragment = new PuntajeFragment(texto, corretAnswer);
                changerFragment(puntajeFragment);
                view.setVisibility(View.GONE);


                //Toast.makeText(this,"Tu puntaje es: " + corretAnswer +" de "+ questions.size(),Toast.LENGTH_SHORT).show();
            } else {
                questionPosition++;
                questionFragment = new QuestionFragment(questions.get(questionPosition).getTitle());
                changerFragment(questionFragment);
            }
        }

                break;

            case R.id.left:

                respuesta = questionFragment.respuesta;
                if (respuesta != -1) {
                    if (respuesta == questions.get(questionPosition).getAnswer()) {
                        corretAnswer--;
                    }

                    if (questionPosition == questions.size() - 1) {
                        puntajeFragment = new PuntajeFragment(texto, corretAnswer);
                        changerFragment(puntajeFragment);
                        view.setVisibility(View.GONE);


                        //Toast.makeText(this,"Tu puntaje es: " + corretAnswer +" de "+ questions.size(),Toast.LENGTH_SHORT).show();
                    } else {
                        questionPosition--;
                        questionFragment = new QuestionFragment(questions.get(questionPosition).getTitle());
                        changerFragment(questionFragment);
                    }
                }


                break;
    }
    }

    public void changerFragment(Fragment fragment){


        /*
        Obtengo el FragmentManager que me ayude con las transacciones
        que necesite hacer con mis fragmentos
         */
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.contenedor,fragment)
                .commit();
    }
}
