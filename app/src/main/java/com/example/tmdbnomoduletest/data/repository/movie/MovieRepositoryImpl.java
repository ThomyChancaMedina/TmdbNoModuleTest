package com.example.tmdbnomoduletest.data.repository.movie;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieCacheDataSource;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieLocalDataSource;
import com.example.tmdbnomoduletest.data.repository.movie.datasource.MovieRemoteDataSource;
import com.example.tmdbnomoduletest.domain.MovieRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MovieRepositoryImpl implements MovieRepository {
    private static final String TAG = MovieRepositoryImpl.class.getSimpleName();

    private final MovieRemoteDataSource movieRemoteDataSource;
    private final MovieLocalDataSource localDataSource;
    private final MovieCacheDataSource cacheDataSource;

    public MovieRepositoryImpl(MovieRemoteDataSource movieRemoteDataSource,
                               MovieLocalDataSource localDataSource,
                               MovieCacheDataSource cacheDataSource) {
        this.movieRemoteDataSource = movieRemoteDataSource;
        this.localDataSource = localDataSource;
        this.cacheDataSource = cacheDataSource;
    }

    @Override
    public Observable<List<Movie>> getMovies() {
        return getMoviesFromCache().toObservable();
    }


    @Override
    public Observable<List<Movie>> updateMovies() {
     return getMoviesFromAPI().doOnNext(new Consumer<List<Movie>>() {
          @Override
          public void accept(List<Movie> movies) throws Exception {
              Log.i(TAG, "accept: thomy>> "+Thread.currentThread().getId());
              localDataSource.clearAll();
              localDataSource.saveMoviesToDB(movies);
              cacheDataSource.saveMoviesToCache(movies);
          }
      });

    }


    private Observable<List<Movie>> getMoviesFromAPI() {
        return movieRemoteDataSource.getMovies().doOnNext(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movies) throws Exception {
                Log.i(TAG, "accept: thomy>> " + Thread.currentThread().getId());
            }
        }).map(new Function<List<Movie>, List<Movie>>() {
            @Override
            public List<Movie> apply(@NotNull List<Movie> movies) throws Exception {
                return movies;
            }
        });
    }

    private Flowable<List<Movie>> getMoviesFromDB() {
        return localDataSource.getMovies().take(1).flatMap((Function<List<Movie>, Flowable<List<Movie>>>) movies -> {
            if (!movies.isEmpty()) {
                return Flowable.just(movies);
            } else {
                return Flowable.empty();
            }
        }
        ).switchIfEmpty(
            getMoviesFromAPI().map(movies -> {
                localDataSource.saveMoviesToDB(movies);
                return movies;
            }).toFlowable(BackpressureStrategy.ERROR)
        );
    }

    private Flowable<List<Movie>> getMoviesFromCache(){
        return cacheDataSource.getMoviesFromCache().take(1).flatMap(new Function<List<Movie>, Flowable<List<Movie>>>(){
            @Override
            public Flowable<List<Movie>> apply(@NotNull List<Movie> movies) throws Exception {
                if (!movies.isEmpty()) {
                    return Flowable.just(movies);
                } else {
                    return Flowable.empty();
                }
            }
        }).switchIfEmpty(
                getMoviesFromDB().map(new Function<List<Movie>, List<Movie>>() {
                    @Override
                    public List<Movie> apply(@NotNull List<Movie> movies) throws Exception {
                        cacheDataSource.saveMoviesToCache(movies);
                        return movies;
                    }
                })
        );
    }

}
