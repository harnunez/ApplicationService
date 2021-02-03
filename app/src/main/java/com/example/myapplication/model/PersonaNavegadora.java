package com.example.myapplication.model;

import java.io.Serializable;

public class PersonaNavegadora implements Serializable {

    public String nombre;
    public String altura;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }
}
