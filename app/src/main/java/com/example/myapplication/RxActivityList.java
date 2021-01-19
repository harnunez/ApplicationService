package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.adapter.PersonajeAdapter;
import com.example.myapplication.model.Data;
import com.example.myapplication.model.Personaje;
import com.example.myapplication.services.WebServiceClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RxActivityList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonajeAdapter adapter;
    private List<Personaje> personajes;

    public Disposable disposable;

    @Inject
    public WebServiceClient client;

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

        client.getPersonajesObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Data>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(@NonNull Data data) {
                        adapter.setData(data.getResults());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("TAG1","Error RxActivityList" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG1","OnComplete");
                    }
                });

      //  Call<Data> call =  client.getPersonajes();
        //        call.enqueue(new Callback<Data>() {
        //            @Override
        //            public void onResponse(Call<Data> call, Response<Data> response) {
        //                adapter.setData(response.body().getResults());
        //            }
        //
        //            @Override
        //            public void onFailure(Call<Data> call, Throwable t) {
        //                Log.d("Error", "Error service getPersonaje" + t.getMessage());
        //            }
        //        });

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