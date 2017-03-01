package com.example.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Richy on 27/02/2017.
 */

public interface GitHubService {


    @GET("users/{name}")
    Call<ResponseBody> getUserInfo(@Path("name") String userName);

    @GET("users/{name}/repos")
    Call<ResponseBody> getUserRepos(@Path("name") String userName);


    @GET("api/v2/pokemon/{numero}")
    Call<ResponseBody> getPokemon(@Path("numero") int numero);

    @GET("api/v2/evolution-chain/")
    Call<ResponseBody> getEvolutionChain(@Query("limit") int limit, @Query("offset") int offset);
}
