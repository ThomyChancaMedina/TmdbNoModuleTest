package com.example.tmdbnomoduletest.data.repository.movie.datasourceImpl;

import com.example.tmdbnomoduletest.data.db.MovieDao;
import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieLocalDataSource;

import java.util.List;

import io.reactivex.Flowable;

public class MovieLocalDataSourceImpl implements MovieLocalDataSource {

    private final MovieDao movieDao;

    public MovieLocalDataSourceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Flowable<List<Movie>> getMovies() {
        return movieDao.getMovies();
    }

    @Override
    public void saveMoviesToDB(List<Movie> movies) {
        movieDao.saveMovies(movies);
    }

    @Override
    public void clearAll() {
        movieDao.deleteAllMovies();
    }
}
