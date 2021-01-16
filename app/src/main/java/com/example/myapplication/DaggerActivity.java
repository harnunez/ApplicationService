package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.PersonajeAdapter;
import com.example.myapplication.model.Data;
import com.example.myapplication.model.Personaje;
import com.example.myapplication.services.WebServiceClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaggerActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private PersonajeAdapter adapter;
    private List<Personaje> personajes;

    @Inject
    WebServiceClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        injectarDagger();
        setUpView();
        lanzarPeticion();
    }

    private void injectarDagger(){
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
    }

    private void lanzarPeticion() {

        Call<Data> call =  client.getPersonajes();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                adapter.setData(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("Error", "Error service getPersonaje" + t.getMessage());
            }
        });

    }

    private void setUpView() {
        personajes = new ArrayList<>();
        adapter = new PersonajeAdapter(personajes);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);
    }

}
