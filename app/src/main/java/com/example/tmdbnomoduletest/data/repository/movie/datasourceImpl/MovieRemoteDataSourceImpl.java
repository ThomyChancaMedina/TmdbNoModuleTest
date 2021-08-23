package com.example.tmdbnomoduletest.data.repository.movie.datasourceImpl;

import com.example.tmdbnomoduletest.data.api.TMDBService;
import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.data.model.MovieList;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieRemoteDataSource;

import java.util.List;

import io.reactivex.Observable;

public class MovieRemoteDataSourceImpl implements MovieRemoteDataSource {

    private final TMDBService tmdbService;
    private final String apikey;

    public MovieRemoteDataSourceImpl(TMDBService tmdbService, String apikey) {
        this.tmdbService = tmdbService;
        this.apikey = apikey;
    }

    @Override
    public Observable<List<Movie>> getMovies() {
        return tmdbService.getPopularMovies(apikey);
    }

}
