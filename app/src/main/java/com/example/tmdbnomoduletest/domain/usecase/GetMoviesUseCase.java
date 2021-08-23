package com.example.tmdbnomoduletest.domain.usecase;

import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.domain.MovieRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class GetMoviesUseCase {

    private final MovieRepository movieRepository;

    public GetMoviesUseCase( MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

   public Observable<List<Movie>> execute(){
      return movieRepository.getMovies();
    }

}
