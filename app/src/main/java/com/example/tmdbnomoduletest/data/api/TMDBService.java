package com.example.tmdbnomoduletest.data.api;

import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.data.model.MovieList;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBService {

    @GET("movie/popular")
    Observable<List<Movie>> getPopularMovies(@Query("api_key") String apikey);

    @GET("tv/popular")
    Observable<MovieList> getPopularTvShows(@Query("api_key") String apikey);

    @GET("person/popular")
    Observable<MovieList> getPopularArtists(@Query("api_key") String apikey);

    @GET("movie/popular")
    Observable<MovieList> getReviews(@Query("api_key") String apikey);

}
