package com.example.tmdbnomoduletest.presentation.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context=context;
    }

    @Singleton
    @Provides
    Context providerApplicationContext(){
        return context.getApplicationContext();
    }
}
