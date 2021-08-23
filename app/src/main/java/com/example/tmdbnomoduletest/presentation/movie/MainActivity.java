package com.example.tmdbnomoduletest.presentation.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.tmdbnomoduletest.R;
import com.example.tmdbnomoduletest.data.model.Movie;
import com.example.tmdbnomoduletest.presentation.di.Injector;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Inject
    public MovieViewModelFactory factory;

    MovieViewModel movieViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Injector) getApplication()).createMovieSubComponent().inject(this);

        displayPopularMovies();

    }

    private void displayPopularMovies() {


        movieViewModel= new ViewModelProvider(this,factory).get(MovieViewModel.class);

        movieViewModel.getMovies().subscribe(
                new Consumer<List<Movie>>() {
                    @Override
                    public void accept(List<Movie> movies) throws Exception {
                        Log.i("TAG", "accept: thomy>> "+movies);
                    }
                }
        );

    }
}