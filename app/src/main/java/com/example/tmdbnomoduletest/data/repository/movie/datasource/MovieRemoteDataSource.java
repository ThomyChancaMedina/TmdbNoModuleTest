package com.example.tmdbnomoduletest.data.repository.movie.datasource;

import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.data.model.MovieList;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRemoteDataSource {
    Observable<List<Movie>> getMovies();
}
