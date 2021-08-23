package com.example.tmdbnomoduletest.presentation.di;

import com.example.tmdbnomoduletest.data.repository.movie.MovieRepositoryImpl;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieCacheDataSource;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieLocalDataSource;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieRemoteDataSource;
import com.example.tmdbnomoduletest.domain.MovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    MovieRepository provideMovieRepository(
            MovieRemoteDataSource movieRemoteDataSource,
            MovieLocalDataSource movieLocalDataSource,
            MovieCacheDataSource movieCacheDataSource
    ) {
        return new MovieRepositoryImpl(
                movieRemoteDataSource,
                movieLocalDataSource,
                movieCacheDataSource
        );
    }


}
