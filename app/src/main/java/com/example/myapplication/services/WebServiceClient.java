package com.example.myapplication.services;

import com.example.myapplication.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServiceClient {

    @GET("people")
    Call<Data>getPersonajes();
}
