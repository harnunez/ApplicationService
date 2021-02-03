package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.PersonaNavegadora;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InsertarDatosFragment extends Fragment {

    public static final String PASS_DATA ="navegador";

    @BindView(R.id.tvName)
    TextView nombre;

    @BindView(R.id.tvHeight)
    TextView altura;

    @BindView(R.id.btn_enviar_data)
    Button btnEnviarDatos;

    PersonaNavegadora persona;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_insertar_datos, container, false);
        ButterKnife.bind(this, viewRoot);

        return viewRoot;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        persona = new PersonaNavegadora();
        System.out.println("Completo el back");

        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                String nombreObtenido = nombre.getText().toString();
                String alturaObtenida = altura.getText().toString();

                persona.setNombre(nombreObtenido);
                persona.setAltura(alturaObtenida);

                bundle.putSerializable(PASS_DATA,persona);

                Navigation.findNavController(v).navigate(R.id.action_insertarDatosFragment_to_mostarDatosFragment,bundle);

            }
        });
    }
}