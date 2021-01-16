package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.di.AppComponent;
import com.example.myapplication.di.DaggerAppComponent;
import com.example.myapplication.di.RetrofitModule;

public class BaseApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
