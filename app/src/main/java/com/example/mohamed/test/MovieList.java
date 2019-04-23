package com.example.mohamed.test;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList {
    @SerializedName("results")
    @Expose
    private  List<Movie> moviList;

    public   List<Movie> getMoviList() {
        return moviList;
    }

    public void setMoviList(List<Movie> moviList) {

        this.moviList = moviList;
    }
}

