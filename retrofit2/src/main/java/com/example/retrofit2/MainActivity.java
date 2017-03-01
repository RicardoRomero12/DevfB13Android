package com.example.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.retrofit2.data.ApiClient;
import com.example.retrofit2.data.ServiceGenerator;
import com.example.retrofit2.models.Car;
import com.example.retrofit2.models.Repo;
import com.example.retrofit2.models.UserCreated;
import com.example.retrofit2.utils.Constants;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //createUserPost();

        //jsonToObjetct();

       // objectToJson();

       // createUserPostGson();

        getRepos();
    }

    private void objectToJson() {

        Gson gson = new Gson();
        Car car = new Car();
        car.setBrand("Rover");
        car.setDoors(5);

        String json = gson.toJson(car);

        Log.d(Constants.LOG_NAME, json);



    }

    private void jsonToObjetct() {

        String json = "{\"brand\":\"Jeep\",\"doors\": 3}";

        Gson gson = new Gson();

        Car car = gson.fromJson(json, Car.class);

        Log.d(Constants.LOG_NAME, car.toString());
    }


    public void createUserPost(){

        ApiClient apiClient = ServiceGenerator.createService();

        apiClient.crearUsuario("Romero","Rodriguez","ricardo2@outlook.com ","Ricardo")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                        int statusCode = response.code();
                            if(statusCode == 200 || statusCode == 201){
                                Log.d("respuesta", response.code()+"");
                                Log.d("respuesta", response.message()+"");
                                Log.d("respuesta", response.body().toString());
                            }else{
                                Log.d("respuesta","Hubo un Error");
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

    }


    public void createUserPostGson(){

        ApiClient apiClient = ServiceGenerator.createService();

        apiClient.createUserGson("Romero","Rodriguez","ricaro@outlook.com ","Ricardo")
                .enqueue(new Callback<UserCreated>() {
                    @Override
                    public void onResponse(Call<UserCreated> call, Response<UserCreated> response) {
                        int statusCode = response.code();
                        if(statusCode==200 || statusCode==201){
                            UserCreated user= response.body();
                            Log.d(Constants.LOG_NAME,user.toString());
                        }else{

                        }
                    }

                    @Override
                    public void onFailure(Call<UserCreated> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

    }


    public void getRepos(){
        ApiClient apiClient = ServiceGenerator.createService();

        apiClient.getRepos().enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> body = response.body();
                for (int i = 0; i < body.size(); i++) {
                    Log.d(Constants.LOG_NAME, body.get(i).toString());

                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
