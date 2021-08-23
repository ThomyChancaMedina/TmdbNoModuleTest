package com.example.tmdbnomoduletest.presentation.movie;

import androidx.lifecycle.ViewModel;

import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.domain.usecase.GetMoviesUseCase;
import com.example.tmdbnomoduletest.domain.usecase.UpdateMoviesUseCase;

import java.util.List;

import io.reactivex.Observable;

public class MovieViewModel extends ViewModel {

    private final GetMoviesUseCase getMoviesUseCase;
    private final UpdateMoviesUseCase updateMoviesUseCase;

    public MovieViewModel(GetMoviesUseCase getMoviesUseCase, UpdateMoviesUseCase updateMoviesUseCase) {
        this.getMoviesUseCase = getMoviesUseCase;
        this.updateMoviesUseCase = updateMoviesUseCase;
    }

   public Observable<List<Movie>> getMovies(){
        return getMoviesUseCase.execute();
    }

   public Observable<List<Movie>> updateMovies(){
        return updateMoviesUseCase.execute();
    }

}
