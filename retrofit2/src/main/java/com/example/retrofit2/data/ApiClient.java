package com.example.retrofit2.data;

import android.widget.LinearLayout;

import com.example.retrofit2.models.Repo;
import com.example.retrofit2.models.UserCreated;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Richy on 28/02/2017.
 */

public interface ApiClient {

    @FormUrlEncoded
    @POST("/api/v1/users/")
    Call<ResponseBody> crearUsuario(@Field("apaterno") String apaterno,
                                    @Field("amaterno") String amaterno,
                                    @Field("email") String email,
                                    @Field("nombre") String nombre);


    @FormUrlEncoded
    @POST("/api/v1/users/")
    Call<UserCreated> createUserGson(@Field("apaterno") String apaterno,
                                    @Field("amaterno") String amaterno,
                                    @Field("email") String email,
                                    @Field("nombre") String nombre);


    @GET("/users/kenMarquez/repos")
    Call<List<Repo>> getRepos();




}
