package com.example.toolbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mi app");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar!= null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_accion1:
                Toast.makeText(this,"Accion 1",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.menu_accion2:
                final ViewGroup viewGroup = (ViewGroup) ((ViewGroup)this
                        .findViewById(android.R.id.content)).getChildAt(0);


                Snackbar.make(viewGroup,"Accion 2",Snackbar.LENGTH_SHORT).show();

                break;
            case R.id.bluethoot:

                final ViewGroup rootView = (ViewGroup) ((ViewGroup)this
                        .findViewById(android.R.id.content)).getChildAt(0);

                   Snackbar snackbar = Snackbar
                        .make(rootView,"Message id deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener(){

                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(rootView, "Message es restored", Snackbar.LENGTH_LONG);
                                        snackbar1.show();
                            }
                        });

                snackbar.show();

                break;

            case android.R.id.home:
                super.onBackPressed();
                break;

        }
        return true;
    }
}
