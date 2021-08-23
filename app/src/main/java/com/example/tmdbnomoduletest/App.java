package com.example.tmdbnomoduletest;

import android.app.Application;

import com.example.tmdbnomoduletest.presentation.di.AppComponent;
import com.example.tmdbnomoduletest.presentation.di.AppModule;
import com.example.tmdbnomoduletest.presentation.di.DaggerAppComponent;
import com.example.tmdbnomoduletest.presentation.di.Injector;
import com.example.tmdbnomoduletest.presentation.di.NetModule;
import com.example.tmdbnomoduletest.presentation.di.RemoteDataModule;
import com.example.tmdbnomoduletest.presentation.di.movie.MovieSubComponent;


public class App extends Application implements Injector {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent =DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .netModule(new NetModule("https://api.themoviedb.org/3/"))
                .remoteDataModule(new RemoteDataModule(this.getString(R.string.api_key)))
                .build();



    }

    @Override
    public MovieSubComponent createMovieSubComponent() {
        return appComponent.movieSubComponent().create();
    }
}
