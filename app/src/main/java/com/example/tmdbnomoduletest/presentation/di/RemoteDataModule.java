package com.example.tmdbnomoduletest.presentation.di;

import com.example.tmdbnomoduletest.data.api.TMDBService;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieRemoteDataSource;
import com.example.tmdbnomoduletest.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RemoteDataModule {

    private final String apikey;
    public RemoteDataModule(String apikey) {
        this.apikey = apikey;
    }

    @Provides
    @Singleton
    MovieRemoteDataSource provideMovieRemoteDataSource(TMDBService tmdbService){
        return new MovieRemoteDataSourceImpl(tmdbService,apikey);
    }


}
