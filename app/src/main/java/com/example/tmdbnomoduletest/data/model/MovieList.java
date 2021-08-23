package com.example.tmdbnomoduletest.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList {
    @SerializedName("results")
    public List<Movie> movies;
}
