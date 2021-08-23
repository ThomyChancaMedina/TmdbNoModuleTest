package com.example.tmdbnomoduletest.presentation.movie;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.tmdbnomoduletest.domain.usecase.GetMoviesUseCase;
import com.example.tmdbnomoduletest.domain.usecase.UpdateMoviesUseCase;

import org.jetbrains.annotations.NotNull;

import kotlin.Suppress;

@SuppressWarnings("unchecked")
public class MovieViewModelFactory implements ViewModelProvider.Factory {

    private final GetMoviesUseCase getMoviesUseCase;
    private final UpdateMoviesUseCase updateMoviesUseCase;

    public MovieViewModelFactory(GetMoviesUseCase getMoviesUseCase, UpdateMoviesUseCase updateMoviesUseCase) {
        this.getMoviesUseCase = getMoviesUseCase;
        this.updateMoviesUseCase = updateMoviesUseCase;
    }

    @NotNull
    @Override
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
//            MovieViewModel movieViewModel=new MovieViewModel(getMoviesUseCase,updateMoviesUseCase);

        return  (T) new MovieViewModel(getMoviesUseCase,updateMoviesUseCase);
    }
}
