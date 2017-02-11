package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{

    private TextView tv;
    EditText texto;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.cambiar);
        texto = (EditText) findViewById(R.id.texto);
        linearLayout =(LinearLayout) findViewById(R.id.linear_boton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv.setOnLongClickListener(this);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.streetview");
            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
        String text = texto.getText().toString();
        Intent intent = new Intent(MainActivity.this,SegundaActivity.class);
        intent.putExtra("texto", text);

        startActivity(intent);
        return false;
    }
}
