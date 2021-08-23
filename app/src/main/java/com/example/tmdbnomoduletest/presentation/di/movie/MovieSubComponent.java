package com.example.tmdbnomoduletest.presentation.di.movie;


import com.example.tmdbnomoduletest.presentation.movie.MainActivity;

import dagger.Subcomponent;

@MovieScope
@Subcomponent(modules = {MovieModule.class})
public interface MovieSubComponent {

    void inject(MainActivity mainActivity);

    @Subcomponent.Factory
    interface Factory{
        public MovieSubComponent create();
    }

}
