package com.example.tmdbnomoduletest.presentation.di;

import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieCacheDataSource;
import com.example.tmdbnomoduletest.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheDataModule {

    @Provides
    @Singleton
    MovieCacheDataSource provideMovieCacheDataSource(){
        return new MovieCacheDataSourceImpl();
    }


}