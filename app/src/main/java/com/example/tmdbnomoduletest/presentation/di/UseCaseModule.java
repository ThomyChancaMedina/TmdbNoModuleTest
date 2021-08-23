package com.example.tmdbnomoduletest.presentation.di;

import com.example.tmdbnomoduletest.domain.MovieRepository;
import com.example.tmdbnomoduletest.domain.usecase.GetMoviesUseCase;
import com.example.tmdbnomoduletest.domain.usecase.UpdateMoviesUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {
    @Provides
    GetMoviesUseCase provideGetMovieUseCase(MovieRepository movieRepository){
        return new GetMoviesUseCase(movieRepository);
    }

    @Provides
    UpdateMoviesUseCase provideUpdateMovieUseCase(MovieRepository movieRepository){
        return  new UpdateMoviesUseCase(movieRepository);
    }
}
