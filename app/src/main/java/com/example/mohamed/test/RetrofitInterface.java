package com.example.mohamed.test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
   public  String apiKey = "782d50ad722ebcdc90e41160707bdede";


   // http://api.themoviedb.org/3/movie/popular?api_key=89f2f5dacd021ea83c2b2aff5a2b3db7

    @GET("/3/movie/{popular}?")
    Call<MovieList> getPopulate(@Path("popular") String popular, @Query("api_key") String apiKey);

    @GET("/3/movie/{top_rated}?")
    Call<MovieList> getTopRatedMovi(@Path("top_rated") String top_rated, @Query("api_key") String apiKey);



}
