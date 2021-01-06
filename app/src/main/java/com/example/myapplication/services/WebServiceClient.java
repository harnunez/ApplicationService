package com.example.myapplication.services;

import com.example.myapplication.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WebServiceClient {

    @GET("people")
    Call<Data>getPersonajes();

    @GET()
    Call<Data>getPersonajes(@Url String url);
}
