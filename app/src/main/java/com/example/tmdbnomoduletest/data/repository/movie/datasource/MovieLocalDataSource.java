package com.example.tmdbnomoduletest.data.repository.movie.datasource;

import com.example.tmdbnomoduletest.data.model.Movie;

import java.util.List;

import io.reactivex.Flowable;

public interface MovieLocalDataSource {
    Flowable<List<Movie>> getMovies();
    void saveMoviesToDB(List<Movie> movies);
    void clearAll();
}
