package com.example.tmdbnomoduletest.domain.usecase;

import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.domain.MovieRepository;

import java.util.List;

import io.reactivex.Observable;

public class UpdateMoviesUseCase {

    private final MovieRepository movieRepository;

    public UpdateMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Observable<List<Movie>> execute() {
        return movieRepository.updateMovies();
    }
}
