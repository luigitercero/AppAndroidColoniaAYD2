package com.example.luigitercero.appcolonia.Models;

import java.util.ArrayList;

public class Area {

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getLocalizacion() {
        return Localizacion;
    }

    public void setLocalizacion(String localizacion) {
        Localizacion = localizacion;
    }

    public String getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(String capacidad) {
        Capacidad = capacidad;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDimesiones() {
        return Dimesiones;
    }

    public void setDimesiones(String dimesiones) {
        Dimesiones = dimesiones;
    }

    public String getId() {
        return id;
    }

    private String id;
    private String Nombre ;
    private  String Descripcion ;
    private String Localizacion;
    private String Capacidad;
    private String Imagen;
    private String Dimesiones;


    public String getDimension() {
        return Dimesiones;
    }

    public void setDimension(String dimension) {
        Dimesiones = dimension;
    }


}
