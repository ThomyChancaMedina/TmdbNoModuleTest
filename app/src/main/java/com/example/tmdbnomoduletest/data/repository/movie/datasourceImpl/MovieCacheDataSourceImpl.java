package com.example.tmdbnomoduletest.data.repository.movie.datasourceImpl;

import android.util.Log;

import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieCacheDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

public class MovieCacheDataSourceImpl implements MovieCacheDataSource {

    private final ArrayList<Movie> moviesList= new ArrayList<>();

    @Override
    public Flowable<List<Movie>> getMoviesFromCache() {
        Log.i("DLT thomy>>> ", moviesList.toString());
        return Flowable.just(moviesList);
    }

    @Override
    public void saveMoviesToCache(List<Movie> movies) {
        moviesList.clear();
        moviesList.addAll(movies);
    }
}
