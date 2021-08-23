package com.example.tmdbnomoduletest.presentation.di.movie;

import com.example.tmdbnomoduletest.domain.usecase.GetMoviesUseCase;
import com.example.tmdbnomoduletest.domain.usecase.UpdateMoviesUseCase;
import com.example.tmdbnomoduletest.presentation.movie.MovieViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieModule {
    @Provides
    @MovieScope
    MovieViewModelFactory provideMovieViewMovieFactory(
            GetMoviesUseCase getMoviesUseCase,
            UpdateMoviesUseCase updateMoviesUseCase
    ){
        return new MovieViewModelFactory(getMoviesUseCase,updateMoviesUseCase);
    }
}
