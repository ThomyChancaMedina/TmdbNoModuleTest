package com.example.tmdbnomoduletest.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tmdbnomoduletest.data.model.Movie;

@Database(
        entities = {Movie.class},
        version = 2,
        exportSchema = false
)

public abstract class TMDBDatabase extends RoomDatabase {
    public abstract MovieDao moviesDao();


}
