package com.example.tmdbnomoduletest.presentation.di;

import android.content.Context;

import androidx.room.Room;

import com.example.tmdbnomoduletest.data.db.MovieDao;
import com.example.tmdbnomoduletest.data.db.TMDBDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {
    @Provides
    @Singleton
    TMDBDatabase provideMovieDataBase(Context context){
        return Room.databaseBuilder(context,TMDBDatabase.class,"tmdbclient")
                .fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    MovieDao provideMovieDao(TMDBDatabase tmdbDatabase){
        return tmdbDatabase.moviesDao();
    }

}
