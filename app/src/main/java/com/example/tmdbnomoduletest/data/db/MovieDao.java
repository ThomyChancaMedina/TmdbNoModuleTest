package com.example.tmdbnomoduletest.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tmdbnomoduletest.data.model.Movie;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveMovies(List<Movie> movies);

    @Query("DELETE FROM popular_movies")
    void deleteAllMovies();

    @Query("SELECT * FROM popular_movies")
    Flowable<List<Movie>> getMovies();

}
