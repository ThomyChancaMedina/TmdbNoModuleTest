package com.example.tmdbnomoduletest.presentation.di;


import com.example.tmdbnomoduletest.presentation.di.movie.MovieSubComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                CacheDataModule.class,
                RemoteDataModule.class,
                LocalDataModule.class,
                UseCaseModule.class,
                NetModule.class,
                DataBaseModule.class,
                RemoteDataModule.class
        }
)
public interface AppComponent {
        MovieSubComponent.Factory movieSubComponent();
}
