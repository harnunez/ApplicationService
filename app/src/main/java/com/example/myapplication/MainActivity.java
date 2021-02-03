package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Button btRetrofit;
    Button btRetrofitOrdenado;
    Button btDagger;
    Button btDaggerOrdenado;
    Button btRxList;

    @BindView(R.id.btn_nav)
    Button btnNavegacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupView();
    }

    private void setupView() {
        btRetrofit = findViewById(R.id.btRetrofit);
        btRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RetrofitActivity.class));
            }
        });

        btRetrofitOrdenado = findViewById(R.id.btRetrofitOrdenado);
        btRetrofitOrdenado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RetrofitOrdenadoActivity.class));
            }
        });

        btDagger = findViewById(R.id.btDagger);
        btDagger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DaggerActivity.class));
            }
        });

        btDaggerOrdenado = findViewById(R.id.btDaggerOrdenado);
        btDaggerOrdenado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DaggerActivityOrdenado.class));
            }
        });

        btRxList = findViewById(R.id.btRxList);
        btRxList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RxActivityList.class));
            }
        });

        btnNavegacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NavigationContainerActivity.class));
            }
        });
    }
}