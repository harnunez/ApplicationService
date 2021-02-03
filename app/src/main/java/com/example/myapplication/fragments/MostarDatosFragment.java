package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.PersonaNavegadora;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MostarDatosFragment extends Fragment {

    @BindView(R.id.txt_valor_nombre)
    TextView nombreAMostrar;

    @BindView(R.id.txt_muestra_altura)
    TextView alturaAMostrar;

    @BindView(R.id.btn_irASaludo)
    Button irASaludo;

    PersonaNavegadora persona;

    boolean backValue = false;
    String condicion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_mostar_datos, container, false);
        ButterKnife.bind(this, viewRoot);
        return viewRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        System.out.println("Antes del valor persona");
        condicion = backValue ? "Es true" : "Es falso";
        System.out.println("Sali del ternario");

        persona = (PersonaNavegadora) getArguments().getSerializable("navegador");

        if(persona!=null){
            nombreAMostrar.setText(persona.getNombre());
            alturaAMostrar.setText(persona.getAltura());

            if(persona.getNombre()!=""){
                backValue = true;
            }

        }

        irASaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mostarDatosFragment_to_despedidaFragment);
            }
        });


    }
}