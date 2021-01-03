package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.adapter.PersonajeAdapter;
import com.example.myapplication.model.Personaje;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class RetrofitActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private PersonajeAdapter adapter;
    private List<Personaje> personajes;

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClienBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        setUpView();
        lanzarPeticion();
    }

    private void lanzarPeticion() {
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClienBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
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