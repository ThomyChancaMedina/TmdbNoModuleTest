package com.example.tmdbnomoduletest.presentation.di;

import com.example.tmdbnomoduletest.data.db.MovieDao;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieLocalDataSource;
import com.example.tmdbnomoduletest.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalDataModule {

    @Provides
    @Singleton
    MovieLocalDataSource provideMovieLocalDataSource(MovieDao movieDao){
        return new MovieLocalDataSourceImpl(movieDao);
    }

}
