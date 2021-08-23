package com.example.tmdbnomoduletest.domain;

import com.example.tmdbnomoduletest.data.model.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRepository {

    Observable<List<Movie>> getMovies();
    Observable<List<Movie>> updateMovies();


}
