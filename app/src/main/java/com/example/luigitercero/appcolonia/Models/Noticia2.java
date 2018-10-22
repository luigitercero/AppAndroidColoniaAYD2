package com.example.luigitercero.appcolonia.Models;

public class Noticia2 {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getUserId() {
        return UsuarioId;
    }

    public void setUserId(String userId) {
        UsuarioId = userId;
    }

    private int id;

    public Noticia2(String nombre, String descripcion, String userId) {
        Nombre = nombre;
        Descripcion = descripcion;
        UsuarioId = userId;
    }

    private String Nombre;
    private String Descripcion;
    private String UsuarioId;
}
