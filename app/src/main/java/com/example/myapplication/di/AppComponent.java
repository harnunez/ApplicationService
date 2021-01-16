package com.example.myapplication.di;

import com.example.myapplication.DaggerActivity;
import com.example.myapplication.DaggerActivityOrdenado;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    RetrofitModule.class,
})
public interface AppComponent {

    void inject(DaggerActivity daggerActivity);
    void inject(DaggerActivityOrdenado daggerActivityOrdenado);
}
