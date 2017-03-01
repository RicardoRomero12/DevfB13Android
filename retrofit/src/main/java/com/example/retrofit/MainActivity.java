package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    TextView repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repos = (TextView) findViewById(R.id.repos);
        repos.setText("");

        pokemons();

        getEvolutionChange();

        //getDataGitHubRepos();

        //getDataGitHub();


    }

    private void getEvolutionChange() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        service.getEvolutionChain(3,10).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Log.d("respuesta",response.message());
                Log.d("respuesta",response.code()+"");
                try {
                    Log.d("respuesta",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }


    public void pokemons(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        service.getPokemon(20).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String body = response.body().string();
                    JSONObject jsonObject = new JSONObject(body);
                    repos.append("Nombre: "+jsonObject.getString("name")+"\n\n");
                    JSONArray jsonArray = jsonObject.getJSONArray("moves");
                    for (int i = 0; i < jsonArray.length(); i++){
                        repos.append(jsonArray.getJSONObject(i).getJSONObject("move").getString("name")+"\n");
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }





    public void getDataGitHubRepos(){
        //Configuracion Basica de nuestro Retrofit

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();


        GitHubService service = retrofit.create(GitHubService.class);


        //Mandamos llamar funcion en la Interface para hacer la consulta en la url
        service.getUserRepos("kenmarquez").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                String body = null;
                try {
                    body = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    JSONArray jsonArray = new JSONArray(body);
                    for (int i = 0; i < jsonArray.length(); i++){
                        repos.append(jsonArray.getJSONObject(i).getString("name")+"\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("respuesta",""+t.getMessage());
            }
        });
    }


    
    public void getDataGitHub(){
        //Configuracion Basica de nuestro Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();


        GitHubService service = retrofit.create(GitHubService.class);

        service.getUserInfo("kenmarquez").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //Log.d("respuesta",""+response.code());
                try {
                   // Log.d("respuesta",response.body().string());
                    String body = response.body().string();
                    JSONObject jsonObject = new JSONObject(body);

                    Log.d("respuesta", jsonObject.getString("login"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("respuesta",""+t.getMessage());
            }
        });
    }

}
