package com.pruebas123.petagram;

import java.io.Serializable;

public class Mascota implements Serializable {
    private int imagen;
    private String nombre;
    private int calificacion;

    public Mascota(int imagen, String nombre, int calificacion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }





}
