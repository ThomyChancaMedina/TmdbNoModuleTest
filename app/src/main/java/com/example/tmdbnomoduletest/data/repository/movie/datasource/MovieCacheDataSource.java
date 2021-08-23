package com.example.tmdbnomoduletest.data.repository.movie.datasource;

import com.example.tmdbnomoduletest.data.model.Movie;

import java.util.List;

import io.reactivex.Flowable;

public interface MovieCacheDataSource {

    Flowable<List<Movie>> getMoviesFromCache();

    void saveMoviesToCache(List<Movie> movies);

}
